package com.example.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
  @GetMapping("/Hello")
  @ResponseBody
  public String Hello(){
    return "Hello World";
  }
  //http://localhost:8081
}
