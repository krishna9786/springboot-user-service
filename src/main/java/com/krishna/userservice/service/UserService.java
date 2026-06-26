package com.krishna.userservice.service;

import com.krishna.userservice.entity.User;
import com.krishna.userservice.exception.UserAlreadyExistsException;
import com.krishna.userservice.exception.UserNotFoundException;
import com.krishna.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.krishna.userservice.dto.UserRequestDto;
import com.krishna.userservice.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.krishna.userservice.security.JwtService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public User createUser(User user) {

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(
                    "User with email already exists"
            );
        }

        user.setPassword(
                passwordEncoder.encode(user.getPassword())
        );

        return userRepository.save(user);
    }

    public Page<User> getAllUsers(
            int page,
            int size,
            String sortBy) {

        return userRepository.findAll(
                PageRequest.of(
                        page,
                        size,
                        Sort.by(sortBy)
                )
        );
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() ->
                        new UserNotFoundException("User not found"));
    }

    public User updateUser(Long id, User updatedUser) {

        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserResponseDto createUser(UserRequestDto request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .build();

        User savedUser = userRepository.save(user);

        return UserResponseDto.builder()
                .id(savedUser.getId())
                .name(savedUser.getName())
                .email(savedUser.getEmail())
                .build();
    }

    public String login(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UserNotFoundException("Invalid credentials"));

        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new UserNotFoundException("Invalid credentials");
        }

        return jwtService.generateToken(user.getEmail());
    }
}