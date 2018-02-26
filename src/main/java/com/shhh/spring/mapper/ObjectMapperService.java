package com.shhh.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shhh.spring.dto.UserRegistrationDto;
import com.shhh.spring.entity.Users;
import com.shhh.spring.utils.PasswordEncoder;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Service
public class ObjectMapperService extends ConfigurableMapper implements Imapper {
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Override
  public void configure(MapperFactory mapperFactory) {
    
    mapperFactory.registerClassMap(mapperFactory
        .classMap(UserRegistrationDto.class, Users.class).byDefault()
        .customize(new CustomMapper<UserRegistrationDto, Users>() {

          @Override
          public void mapAtoB(UserRegistrationDto a, Users b, MappingContext context) {
            b.setPassword(passwordEncoder.encodePassword(a.getPassword()));
          }
          
          @Override
          public void mapBtoA(Users b,UserRegistrationDto a, MappingContext context) {
            
          }
          
        }).toClassMap());

  }
}