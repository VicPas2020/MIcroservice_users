package com.SkillBox.users.dto;

import com.SkillBox.users.Entity.HardSkills;
import com.SkillBox.users.Entity.User;

import java.util.Set;

public class NewUserForPersistDTO {
    private String firstName;
    private String lastName;
    private String middleName;
    private Boolean gender;
    private String birthday;
    private String currentLocation;
    private String avatarLink;
    private String personalInfo;
    private String nickname;
    private String email;
    private String phone;
    private Boolean isDeleted;
    private Set<HardSkills> skills;
    private Set<User> subscribers;

    public NewUserForPersistDTO() {
        this.isDeleted = false; // Решает проблему ошибки isDeleted=null в объекте UserForUpdateDTO
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

    @Override
    public String toString() {
        return "UserDTO{" +
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
                ", isDeleted=" + isDeleted +
                '}';
    }
}
