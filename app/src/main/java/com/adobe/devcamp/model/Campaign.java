package com.adobe.devcamp.model;

import java.util.List;
import java.util.Objects;

public class Campaign {
    private final String name;
    private final Long startTime;
    private final Long endTime;
    private final Target target;
    private final List<Integer> advertiserId;

    public static class Target {
        public final Gender gender;
        public final List<Domain> interests;
        public final Short minAge;
        public final Short maxAge;

        public Target(Gender gender, List<Domain> interests, Short minAge, Short maxAge) {
            this.gender = gender;
            this.interests = interests;
            this.minAge = minAge;
            this.maxAge = maxAge;
        }

        public Gender getGender() {
            return gender;
        }

        public List<Domain> getInterests() {
            return interests;
        }

        public Short getMinAge() {
            return minAge;
        }

        public Short getMaxAge() {
            return maxAge;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Target target = (Target) o;
            return getGender() == target.getGender() &&
                    Objects.equals(getInterests(), target.getInterests()) &&
                    Objects.equals(getMinAge(), target.getMinAge()) &&
                    Objects.equals(getMaxAge(), target.getMaxAge());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getGender(), getInterests(), getMinAge(), getMaxAge());
        }

        @Override
        public String toString() {
            return "Target{" +
                    "gender=" + gender +
                    ", interests=" + interests +
                    ", minAge=" + minAge +
                    ", maxAge=" + maxAge +
                    '}';
        }
    }

    public Campaign(String name, Long startTime, Long endTime, Target target, List<Integer> advertiserId) {
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

    public List<Integer> getAdvertiserId() {
        return advertiserId;
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
}
