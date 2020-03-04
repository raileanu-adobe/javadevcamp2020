package com.adobe.devcamp.model;

import java.util.Objects;
import java.util.List;
import java.util.Set;

public final class Publisher {
    private final String name;
    private final Set<Domain> domains;
    private final List<Integer> users;
    private final List<Integer> advertisers;

    public Publisher(String name, Set<Domain> domains, List<Integer> users, List<Integer> advertisers) {
        this.name = name;
        this.domains = domains;
        this.users = users;
        this.advertisers = advertisers;
    }

    public String getName() {
        return name;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public List<Integer> getAdvertisers() {
        return advertisers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return name.equals(publisher.name) &&
                domains.equals(publisher.domains) &&
                users.equals(publisher.users) &&
                advertisers.equals(publisher.advertisers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, domains, users, advertisers);
    }
}
