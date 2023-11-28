package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String home(){
        //static보다 컨트롤러가 있는지 먼저 찾는다!!!
        return "home";
    }
}
