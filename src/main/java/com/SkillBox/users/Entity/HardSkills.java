package com.SkillBox.users.Entity;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "hard_skills", schema = "users_scheme")
public class HardSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    UUID id;

    String hardSkill;
}
