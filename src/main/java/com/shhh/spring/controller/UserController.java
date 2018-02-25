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

import com.shhh.spring.dto.UserRegistrationDTO;
import com.shhh.spring.validator.UserRegistrationValidator;

@Controller
@RequestMapping("/user")
public class UserController {
  
  @Autowired
  private UserRegistrationValidator userRegistrationValidator;
  
  @InitBinder("user")
  public void initBinder2(WebDataBinder binder)
  {
      binder.setValidator(userRegistrationValidator);
  }
  
  @RequestMapping(value="/registration",method=RequestMethod.POST)
  public String getIndex(@ModelAttribute("user")@Valid UserRegistrationDTO request,BindingResult bindingResult, ModelMap model){
    if(bindingResult.hasErrors()){
      return "index";
    }
    model.addAttribute("person", new Person());
    return "welcome";
    
  }
}
