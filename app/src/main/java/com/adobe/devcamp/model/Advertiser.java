package com.adobe.devcamp.model;

import java.util.List;
import java.util.Objects;

public final class Advertiser {
    private final String name;
    private final List<Integer> publicshers;

    public Advertiser(String name, List<Integer> publicshers) {
        this.name = name;
        this.publicshers = publicshers;
    }

    public String getName() {
        return name;
    }

    public List<Integer> getPublicshers() {
        return publicshers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Advertiser that = (Advertiser) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(publicshers, that.publicshers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, publicshers);
    }

    @Override
    public String toString() {
        return "Advertiser{" +
                "name='" + name + '\'' +
                ", publicshers=" + publicshers +
                '}';
    }

}
