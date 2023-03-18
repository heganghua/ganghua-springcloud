package xyz.ganghua.business.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DeptController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/{id}")
    public String getPayment(@PathVariable("id") Integer id) {
        return "服务名：ganghua-business-engin<br /> 端口号： " + serverPort + "<br /> 传入的参数：" + id;
    }
}
