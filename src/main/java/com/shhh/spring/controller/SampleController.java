package com.shhh.spring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shhh.spring.dto.UserRegistrationDTO;

@Controller
@RequestMapping("/")
public class SampleController {

  @RequestMapping(method=RequestMethod.GET)
  public String get(ModelMap model){
    model.addAttribute("person", new Person());
    model.addAttribute("user",new UserRegistrationDTO());
    return "index";
    
  }
  @RequestMapping(value="index",method=RequestMethod.GET)
  public String getIndex(ModelMap model){
    model.addAttribute("person", new Person());
    return "welcome";
    
  }
  @RequestMapping(value="json",method=RequestMethod.GET)
  public @ResponseBody Person getJson(){
    Person response=new Person();
    response.setName("Hello Pulkit");
    return response;
    
  }
  @RequestMapping(value="submit", method=RequestMethod.POST)
  public String hello(@ModelAttribute Person request,ModelMap map){
    map.addAttribute("name", request.getName()+" bhaiya!!");
    return "submit";
    
  }
}
