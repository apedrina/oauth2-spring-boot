package com.alissonpedrina.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import com.alissonpedrina.model.UserEntity;
import com.alissonpedrina.repository.UserRepository;

public class CustomTokenEnhancer implements TokenEnhancer {

	@Autowired
	private UserRepository repository;
	
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    	UserEntity user = repository.findByName(authentication.getName());
    	
        final Map<String, Object> additionalInfo = new HashMap<>();
        additionalInfo.put("user_id", String.valueOf(user.getId()));
        ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
        return accessToken;
    }
}
