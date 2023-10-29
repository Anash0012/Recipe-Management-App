package com.geekster.Recipe.Management.Service;

import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Model.UserAuthenticationToken;
import com.geekster.Recipe.Management.Repo.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenService {


    @Autowired
    TokenRepo tokenRepo;

    public void createToken(UserAuthenticationToken token) {
        tokenRepo.save(token);
    }

    public void deleteToken(String tokenValue) {

        UserAuthenticationToken token =  tokenRepo.findFirstByTokenValue(tokenValue);
        tokenRepo.delete(token);

    }

    public boolean authenticate(AuthenticationInputDto authInfo) {

        String email = authInfo.getEmail();
        String tokenValue = authInfo.getTokenValue();

        UserAuthenticationToken token =  tokenRepo.findFirstByTokenValue(tokenValue);
        if(token!=null)
        {
            return token.getUser().getUserEmail().equals(email);
        }
        else
        {
            return false;
        }

    }
}