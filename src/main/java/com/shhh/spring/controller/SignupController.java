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

import com.shhh.spring.dto.UserRegistrationDto;
import com.shhh.spring.service.UserService;
import com.shhh.spring.validator.UserRegistrationValidator;

@Controller
public class SignupController {
  
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

}
