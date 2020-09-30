package com.localfoodnetwork.localfoodnetwork;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncrypter {

    public String encode(String unsecuredPassword) {
        String securedPassword = "";
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        securedPassword = encoder.encode(unsecuredPassword);
        return securedPassword;
    }
    
}
