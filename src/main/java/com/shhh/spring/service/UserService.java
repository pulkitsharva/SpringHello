package com.shhh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shhh.spring.dto.UserLoginDto;
import com.shhh.spring.dto.UserRegistrationDto;
import com.shhh.spring.entity.Users;
import com.shhh.spring.mapper.ObjectMapperService;
import com.shhh.spring.repository.UserRespository;
import com.shhh.spring.utils.PasswordEncoder;

@Service
public class UserService {

  @Autowired
  private UserRespository userRespository;
  
  @Autowired 
  private ObjectMapperService mapper;
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  public boolean createNewUser(UserRegistrationDto userDto){
    Users user=mapper.map(userDto, Users.class);
    userRespository.save(user);
    System.out.println(user);
    return true;
  }
  
  public boolean login(UserLoginDto userLoginDto){
    String encodedPassword=passwordEncoder.encodePassword(userLoginDto.getPassword());
    Users user=userRespository.getUsersByUsernameAndPassword(userLoginDto.getUsername(), encodedPassword);
    if(user==null){
      return false;
    }
    return true;
  }
  
  public boolean updateCurrentLocation(String username,Float currentLat,Float currentLong){
    Users user=userRespository.getUsersByUsername(username);
    if(user==null){
      return false;
    }
    user.setCurrentLat(currentLat);
    user.setCurrentLong(currentLong);
    userRespository.save(user);
    return true;
  }
  
  public boolean getUser(String username){
    Users user=userRespository.getUsersByUsername(username);
    if(user==null){
      return false;
    }
    return true;
  }
  
  
}
