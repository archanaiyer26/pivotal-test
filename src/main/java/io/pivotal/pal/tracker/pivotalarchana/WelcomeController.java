package io.pivotal.pal.tracker.pivotalarchana;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pivotal")
public class WelcomeController {

    String hello;

    public WelcomeController(@Value("${welcome.message}") String message){
        this.hello=message;
    }

    @RequestMapping("/hello")
    public String getHello(){

        return "hello";
    }
}
