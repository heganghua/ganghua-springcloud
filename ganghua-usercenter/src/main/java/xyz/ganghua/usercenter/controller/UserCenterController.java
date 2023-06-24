package xyz.ganghua.usercenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@RequestMapping("/usercenter")
public class UserCenterController {

    @Resource
    private RestTemplate restTemplate;

//    // 服务提供者的服务名
//    @Value("${service-url.nacos-user-service}")
//    private String serverURL;

//    @Value("${server.port}")
//    private String port;

//    @GetMapping("/port")
//    public String getPort() {
//        System.out.println("port: >" + port);
//        return port;
//    }

    @GetMapping("/pament/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return restTemplate.getForObject("/usercenter/dept/payment/" + id, String.class);
    }
}

