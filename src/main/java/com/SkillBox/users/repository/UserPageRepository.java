package com.SkillBox.users.repository;

import com.SkillBox.users.Entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Repository
public interface UserPageRepository extends PagingAndSortingRepository<User, UUID> {

    List<User> findUserByCurrentLocation(String currentLocation, Pageable pageable);


}
