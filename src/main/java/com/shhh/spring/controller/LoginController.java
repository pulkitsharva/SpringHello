package com.shhh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
import com.shhh.spring.service.UserService;
import com.shhh.spring.validator.UserRegistrationValidator;

@Controller
public class LoginController {
  
  @Autowired
  private UserService userService;
  
  @RequestMapping(value="/login",method=RequestMethod.POST)
  public String login(@ModelAttribute("userLogin")@Valid UserLoginDto user,BindingResult bindingResult, ModelMap model,HttpServletRequest request){
    if(bindingResult.hasErrors()){
      return "login";
    }
    boolean result=userService.login(user);
    if(result){
      HttpSession session=request.getSession();
      session.setAttribute("username", user.getUsername());
      return "redirect:/home";
    }
    else{
      model.addAttribute("errorMessage", "Username or password is incorrect!!");
      return "login";
    }
  }
  
  @RequestMapping(value="/login",method=RequestMethod.GET)
  public String login(ModelMap model){
    model.addAttribute("userLogin", new UserLoginDto());
    return "login";
  }
  
}
