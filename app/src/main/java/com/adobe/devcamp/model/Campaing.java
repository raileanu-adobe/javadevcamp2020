package com.adobe.devcamp.model;

import java.util.List;
import java.util.Objects;

public final class Campaing {

    private final String name;
    private final Long startTime;
    private final Long endTime;
    private final Target target;
    private final Integer advertiserId;

    public static class Target {
        private final String gender;
        private final List<Domain> interests;
        private final short minAge;
        private final short maxAge;

        public Target(String gender, List<Domain> interests, short minAge, short maxAge) {
            this.gender = gender;
            this.interests = interests;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public String getGender() {
            return gender;
        }

        public List<Domain> getInterests() {
            return interests;
        }

        public short getMinAge() {
            return minAge;
        }

        public short getMaxAge() {
            return maxAge;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Target target = (Target) o;
            return minAge == target.minAge &&
                    maxAge == target.maxAge &&
                    Objects.equals(gender, target.gender) &&
                    Objects.equals(interests, target.interests);
        }

        @Override
        public int hashCode() {
            return Objects.hash(gender, interests, minAge, maxAge);
        }

        @Override
        public String toString() {
            return "Target{" +
                    "gender='" + gender + '\'' +
                    ", interests=" + interests +
                    ", minAge=" + minAge +
                    ", maxAge=" + maxAge +
                    '}';
        }
    }

    public Campaing(String name, Long startTime, Long endTime, Target target, Integer advertiserId) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.target = target;
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public Long getStartTime() {
        return startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public Target getTarget() {
        return target;
    }

    public Integer getAdvertiserId() {
        return advertiserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaing campaing = (Campaing) o;
        return Objects.equals(name, campaing.name) &&
                Objects.equals(startTime, campaing.startTime) &&
                Objects.equals(endTime, campaing.endTime) &&
                Objects.equals(target, campaing.target) &&
                Objects.equals(advertiserId, campaing.advertiserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startTime, endTime, target, advertiserId);
    }

    @Override
    public String toString() {
        return "Campaing{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", target=" + target +
                ", advertiserId=" + advertiserId +
                '}';
    }
}
