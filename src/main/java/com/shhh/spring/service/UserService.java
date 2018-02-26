package com.shhh.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shhh.spring.dto.UserRegistrationDto;
import com.shhh.spring.entity.Users;
import com.shhh.spring.mapper.ObjectMapperService;
import com.shhh.spring.repository.UserRespository;

@Service
public class UserService {

  @Autowired
  private UserRespository userRespository;
  
  @Autowired 
  private ObjectMapperService mapper;
  
  public boolean createNewUser(UserRegistrationDto userDto){
    Users user=mapper.map(userDto, Users.class);
    userRespository.save(user);
    System.out.println(user);
    return true;
  }
}
