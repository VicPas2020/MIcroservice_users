package com.SkillBox.users.service;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class UserServiceTest {

    private final User existedUser = new User(
            "Petroff",
            "Ivan",
            "Sidorovich",
            true,
            "01.01.2000",
            "Moscow",
            "http://avatars.com/random/123",
            "Some personal info",
            "Bojor",
            "petroff@mail.ru",
            "+7(951)125-15-15",
            false);

    private final User updatedUser = new User(
            "Petroff++",
            "Ivan",
            "Sidorovich",
            true,
            "01.01.2000",
            "Moscow",
            "http://avatars.com/random/123",
            "Some personal info",
            "Bojor",
            "petroff@mail.ru",
            "+7(951)125-15-15",
            false);

    private final User existedUserWithId = new User(
            UUID.fromString("039fb3b6-6693-11ed-9022-0242ac120002"),
            "Petroff",
            "Ivan",
            "Sidorovich",
            true,
            "01.01.2000",
            "Moscow",
            "http://avatars.com/random/123",
            "Some personal info",
            "Bojor",
            "petroff@mail.ru",
            "+7(951)125-15-15",
            false);

    @Test
    void findAllUsers() {
        // given

        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);
        //when
        Mockito
                .when(userService.findAllUsers())
                .thenReturn(Collections.emptyList());
        List<User> allUsers = userService.findAllUsers();

        //then
        Assertions.assertEquals(Collections.emptyList(), allUsers);
    }

    @Test
    void findUserById() {

        // given
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserService(userRepository);

        //when
        Mockito
                .when(userService.findUserById(UUID.fromString("039fb3b6-6693-11ed-9022-0242ac120002")))
                .thenReturn(java.util.Optional.of(existedUser));

        Optional<User> userById = userService.findUserById(UUID.fromString("039fb3b6-6693-11ed-9022-0242ac120002"));

        //then
        userById.ifPresent(user -> Assertions.assertEquals(existedUser, user));
    }

    @Test
    void saveUser() {

        UserService userService = Mockito.mock(UserService.class);
        doNothing().when(userService).saveUser(existedUser);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        userService.saveUser(existedUser);
        verify(userService).saveUser(captor.capture());

        User user = captor.getValue();

        assertEquals("Petroff", user.getFirstName());
    }

    @Test
    void updateUser() throws Exception {

        UserService userService = Mockito.mock(UserService.class);

        doNothing().when(userService).updateUser(updatedUser);

        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);

        userService.updateUser(updatedUser);
        verify(userService).updateUser(captor.capture());

        User user = captor.getValue();

        assertEquals("Petroff++", user.getFirstName());
    }

    @Test
    void deleteUser() throws Exception {

        UserService userService = Mockito.mock(UserService.class);

        UUID uuid = UUID.fromString("039fb3b6-6693-11ed-9022-0242ac120002");
        doNothing().when(userService).deleteUser(uuid);

        ArgumentCaptor<UUID> captor = ArgumentCaptor.forClass(UUID.class);

        userService.deleteUser(uuid);
        verify(userService).deleteUser(captor.capture());

        UUID capUuid = captor.getValue();

        assertEquals(uuid, capUuid);
    }
}