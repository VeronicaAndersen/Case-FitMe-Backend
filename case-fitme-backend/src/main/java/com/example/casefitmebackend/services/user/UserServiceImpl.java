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

    /**
     * Get a specific user by uid.
     * @param id is the uid of the user you want to get.
     * @return the user which id matches the parameters.
     */
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

    /**
     * Register a user
     * @param uid is the id of the user you want to register.
     * @param name is the first name of the user.
     * @param lastName is the lastname of the user.
     * @return the saved user.
     */
    public User register(String uid, String name, String lastName) {
        if(userRepository.existsById(uid))
            throw new UserAlreadyExistException();

        User user = new User();
        user.setUid(uid);
        user.setFirstName(name);
        //TODO: FIX THIS LASTNAME
        user.setLastName(lastName);
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
