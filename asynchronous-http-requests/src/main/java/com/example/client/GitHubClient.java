package com.example.client;

import com.example.model.Organizations;
import com.example.model.Repositories;
import com.example.model.User;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class GitHubClient {

    RestTemplate restTemplate = new RestTemplate();

    @Async
    public CompletableFuture<User> getUser(@PathVariable String username) throws Exception {
        User user = restTemplate
                .getForObject("https://api.github.com/users/{username}", User.class, username);
        Thread.sleep(2000L);
        return CompletableFuture.completedFuture(user);
    }

    @Async
    public CompletableFuture<List<Repositories>> getRepos(@PathVariable String username) throws Exception {
        Repositories[] user = restTemplate
                .getForObject("https://api.github.com/users/{username}/repos", Repositories[].class, username);
        Thread.sleep(2000L);
        return CompletableFuture.completedFuture(Arrays.asList(user));
    }


    @Async
    public CompletableFuture<List<Organizations>> getOrganizations(@PathVariable String username) throws Exception {
        Organizations[] user = restTemplate
                .getForObject("https://api.github.com/users/{username}/orgs", Organizations[].class, username);
        Thread.sleep(2000L);
        return CompletableFuture.completedFuture(Arrays.asList(user));
    }
}
