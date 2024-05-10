package com.challenge.heyGongChallenge.auth.presentation.response;

public interface OAuth2Response {

    String getProvider();
    String getProviderId();
    String getEmail();
    String getName();
}
