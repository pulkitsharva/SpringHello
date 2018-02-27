package com.shhh.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.shhh.spring.dto.UserRegistrationDto;

@Controller
public class IndexController {
  
  @RequestMapping(method=RequestMethod.GET)
  public String getHomePage(ModelMap model){
    model.addAttribute("user",new UserRegistrationDto());
    return "index";
  }

}
