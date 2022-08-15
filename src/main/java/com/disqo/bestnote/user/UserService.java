package com.disqo.bestnote.user;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(@NonNull String emailId) {
        Optional<User> userOptional = userRepository.findById(emailId);
        return userOptional.orElse(null);
    }

    public void registerUser(User user) {
        userRepository.saveAndFlush(user);
    }
}
