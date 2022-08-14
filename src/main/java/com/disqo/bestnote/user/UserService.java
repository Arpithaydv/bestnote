package com.disqo.bestnote.user;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserEntityRepository userEntityRepository;

    public UserService(UserEntityRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public List<UserEntity> getAllUsers() {
        return userEntityRepository.findAll();
    }

}
