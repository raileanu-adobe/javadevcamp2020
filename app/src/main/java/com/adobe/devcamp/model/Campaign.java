package com.adobe.devcamp.model;

import java.util.List;
import java.util.Objects;

public class Campaign {
    public final String name;
    public final Long startTime;

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", target=" + target +
                ", advertiserId=" + advertiserId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(name, campaign.name) &&
                Objects.equals(startTime, campaign.startTime) &&
                Objects.equals(endTime, campaign.endTime) &&
                Objects.equals(target, campaign.target) &&
                Objects.equals(advertiserId, campaign.advertiserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, startTime, endTime, target, advertiserId);
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

    public Campaign(String name, Long startTime, Long endTime, Target target, Integer advertiserId) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.target = target;
        this.advertiserId = advertiserId;
    }

    public final Long endTime;
    public final Target target;

    // int e tipul primar de date - Integer are functii implementate deja si accepta si da exceptie la null
    private final Integer advertiserId;


    public static class Target {
        @Override
        public String toString() {
            return "Target{" +
                    "gender=" + gender +
                    ", interests=" + interests +
                    ", minAge=" + minAge +
                    ", maxAge=" + maxAge +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Target target = (Target) o;
            return minAge == target.minAge &&
                    maxAge == target.maxAge &&
                    gender == target.gender &&
                    Objects.equals(interests, target.interests);
        }

        @Override
        public int hashCode() {
            return Objects.hash(gender, interests, minAge, maxAge);
        }

        public final Gender gender;
        public final List<Domain> interests;
        public final short minAge;
        public final short maxAge;

        public Gender getGender() {
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

        public Target(Gender gender, List<Domain> interests, short minAge, short maxAge) {
            this.gender = gender;
            this.interests = interests;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }
    }
}
