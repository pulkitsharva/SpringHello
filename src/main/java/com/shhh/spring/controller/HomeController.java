package com.shhh.spring.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.shhh.spring.dto.Response;
import com.shhh.spring.service.UserService;

@Controller
@RequestMapping("/home")
public class HomeController {

  @Autowired
  private UserService userService;
  
  @RequestMapping(method=RequestMethod.GET)
  public String login(ModelMap model,HttpServletRequest request){
    HttpSession session=request.getSession();
    String username=(String) session.getAttribute("username");
    if(username==null){
      return "redirect:/user/login";
    }
    return "home";
  }
  
  @RequestMapping(value="/getLocation",method=RequestMethod.GET)
  public ResponseEntity<Response> getLocation(@RequestParam("latitude") String latitude,@RequestParam("longitude") String longitude,HttpServletRequest request,ModelMap model){
    System.out.println(latitude+"-------"+longitude);
    HttpSession session=request.getSession();
    String username=(String) session.getAttribute("username");
    if(username==null){
      return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    Float currentLat=new Float(latitude);
    Float currentLong=new Float(longitude);
    boolean result=userService.updateCurrentLocation(username, currentLat, currentLong);
    if(!result){
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    Response response=new Response();
    response.setStatus("success");
    response.setTimestamp(new Date());
    return new ResponseEntity<Response>(response, HttpStatus.OK);
  }
  class test{
    private String status;

    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
      this.status = status;
    }
    
  }
  
}
