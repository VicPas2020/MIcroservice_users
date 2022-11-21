package com.SkillBox.users.controllers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    //private final Logger logger = LoggerFactory.getLogger("UserController");

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllUsers() {
        List<User> all = userService.findAllUsers();
        return new ResponseEntity<>("Users: " + all, HttpStatus.OK);
    }

    @GetMapping(path = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUserById(@PathVariable UUID uuid) {

        Optional<User> byId = userService.findUserById(uuid);

        return byId.map(user -> new ResponseEntity<>("User: " + user, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("User: " + uuid, HttpStatus.NOT_FOUND));

    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>("Saved OK UserId: " + user.getId(), HttpStatus.OK);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestBody User user) {

        try {
            userService.updateUser(user);
            return new ResponseEntity<>("Updated OK: " + user.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND : " + user.getId(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteUser(@PathVariable UUID uuid) {

        try {
            userService.deleteUser(uuid);
            return new ResponseEntity<>("User with id " + uuid + " deleted OK: ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("UUID: " + uuid + " NOT FOUND ", HttpStatus.NOT_FOUND);
        }
    }
}