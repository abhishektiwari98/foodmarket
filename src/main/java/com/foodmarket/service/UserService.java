package com.foodmarket.service;

import com.foodmarket.common.Utils;
import com.foodmarket.exception.DuplicateUserException;
import com.foodmarket.model.User;
import com.foodmarket.repository.UserRepository;
import com.google.common.hash.Hashing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository; // Dependency injection from Spring

    /**
     * Registers a new user to the users table.
     * @param user user model object.
     * @return status indicate the result of registration.
     */
    public boolean createNewUser(User user) {
        // user is already validated when the request is made (using the annotation on model).

        // check if a user with the same email already exists.
        if (alreadyExists(user.getEmail())) {
            throw new DuplicateUserException("User already exists.");
        }

        userRepository.save(user);
        return true;
    }

    /**
     * Validates an existing user.
     *
     * @param email email address of the registered user.
     * @param password password of the user.
     * @return status indicating if the user is valid (registered).
     */
    public User validateUser(final String email, final String password) {
        Optional<User> user = userRepository.findById(email);
        if (!user.isPresent()) {
            return null;
        }

        final String storedPassword = user.get().getPassword();
        final String encryptedPassword = Utils.getPasswordHash(password);

        if (storedPassword.equals(encryptedPassword)) {
            return user.get();
        }

        return null;
    }

    private boolean alreadyExists(final String email) {
        Optional<User> user = userRepository.findById(email);
        return user.isPresent();
    }
}
