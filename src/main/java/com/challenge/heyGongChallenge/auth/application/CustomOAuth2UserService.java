package com.challenge.heyGongChallenge.auth.application;

import com.challenge.heyGongChallenge.auth.presentation.CustomOAuth2User;
import com.challenge.heyGongChallenge.auth.presentation.UserDTO;
import com.challenge.heyGongChallenge.auth.presentation.response.AppleResponse;
import com.challenge.heyGongChallenge.auth.presentation.response.GoogleResponse;
import com.challenge.heyGongChallenge.auth.presentation.response.OAuth2Response;
import com.challenge.heyGongChallenge.user.domain.entity.User;
import com.challenge.heyGongChallenge.user.domain.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;

    public CustomOAuth2UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2User oAuth2User = super.loadUser(userRequest);
        System.out.println(oAuth2User);

        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        OAuth2Response oAuth2Response = null;
        if (registrationId.equals("apple")) {

            oAuth2Response = new AppleResponse(oAuth2User.getAttributes());
        }
        else if (registrationId.equals("google")) {

            oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
        }
        else {

            return null;
        }
        String userId = oAuth2Response.getProvider()+" "+oAuth2Response.getProviderId();
        User existData = userRepository.findByUserId(userId);

        if (existData == null) {

            User user = User.createUser(
                    userId,
                    oAuth2Response.getEmail(),
                    "deviceId",
                    oAuth2Response.getName()
            ).build();

            userRepository.save(user);

            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(userId);
            userDTO.setName(oAuth2Response.getName());
            userDTO.setRole("ROLE_USER");

            return new CustomOAuth2User(userDTO);
        }
        else {

            existData.setEmail(oAuth2Response.getEmail());
            existData.setName(oAuth2Response.getName());

            userRepository.save(existData);

            UserDTO userDTO = new UserDTO();
            userDTO.setUsername(existData.getName());
            userDTO.setName(oAuth2Response.getName());
            userDTO.setRole(String.valueOf(existData.getRole()));

            return new CustomOAuth2User(userDTO);
        }
    }
}
