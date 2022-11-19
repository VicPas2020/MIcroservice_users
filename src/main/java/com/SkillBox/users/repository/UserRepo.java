package com.SkillBox.users.repository;

import com.SkillBox.users.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepo extends JpaRepository<User, UUID> {

    User findUserByCurrentLocation(String currentLocation);



}
