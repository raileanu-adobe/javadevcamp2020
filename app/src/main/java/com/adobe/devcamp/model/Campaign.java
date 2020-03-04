package com.adobe.devcamp.model;

import java.util.List;
import java.util.Objects;

public final class Campaign {
    private final String name;
    private final Long startTime;
    private final Long endTime;
    private final Target target;
    private final Integer advertiseId;

    public Campaign(String name, Long startTime, Long endTime, Target target, Integer advertiseId) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.target = target;
        this.advertiseId = advertiseId;
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

    public Integer getAdvertiseId() {
        return advertiseId;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "name='" + name + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", target=" + target +
                ", advertiseId=" + advertiseId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Campaign campaign = (Campaign) o;
        return Objects.equals(getName(), campaign.getName()) &&
                Objects.equals(getStartTime(), campaign.getStartTime()) &&
                Objects.equals(getEndTime(), campaign.getEndTime()) &&
                Objects.equals(getTarget(), campaign.getTarget()) &&
                Objects.equals(getAdvertiseId(), campaign.getAdvertiseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStartTime(), getEndTime(), getTarget(), getAdvertiseId());
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
            return getMinAge() == target.getMinAge() &&
                    getMaxAge() == target.getMaxAge() &&
                    getGender() == target.getGender() &&
                    Objects.equals(getInterests(), target.getInterests());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getGender(), getInterests(), getMinAge(), getMaxAge());
        }
    }
}
