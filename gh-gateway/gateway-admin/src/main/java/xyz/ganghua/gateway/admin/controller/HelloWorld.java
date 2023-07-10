package xyz.ganghua.gateway.admin.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.ganghua.gateway.admin.entity.form.TestValidatorForm;

@RestController()
public class HelloWorld {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World!";
    }


    @PostMapping("/test")
    public String testValidator(@RequestBody @Validated TestValidatorForm request) {
        System.out.println(request.toString());
        return "hello World!";
    }


}
