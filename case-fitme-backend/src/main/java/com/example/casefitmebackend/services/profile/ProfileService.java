package com.example.casefitmebackend.services.profile;

import com.example.casefitmebackend.models.Profile;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface ProfileService extends CrudService<Profile, Integer> {
}
