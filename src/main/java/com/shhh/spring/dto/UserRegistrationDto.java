package com.shhh.spring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

@Validated
public class UserRegistrationDto implements Serializable {

  private static final long serialVersionUID = -8302199453872547517L;
  
  @Size(min=3,max=20)
  private String username;
  
  @NotNull
  private String email;
  
  @NotNull
  private String password;
  
  @NotNull
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

  public void setUsername(String username) {
    this.username = username;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setConfirmPassword(String confirmPassword) {
    this.confirmPassword = confirmPassword;
  }
  
  

}
