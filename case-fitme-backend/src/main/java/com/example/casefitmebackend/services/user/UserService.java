package com.example.casefitmebackend.services.user;

import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends CrudService<User, String> {
    User register(String uid, String name);
    User findByUid(String uid);
}
