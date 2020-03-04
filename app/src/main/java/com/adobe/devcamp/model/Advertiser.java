package java.com.adobe.devcamp.model;

import java.util.List;

public final class Advertiser<provate> {
    private final String name;
    private final List<Integer> publishers;

    public String getName() {
        return name;
    }

    public List<Integer> getPublishers() {
        return publishers;
    }

    public Advertiser(String name, List<Integer> publishers) {
        this.name = name;
        this.publishers = publishers;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Advertiser that = (Advertiser) object;
        return name.equals(that.name) &&
                publishers.equals(that.publishers);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), name, publishers);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Advertiser{" +
                "name='" + name + '\'' +
                ", publishers=" + publishers +
                '}';
    }
}
