package com.SkillBox.users.controllers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.dto.UserDTO;
import com.SkillBox.users.mappers.UserMapper;
import com.SkillBox.users.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    //private final Logger logger = LoggerFactory.getLogger("UserController");

    private final UserService userService;

    final
    UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Operation(summary = "Получение списка всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Users not found",
                    content = @Content) })
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDTO>> getAllUsers() {

        List<User> all = userService.findAllUsers();
        List<UserDTO> allDto = new ArrayList<>();

        for (User dto: all) {
            allDto.add(userMapper.userToDTO(dto));
        }
        return new ResponseEntity<>(allDto, HttpStatus.OK);
    }


    @Operation(summary = "Получение одного пользователя по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Found the user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = List.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content) })
    @GetMapping(path = "/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDTO> getUserById(@PathVariable UUID uuid) {

        Optional<User> byId = userService.findUserById(uuid);
        if(byId.isPresent()){
            UserDTO userDTO = userMapper.userToDTO(byId.get());
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND); //TODO наверное не не нормально возвращать null, но какое DTO подставить не понятно

    }

    @Operation(summary = "Добавление одного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Added users"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content)})

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> saveUser(@RequestBody UserDTO userDto) {

        User user = userMapper.dtoToUser(userDto);
        userService.saveUser(user);
        return new ResponseEntity<>("Saved OK UserId: " + user.getId(), HttpStatus.OK);
    }


    @Operation(summary = "Изменение одного пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Changed users"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content)})
    @PutMapping(path = "/{uuid}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateUser(@RequestBody UserDTO userDto) {

        try {
            User user = userMapper.dtoToUser(userDto);
            userService.updateUser(user);
            return new ResponseEntity<>("Updated OK: " + userDto.getId(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("NOT FOUND : " + userDto.getId(), HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Удаление одного пользователя по id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Deleted users"),
            @ApiResponse(responseCode = "400", description = "Bad request",
                    content = @Content)})
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