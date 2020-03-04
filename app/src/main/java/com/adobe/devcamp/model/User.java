package java.com.adobe.devcamp.model;

import java.time.LocalDate;
import java.util.List;

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

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        User user = (User) object;
        return java.util.Objects.equals(firstName, user.firstName) &&
                java.util.Objects.equals(lastName, user.lastName) &&
                java.util.Objects.equals(email, user.email) &&
                java.util.Objects.equals(profile, user.profile);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), firstName, lastName, email, profile);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                '}';
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
    }
}
