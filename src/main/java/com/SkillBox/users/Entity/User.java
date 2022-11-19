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

    UUID id;
    @Column(name = "firstname")
    String  firstName;
    @Column(name = "lastname")
    String  lastName;
    @Column(name = "middlename")
    String  middleName;
    @Column(name = "gender")
    Boolean gender;
    String  birthday; // maybe Date
    String  currentLocation;
    String  avatarLink;
    String  personalInfo;
    String  nickname;
    String  email;
    String  phone;
    @Column(name = "isdeleted")
    Boolean isDeleted;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_hard_skills",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "hard_skill_id") }
    )
    Set<HardSkills> skills;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_subscriptions",
            joinColumns = { @JoinColumn(name = "user_id") },
            inverseJoinColumns = { @JoinColumn(name = "subscriber_id") }
    )
    Set<User> subscribers;


    public Set<HardSkills> getSkills() {
        return skills;
    }


    public Set<User> getSubscribers() {
        return subscribers;
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
