package com.example.casefitmebackend.services.user;

import com.example.casefitmebackend.exceptions.UserAlreadyExistException;
import com.example.casefitmebackend.exceptions.UserNotFoundException;
import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
        public User findById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    public User findByUid(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Collection<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User add(User entity) {
        return userRepository.save(entity);
    }

    public User register(String uid, String name, String lastName) {
        if(userRepository.existsById(uid))
            throw new UserAlreadyExistException();

        User user = new User();
        user.setUid(uid);
        user.setFirst_name(name);
        //TODO: FIX THIS LASTNAME
        user.setLast_name(lastName);
        return userRepository.save(user);
    }

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }
}
