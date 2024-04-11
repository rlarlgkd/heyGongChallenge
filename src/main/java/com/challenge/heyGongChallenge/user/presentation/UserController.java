package com.challenge.heyGongChallenge.user.presentation;

import com.challenge.heyGongChallenge.user.application.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    public UserController(UserService userService){
//        this.userService = userService;
//    }


}
