package com.example.casefitmebackend.services.user;

import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudService<User, Integer> {
}
