package com.challenge.heyGongChallenge.user.application;

import com.challenge.heyGongChallenge.user.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService (UserRepository userRepository){
        this.userRepository = userRepository;
    }
}
