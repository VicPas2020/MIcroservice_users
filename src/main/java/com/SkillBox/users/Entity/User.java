package com.SkillBox.users.Entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "user_profile", schema = "users_scheme")
@SQLDelete(sql = "UPDATE users_scheme.user_profile SET isdeleted = true WHERE id=?")
@Where(clause = "isdeleted=false")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "middlename")
    private String middleName;
    @Column(name = "gender")
    private Boolean gender;
    private String birthday; // maybe Date
    @Column(name = "currentlocation")
    private String currentLocation;
    @Column(name = "avatarlink")
    private String avatarLink;
    @Column(name = "personalinfo")
    private String personalInfo;
    private String nickname;
    private String email;
    private String phone;
    @Column(name = "isdeleted")
    private Boolean isDeleted;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_hard_skills", schema = "users_scheme",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "hard_skill_id")}
    )
    private Set<HardSkills> skills;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_subscriptions", schema = "users_scheme",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "subscriber_id")}
    )
    private Set<User> subscribers;

    public User() {
        this.isDeleted = false;
    }

    public User(UUID id,
                String firstName,
                String lastName,
                String middleName,
                Boolean gender,
                String birthday,
                String currentLocation,
                String avatarLink,
                String personalInfo,
                String nickname,
                String email,
                String phone,
                Boolean isDeleted) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthday = birthday;
        this.currentLocation = currentLocation;
        this.avatarLink = avatarLink;
        this.personalInfo = personalInfo;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.isDeleted = isDeleted;
    }

    public User(String firstName,
                String lastName,
                String middleName,
                Boolean gender,
                String birthday,
                String currentLocation,
                String avatarLink,
                String personalInfo,
                String nickname,
                String email,
                String phone,
                Boolean isDeleted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthday = birthday;
        this.currentLocation = currentLocation;
        this.avatarLink = avatarLink;
        this.personalInfo = personalInfo;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.isDeleted = isDeleted;
    }

    public User(String firstName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.birthday = birthday;
        this.currentLocation = currentLocation;
        this.avatarLink = avatarLink;
        this.personalInfo = personalInfo;
        this.nickname = nickname;
        this.email = email;
        this.phone = phone;
        this.skills = skills;
        this.subscribers = subscribers;
        this.isDeleted = isDeleted;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public String getAvatarLink() {
        return avatarLink;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public Set<HardSkills> getSkills() {
        return skills;
    }

    public Set<User> getSubscribers() {
        return subscribers;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setAvatarLink(String avatarLink) {
        this.avatarLink = avatarLink;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public void setSkills(Set<HardSkills> skills) {
        this.skills = skills;
    }

    public void setSubscribers(Set<User> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender=" + gender +
                ", birthday='" + birthday + '\'' +
                ", currentLocation='" + currentLocation + '\'' +
                ", avatarLink='" + avatarLink + '\'' +
                ", personalInfo='" + personalInfo + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", isdeleted=" + isDeleted +
                '}';
    }
}
