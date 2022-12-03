package com.SkillBox.users.mappers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.dto.NewUserForPersistDTO;
import com.SkillBox.users.dto.UserForUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class); // for tests

    User dtoToUser(NewUserForPersistDTO newUserForPersistDTO);
    User dtoToUser(UserForUpdateDTO userForUpdateDTO);

    UserForUpdateDTO userToDTO(User user);
}
