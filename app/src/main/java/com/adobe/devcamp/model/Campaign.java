package com.adobe.devcamp.model;

import java.util.List;
import java.util.Objects;

public final class Campaign {
    private final String name;
    private final Long stratTime;
    private final Long endTime;
    private final Target target;
    private final Integer advertiserId;

    public Campaign(String name, Long stratTime, Long endTime, Target target, Integer advertiserId) {
        this.name = name;
        this.stratTime = stratTime;
        this.endTime = endTime;
        this.target = target;
        this.advertiserId = advertiserId;
    }

    public String getName() {
        return name;
    }

    public Long getStratTime() {
        return stratTime;
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
        Campaign campaign = (Campaign) o;
        return Objects.equals(name, campaign.name) &&
                Objects.equals(stratTime, campaign.stratTime) &&
                Objects.equals(endTime, campaign.endTime) &&
                Objects.equals(target, campaign.target) &&
                Objects.equals(advertiserId, campaign.advertiserId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stratTime, endTime, target, advertiserId);
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", stratTime=" + stratTime +
                ", endTime=" + endTime +
                ", target=" + target +
                ", advertiserId=" + advertiserId +
                '}';
    }

    public static class Target {
        private final Gender gender;
        private final List<Domain> interests;
        private final short minAge;
        private final short maxAge;

        public Target(Gender gender, List<Domain> interests, short minAge, short maxAge) {
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
                    gender == target.gender &&
                    Objects.equals(interests, target.interests);
        }

        @Override
        public int hashCode() {
            return Objects.hash(gender, interests, minAge, maxAge);
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
}
