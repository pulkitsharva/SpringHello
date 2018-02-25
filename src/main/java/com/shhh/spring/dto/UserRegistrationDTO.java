package com.shhh.spring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class UserRegistrationDTO implements Serializable {

  private static final long serialVersionUID = -8302199453872547517L;
  @Size(min=3,max=20)
  private String username;
  
  @NotNull
  private String email;
  
  private String password;
  
  private String confirmPassword;

  public static long getSerialversionuid() {
    return serialVersionUID;
  }

  public String getUsername() {
    return username;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getConfirmPassword() {
    return confirmPassword;
  }
  
  

}
