package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Profile;
import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.models.dto.UserDto;
import com.example.casefitmebackend.services.profile.ProfileService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

    @Autowired
    private ProfileService profileService;

    @Mapping(target="profile", source="profile.id")
    public abstract UserDto userToUserDto(User user);

    @Mapping(target="profile.id", source="profile")
    public abstract User userDtoToUser(UserDto dto);

    public abstract Collection<UserDto> userToUserDto(Collection<User> users);
}
