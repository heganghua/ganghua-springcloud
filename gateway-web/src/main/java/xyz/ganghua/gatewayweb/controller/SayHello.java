package xyz.ganghua.gatewayweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ganghua.common.MyConstants;

@RestController
public class SayHello {

    @GetMapping("/sayHello")
    public String sayHello(){
        return MyConstants.HELLO_PREFIX;
    }
}
