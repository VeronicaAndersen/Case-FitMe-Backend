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

    @Mapping(target = "user", source = "user", qualifiedByName = "userToId")
    public abstract ProfileDto profileToProfileDto(Profile profile);

    @Mapping(target = "user", source = "user", qualifiedByName = "setIdToUser")
    public abstract Profile profileDtoToProfile(ProfileDto profileDto);

   @Mapping(target = "profile", source = "profile")
    public abstract Collection<ProfileDto> profileToProfileDto(Collection<Profile> profiles);

    @Named("setIdToUser")
    User mapIdToUser(String uid) {
        return userService.findByUid(uid);
    }

    @Named("userToId")
    String mapUserToId(User user) {
        if(user ==null)
            return null;
        return user.getUid();
    }
}
