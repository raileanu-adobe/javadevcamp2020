package com.adobe.devcamp.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


public final class User {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final Profile profile;

    public User(String firstName, String lastName, String email, Profile profile) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.profile = profile;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Profile getProfile() {
        return profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return firstName.equals(user.firstName) &&
                lastName.equals(user.lastName) &&
                email.equals(user.email) &&
                profile.equals(user.profile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, profile);
    }

    public static class Profile{
        private final Gender gender;
        private final LocalDate dateOfBirth;
        private final List<Domain> interests;

        public Profile(Gender gender, LocalDate dateOfBirth, List<Domain> interests) {
            this.gender = gender;
            this.dateOfBirth = dateOfBirth;
            this.interests = interests;
        }

        public Gender getGender() {
            return gender;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        public List<Domain> getInterests() {
            return interests;
        }

        @Override
        public String toString() {
            return "Profile{" +
                    "gender=" + gender +
                    ", dateOfBirth=" + dateOfBirth +
                    ", interests=" + interests +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Profile profile = (Profile) o;
            return gender.equals(profile.gender) &&
                    dateOfBirth.equals(profile.dateOfBirth) &&
                    interests.equals(profile.interests);
        }

        @Override
        public int hashCode() {
            return Objects.hash(gender, dateOfBirth, interests);
        }
    }
}
