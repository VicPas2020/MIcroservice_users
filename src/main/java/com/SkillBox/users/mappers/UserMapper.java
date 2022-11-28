package com.SkillBox.users.mappers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToUser(UserDTO userDTO);
    UserDTO userToDTO(User user);
}
