package com.example.casefitmebackend.services.profile;

import com.example.casefitmebackend.exceptions.ProfileNotFoundException;
import com.example.casefitmebackend.models.Profile;
import com.example.casefitmebackend.repositories.ProfileRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfileServiceImpl implements ProfileService{
    private ProfileRepository profileRepository;

    public ProfileServiceImpl(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }
    @Override
    public Profile findById(Integer id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
    }

    @Override
    public Collection<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    public Profile add(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public Profile update(Profile entity) {
        return profileRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        profileRepository.deleteById(id);
    }
}
