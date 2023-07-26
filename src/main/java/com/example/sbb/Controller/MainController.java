package com.example.sbb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//Default Web url
//=> localhost:8080/

@Controller
public class MainController {

  //Hello World 출력하는 페이지 (Hello 메서드 실행)
  @GetMapping("/Hello")
  @ResponseBody
  public String Hello(){
    return "Hello World";
  }

  //sbb 입력 시, console 창에
  @RequestMapping("/sbb")
  public void index(){
    System.out.println("sbb 첫 시작");
  }
}
