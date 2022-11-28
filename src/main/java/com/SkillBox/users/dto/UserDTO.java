package com.SkillBox.users.dto;

public class UserDTO {

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

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String middleName, Boolean gender, String birthday, String currentLocation, String avatarLink, String personalInfo, String nickname, String email, String phone, Boolean isDeleted) {
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
                "firstName='" + firstName + '\'' +
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
