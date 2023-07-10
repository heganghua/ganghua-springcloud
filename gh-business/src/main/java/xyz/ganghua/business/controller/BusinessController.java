package xyz.ganghua.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @GetMapping("/welcome")
    public String BusinessWelcome() {
        return "Welcome Business Engine!";
    }

}
