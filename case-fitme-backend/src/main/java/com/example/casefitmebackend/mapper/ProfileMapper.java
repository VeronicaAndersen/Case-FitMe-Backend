package com.example.casefitmebackend.mapper;

import com.example.casefitmebackend.models.Profile;
import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.models.Workout;
import com.example.casefitmebackend.models.dto.ProfileDto;
import com.example.casefitmebackend.services.user.UserService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class ProfileMapper {

    @Autowired
    private UserService userService;

    @Mapping(target = "user", source = "user.id")
    public abstract ProfileDto profileToProfileDto(Profile profile);

    @Mapping(target = "user", source = "user", qualifiedByName = "mapUserFromDto")
    public abstract Profile profileDtoToProfile(ProfileDto profileDto);

   @Mapping(target = "profile", source = "profile")
    public abstract Collection<ProfileDto> profileToProfileDto(Collection<Profile> profiles);

    @Named("mapUserFromDto")
    User mapUserFromDto(Integer userId){
        if (userId == null) return null;
        return userService.findById(userId);
    }
}
