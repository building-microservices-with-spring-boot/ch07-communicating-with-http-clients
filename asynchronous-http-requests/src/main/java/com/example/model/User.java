package com.example.model;

import java.util.List;

public class User {
    private String id;
    private String login;
    private String location;


    private List<Repositories> repositories;

    private List<Organizations> organizations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Repositories> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<Repositories> repositories) {
        this.repositories = repositories;
    }

    public List<Organizations> getOrganizations() {
        return organizations;
    }

    public void setOrganizations(List<Organizations> organizations) {
        this.organizations = organizations;
    }
}
