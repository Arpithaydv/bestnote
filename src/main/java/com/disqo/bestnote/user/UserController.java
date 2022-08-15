package com.disqo.bestnote.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1")
public class UserController {
    private final UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @PostMapping(value = "/addUser")
    public void registerUser(@RequestBody UserDTO userDTO) {
        String encryptedPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(encryptedPassword);
        userService.registerUser(userDTO.toEntity());
    }
}
