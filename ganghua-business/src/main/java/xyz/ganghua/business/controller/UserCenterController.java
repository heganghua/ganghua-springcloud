package xyz.ganghua.business.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.ganghua.business.service.UserCenterService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/business")
public class UserCenterController{

    @Resource
    private UserCenterService userCenterService;

    @GetMapping("/pament/{id}")
    public String paymentInfo(@PathVariable("id") Long id){
        return userCenterService.paymentInfo(id);
    }

    @GetMapping("/config")
    public String testNacosConfigCenter(){
        return userCenterService.testNacosConfigCenter();
    }

}
