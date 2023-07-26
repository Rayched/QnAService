package com.example.sbb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//Default Web url
//=> localhost:8080/

@Controller
public class MainController {

  //Hello World 출력하는 페이지 (Hello 메서드 실행)
  @GetMapping("/hello")
  //아래 함수, Hello()의 return 값 "Hello World"을 그대로 브라우저에 표시
  //아래 함수의 return 값을 문자열화해서 브라우저의 응답을
  //현재 보고있는 웹 페이지의 <body> 요소에 담는다.
  @ResponseBody
  public String Hello(){
    return "Hello World";
  }

  @GetMapping("/test")
  @ResponseBody
  public String showMain(){
    return """
           <h1>안녕하세요.</h1>
           <input type="text" placeholder="텍스트를 입력해주세요."/>
           """;
  }

  @GetMapping("/page1")
  @ResponseBody
  public String Submit(){
    return """
           <form method="POST" action="/page2">
              이름 : <input type="text" name="name" placeholder="이름 입력"/><br/>
              나이 : <input type="number" name="age" placeholder="나이 입력"/><br/>
              <input type="submit" value="제출하기"/>
           </form>
           """;
  }

  @GetMapping("/page2")
  @ResponseBody
  public String showGET(@RequestParam(defaultValue = "Noname") int age){
    return """
           <p>데이터 입력 방법 => 'localhost:[port no]/page2?'변수명'='변수값'
           <h4>입력된 데이터</h4>
           <p>나이 : %d</p>
           <hr/>
           <br/>
           <h4>GET</h4>
           <p>
           <b>GET</b> 방식은 사용자가 입력한 데이터, form 데이터를 <b><u>URL에 첨부</u></b>해서 보내는 방식이다.<br/>
           GET 방식은 form 데이터를 URL에 첨부해서 전송하기 때문에, 보낼 수 있는 데이터의 길이 제한이 존재하며 (최대 256자)<br/>
           사용자가 입력한 data를 URL에 첨부해서 서버로 전송한다는 특성 탓에 보안에 취약하고 브라우저에 기록으로 남는다.
           </p>
           """.formatted(age);
  }
  @PostMapping("/page2")
  @ResponseBody
  public String showPOST(@RequestParam(defaultValue = "무명") String name, @RequestParam(defaultValue = "0") int age){
    //데이터를 입력하지 않았을 때, defaultValue인 '무명'과 '0'이 출력된다.
    return """
           <h3>POST</h3>
           <p>
           POST 방식은 사용자가 입력한 데이터, form 데이터를 별도로 첨부해서 서버로 전송하는 방식이다.<br/>
           해당 방식은 GET 방식과 달리, form 데이터를 url에 첨부해서 보내지 않기 때문에 <br/>
           길이 제한 없이 데이터를 전송할 수 있으며, 데이터가 외부로 노출되지 않기 때문에 <br/>
           GET 방식으로 form 데이터를 보내는 것보다 보안성이 더 뛰어나다.
           </p>
           <hr/>
           <br/>
           <h3>입력한 데이터</h3>
           <p>이름 : %s</p>
           <p>나이 : %d</p>
           """.formatted(name, age);
    //매개변수에 저장되는 데이터의 타입이 일치하지 않아서 에러가 발생하였다.
    //전송하는 form 데이터의 순서에 맞춰서 매개변수의 순서를 바꿨더니 에러가 해결됐다.
  }
}
