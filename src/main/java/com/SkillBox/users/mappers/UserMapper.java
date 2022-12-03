package com.SkillBox.users.mappers;

import com.SkillBox.users.Entity.User;
import com.SkillBox.users.dto.NewUserForPersistDTO;
import com.SkillBox.users.dto.UserForUpdateDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class); // for tests

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "skills", ignore = true)
    @Mapping(target = "subscribers", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    User dtoToUser(NewUserForPersistDTO newUserForPersistDTO);

    @Mapping(target = "skills", ignore = true)
    @Mapping(target = "subscribers", ignore = true)
    @Mapping(target = "deleted", ignore = true)
    User dtoToUser(UserForUpdateDTO userForUpdateDTO);

    UserForUpdateDTO userToDTO(User user);
}
