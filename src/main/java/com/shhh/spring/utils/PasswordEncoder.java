package com.shhh.spring.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

@Component
public class PasswordEncoder{
  
  
  public String encodePassword(String password){
    String encodedPassword = DigestUtils.md5DigestAsHex(password.getBytes());
    return encodedPassword;
  }
  
}
