package com.SkillBox.users.mappers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.dto.UserDTO;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class UserMapperTest {

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
        UserDTO userDTO = UserMapper.INSTANCE.userToDTO(user);

        //then
        assertThat( userDTO ).isNotNull();
        assertThat( userDTO.getFirstName()).isEqualTo( "Petroff" );
        assertThat( userDTO.getLastName() ).isEqualTo( "Ivan" );
        assertThat( userDTO.getCurrentLocation() ).isEqualTo( "Moscow" );

        //given
        final UserDTO existedUser = new UserDTO(
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