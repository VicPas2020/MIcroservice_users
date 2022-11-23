package com.SkillBox.users.service;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final Logger log = LoggerFactory.getLogger("UserController");


    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    @Transactional
    public Optional<User> findUserById(UUID uuid) {
        return userRepository.findById(uuid);
    }

    @Transactional
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Transactional
    public void updateUser(User user) throws Exception {

        if(isUserExists(user.getId())) {
            userRepository.save(user);
        } else {
            throw new Exception("User not found");
        }
    }
    @Transactional
    public void deleteUser(UUID uuid) throws Exception {

        if(isUserExists(uuid)) {
            userRepository.deleteById(uuid);
        } else {
            throw new Exception("User not found");
        }
    }

    private boolean isUserExists(UUID uuid) {

        Optional<User> userById = findUserById(uuid);
        return userById.isPresent();
    }

}
