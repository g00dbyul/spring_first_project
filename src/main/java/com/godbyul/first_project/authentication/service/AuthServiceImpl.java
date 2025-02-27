package com.godbyul.first_project.authentication.service;

import com.godbyul.first_project.authentication.domains.User;
import com.godbyul.first_project.authentication.dto.CreateUserDto;
import com.godbyul.first_project.authentication.exceptions.AuthException;
import com.godbyul.first_project.authentication.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public User createUser(CreateUserDto createUserDto) {
        userRepository.findByUsername(createUserDto.getUsername())
                .ifPresent(user -> {
                    throw new AuthException("이미 존재하는 사용자입니다.");
                });

        userRepository.findByEmail(createUserDto.getEmail())
                .ifPresent(user -> {
                    throw new AuthException("이미 존재하는 이메일입니다.");
                });

        User user = User.builder().username(createUserDto.getUsername())
                .password(passwordEncoder.encode(createUserDto.getPassword()))
                .email(createUserDto.getEmail())
                .build();

        return userRepository.save(user);
    }
}
