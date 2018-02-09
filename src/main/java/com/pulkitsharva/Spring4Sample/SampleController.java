package com.pulkitsharva.Spring4Sample;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class SampleController {

  @RequestMapping(method=RequestMethod.GET)
  public @ResponseBody GetResponse hello(@RequestParam String name){
    GetResponse response=new GetResponse();
    response.setName("Hello "+name);
    return response;
    
  }
}
