package com.disqo.bestnote.security.service;

import com.disqo.bestnote.user.User;
import com.disqo.bestnote.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private final UserService userService;

    public CustomUserDetailService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userService.getUserById(userEmail);
        CustomUserDetails userDetails = new CustomUserDetails();
        if(user != null) {
            userDetails.setUser(user);
            return userDetails;
        } else {
            throw new UsernameNotFoundException("User does not exists with email: " + userEmail);
        }

    }
}
