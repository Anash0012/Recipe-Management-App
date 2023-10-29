package com.geekster.Recipe.Management.Service;

import com.geekster.Recipe.Management.Model.Dto.AuthenticationInputDto;
import com.geekster.Recipe.Management.Model.Dto.DetailChangeDto;
import com.geekster.Recipe.Management.Model.Dto.SignInInputDto;
import com.geekster.Recipe.Management.Model.User;
import com.geekster.Recipe.Management.Model.UserAuthenticationToken;
import com.geekster.Recipe.Management.Repo.UserRepo;
import com.geekster.Recipe.Management.Service.EmailUtility.EmailService;
import com.geekster.Recipe.Management.Service.HashingUtility.PasswordEncrypter;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    TokenService tokenService;


    public String userSignUp(User user) {

        String newEmail=user.getUserEmail();
        User existingUser=userRepo.findByUserEmail(newEmail);
        if (existingUser!=null){
            return "user already signup...";
        }
        String signUpPassword=user.getPassword();
        try{
            String encryptedPassword= PasswordEncrypter.encrypt(signUpPassword);
            user.setPassword(encryptedPassword);
            userRepo.save(user);
            return "User Registered..";
        }
        catch (NoSuchAlgorithmException e){
            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignIn(SignInInputDto signInInput) {
        String email=signInInput.getEmail();
        User existingUser=userRepo.findByUserEmail(email);
        if (existingUser==null){
            return "Not a valid email, Please sign up first !!!";
        }
        String password=signInInput.getPassword();
        try{
            String encryptedPassword=PasswordEncrypter.encrypt(password);
            if (existingUser.getPassword().equals(encryptedPassword)){
                UserAuthenticationToken token=new UserAuthenticationToken(existingUser);
                if (EmailService.sendEmail(email,"OTP after login ",token.getTokenValue())){
                    tokenService.createToken(token);
                    return "check email for otp/token!!!";
                }
                else {
                    return "error while generating token!!!";
                }
            }
            else {
                return "Invalid Credentials!!!";
            }
        }
        catch (NoSuchAlgorithmException e){
            return "Internal Server issues while saving password, try again later!!!";
        }
    }

    public String userSignOut(AuthenticationInputDto authinfo) {
        if (tokenService.authenticate(authinfo)){
            String tokenValue=authinfo.getTokenValue();
            tokenService.deleteToken(tokenValue);
            return "Sign Out Successful...";
        }
        else{
            return "Invalid Credentials!!!";
        }
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }


    public String changeUserDeatils(DetailChangeDto detailChangeDto) {
        AuthenticationInputDto authinfo=detailChangeDto.getAuthInfo();
        if (tokenService.authenticate(authinfo)) {
            String oldEmail = detailChangeDto.getAuthInfo().getEmail();
            User user = userRepo.findByUserEmail(oldEmail);
            String newName = detailChangeDto.getUser().getUserName();
            user.setUserName(newName);
            user.setUserContact(detailChangeDto.getUser().getUserContact());
            user.setUserEmail(detailChangeDto.getUser().getUserEmail());
            String newPassword = detailChangeDto.getUser().getPassword();
            try {
                String encryptedPassword = PasswordEncrypter.encrypt(newPassword);
                user.setPassword(encryptedPassword);
                return "Details Updated...";
            } catch (NoSuchAlgorithmException e) {
                return "Internal server Error";
            }
        }
        else{
            return null;
        }
    }
}
