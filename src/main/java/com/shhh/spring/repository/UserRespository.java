package com.shhh.spring.repository;

import org.springframework.stereotype.Repository;

import com.shhh.spring.entity.Users;

@Repository
public interface UserRespository extends BaseRepository<Users, Integer>  {
  
  Users getUsersByUsernameAndPassword(String username,String password);

  Users getUsersByUsername(String username);
}
