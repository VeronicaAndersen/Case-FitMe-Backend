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

    @Mapping(target="profile", source="profile", qualifiedByName = "profileToId")
    public abstract User userToUserDto(User user);

    public abstract Collection<UserDto> userToUserDto(Collection<User> users);

    @Mapping(target = "profile", source = "profile", qualifiedByName = "idToProfile")
    public abstract User userDtoToUser(UserDto UserDto);

    @Named("profileToId")
    public Integer mapProfileToId (Profile profile) {
        if (profile == null) return null;
        return profile.getId();
    }

    @Named("idToProfile")
    public Profile mapIdToProfile(Integer id){
        if(id == null) return null;
        return profileService.findById(id);
    }
}
