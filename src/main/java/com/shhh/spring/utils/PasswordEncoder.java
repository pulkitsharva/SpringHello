package com.shhh.spring.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoder{
  
  private BCryptPasswordEncoder passwordHash= new BCryptPasswordEncoder();
  
  public String encodePassword(String password){
    return passwordHash.encode(password);
  }
  
}
