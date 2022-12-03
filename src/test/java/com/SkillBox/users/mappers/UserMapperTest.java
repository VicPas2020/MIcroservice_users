package com.SkillBox.users.mappers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.dto.UserForUpdateDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@SpringBootTest
class UserMapperTest {

    @Autowired
    UserMapper userMapper;


    @Test
    public void shouldMapUserToDto() {
        //given
        final User user = new User(
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

        //when
        UserForUpdateDTO userForUpdateDTO = UserMapper.INSTANCE.userToDTO(user);
//        UserDTO userDTO = userMapper.userToDTO(user);

        //then
        assertThat(userForUpdateDTO).isNotNull();
        assertThat( userForUpdateDTO.getFirstName()).isEqualTo( "Petroff" );
        assertThat( userForUpdateDTO.getLastName() ).isEqualTo( "Ivan" );
        assertThat( userForUpdateDTO.getCurrentLocation() ).isEqualTo( "Moscow" );

        //given
        final UserForUpdateDTO existedUser = new UserForUpdateDTO(
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
        //when
        User user2 = UserMapper.INSTANCE.dtoToUser(existedUser);
        //then
        assertThat( user2 ).isNotNull();
        assertThat( user2.getFirstName()).isEqualTo( "Petroff" );
        assertThat( user2.getLastName() ).isEqualTo( "Ivan" );
        assertThat( user2.getCurrentLocation() ).isEqualTo( "Moscow" );
    }
}