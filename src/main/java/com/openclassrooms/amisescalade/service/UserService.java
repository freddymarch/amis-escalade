package com.openclassrooms.amisescalade.service;

import com.openclassrooms.amisescalade.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {

    Optional<String> addUser(User user);

    List<User> searchAllUser();

    User searchUserid(Long id);

    User findUserByEmail(String email);

}
