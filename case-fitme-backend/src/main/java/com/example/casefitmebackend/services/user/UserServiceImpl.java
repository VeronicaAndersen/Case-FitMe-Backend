package com.example.casefitmebackend.services.user;

import com.example.casefitmebackend.exceptions.UserNotFoundException;
import com.example.casefitmebackend.models.User;
import com.example.casefitmebackend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Fully functioning ServiceImpl. Use this as template
 */
@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Integer id) {
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

    @Override
    public User update(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}
