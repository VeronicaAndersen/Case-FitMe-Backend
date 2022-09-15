package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.models.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.Collection;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Mapping(target="profile", source="profile.id")
    public abstract UserDto userToUserDto(User user);

    @Mapping(target="profile.id", source="profile")
    public abstract User userDtoToUser(UserDto dto);

    public abstract Collection<UserDto> userToUserDto(Collection<User> users);
}
