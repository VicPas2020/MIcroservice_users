package com.SkillBox.users.Entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "hard_skills", schema = "users_scheme")
public class HardSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;
    @Column(name = "hardskill")
    String hardSkill;

    public UUID getId() {
        return id;
    }

    public String getHardSkill() {
        return hardSkill;
    }

    @Override
    public String toString() {
        return "HardSkills{" +
                "id=" + id +
                ", hardSkill='" + hardSkill + '\'' +
                '}';
    }
}
