package com.example.controller;

import com.example.client.GitHubClient;
import com.example.model.Organizations;
import com.example.model.Repositories;
import com.example.model.User;
import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class Controller {

    @Autowired
    GitHubClient gitHubClient;

    Logger logger = LoggerFactory.getLogger(Controller.class);

    @RequestMapping(value = "/github/{username}")
    User getUser(@PathVariable String username) throws Exception {
        Stopwatch stopwatch = Stopwatch.createStarted();


        CompletableFuture<User> maybeUser = gitHubClient.getUser(username);
        CompletableFuture<List<Repositories>> maybeRepos  = gitHubClient.getRepos(username);
        CompletableFuture<List<Organizations>> maybeOrgs  = gitHubClient.getOrganizations(username);

        CompletableFuture.allOf(maybeUser, maybeRepos, maybeOrgs).join();

        User user = maybeUser.get();
        user.setRepositories(maybeRepos.get());
        user.setOrganizations(maybeOrgs.get());

        stopwatch.stop();
        logger.info("All request completed in " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

        return user;
    }
}
