package com.shhh.spring.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginDto implements Serializable{

  private static final long serialVersionUID = 7840780437704021611L;

  @Size(min=3,max=20)
  private String username;
  
  @NotNull
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
