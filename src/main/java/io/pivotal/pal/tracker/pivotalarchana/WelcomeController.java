package io.pivotal.pal.tracker.pivotalarchana;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pivotal")
public class WelcomeController {

    @RequestMapping("/hello")
    public String getHello(){

        return "hello";
    }
}
