package java.com.adobe.devcamp.model;

import java.util.List;
import java.util.Set;

public final class Publisher {
    private final String name;
    private final Set<Domain> domains;
    private final List<Integer> users;
    private final List<Integer> adevrtisers;

    public String getName() {
        return name;
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public List<Integer> getUsers() {
        return users;
    }

    public List<Integer> getAdevrtisers() {
        return adevrtisers;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Publisher publisher = (Publisher) object;
        return name.equals(publisher.name) &&
                domains.equals(publisher.domains) &&
                users.equals(publisher.users) &&
                adevrtisers.equals(publisher.adevrtisers);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, domains, users, adevrtisers);
    }

    public Publisher(String name, Set<Domain> domains, List<Integer> users, List<Integer> adevrtisers) {
        this.name = name;
        this.domains = domains;
        this.users = users;
        this.adevrtisers = adevrtisers;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", domains=" + domains +
                ", users=" + users +
                ", adevrtisers=" + adevrtisers +
                '}';
    }
}
