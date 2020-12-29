package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<String> addUser(User user);

    User findUserByEmail(String email);

}
