package com.shhh.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shhh.spring.dto.UserLoginDto;
import com.shhh.spring.dto.UserRegistrationDto;
import com.shhh.spring.entity.Users;
import com.shhh.spring.repository.UserRespository;
import com.shhh.spring.service.UserService;
import com.shhh.spring.validator.UserRegistrationValidator;

@Controller
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private UserRegistrationValidator userRegistrationValidator;
  
  @InitBinder("user")
  public void initBinder(WebDataBinder binder)
  {
      binder.setValidator(userRegistrationValidator);
  }
  
  @Autowired
  private UserService userService;
  
  @RequestMapping(value="/registration",method=RequestMethod.POST)
  public String registerUser(@ModelAttribute("user")@Valid UserRegistrationDto user,BindingResult bindingResult, ModelMap model){
    if(bindingResult.hasErrors()){
      return "index";
    }
    userService.createNewUser(user);
    return "home";
    
  }
  @RequestMapping(value="/registration",method=RequestMethod.GET)
  public String getRegisterUserPage(ModelMap model){
    model.addAttribute("user", new UserRegistrationDto());
    return "register";
    
  }
  
  @RequestMapping(value="/login",method=RequestMethod.POST)
  public String login(@ModelAttribute("userLogin")@Valid UserLoginDto user,BindingResult bindingResult, ModelMap model){
    if(bindingResult.hasErrors()){
      return "index";
    }
    userService.login(user);
    return "home";
    
  }
  
  @RequestMapping(value="/login",method=RequestMethod.GET)
  public String login(ModelMap model){
    model.addAttribute("userLogin", new UserLoginDto());
    return "login";
  }
  
}
