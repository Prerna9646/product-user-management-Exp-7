package com.example.experiment_7.service;

import com.example.experiment_7.DTO.UserDTO;
import com.example.experiment_7.model.User;
import com.example.experiment_7.repository.UserRepository;
import com.example.experiment_7.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    final private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    private UserRepository userRepository;

    public UserDTO registerUser(UserDTO userDTO) {
        User user = mapToEntity(userDTO);
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User savedUser = userRepository.save(user);
        return mapToDTO(savedUser);
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDTO> getUserById(long id) {
        return userRepository.findById(id).map(this::mapToDTO);
    }

    public boolean deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<UserDTO> updateUser(long id, UserDTO userDTO) {
        return userRepository.findById(id).map(existingUser -> {
            existingUser.setName(userDTO.getName());
            existingUser.setEmail(userDTO.getEmail());
            existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            existingUser.setMobile(userDTO.getMobile());

            User updatedUser = userRepository.save(existingUser);
            return mapToDTO(updatedUser);
        });
    }

    public String login(String email, String password, JwtUtil jwtUtil) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(email);
    }


    private User mapToEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setMobile(dto.getMobile());
        return user;
    }

    private UserDTO mapToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setMobile(user.getMobile());
        return dto;
    }
}
