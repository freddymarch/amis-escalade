package com.openclassrooms.amisescalade.service.impl;

import com.openclassrooms.amisescalade.model.Topo;
import com.openclassrooms.amisescalade.model.User;
import com.openclassrooms.amisescalade.repository.RoleRepository;
import com.openclassrooms.amisescalade.repository.UserRepository;
import com.openclassrooms.amisescalade.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Optional<String> addUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByCode("Member"));
        userRepository.save(user);
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @Override
    public User findUserByEmail(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        return optionalUser.isPresent() ? optionalUser.get() : null;
    }

    @Override
    public User fundUserByName(String name) {
        Optional<User> optionalUser = userRepository.findByName(name);
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email)
            throws UsernameNotFoundException, DataAccessException {
        User user = findUserByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email + " non trouvé");
        }
        return user;
    }

}
