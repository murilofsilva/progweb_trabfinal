package com.ufms.progweb.services;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.ufms.progweb.model.User;
import com.ufms.progweb.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User searchById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User searchByName(String name) {
        return userRepository.findByName(name);
    }

    public User searchByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Iterable<User> searchAllUsers() {
        return userRepository.findAll();
    }
}
