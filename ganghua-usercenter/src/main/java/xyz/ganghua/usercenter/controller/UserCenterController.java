package xyz.ganghua.usercenter.controller;

import javax.annotation.Resource;

import com.alibaba.nacos.api.utils.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RefreshScope
@RequestMapping("/usercenter")
public class UserCenterController {

    @Resource
    private RestTemplate restTemplate;

    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/pament/{id}")
    public String paymentInfo(@PathVariable("id") Long id) {
        return String.valueOf(id);
    }

    @GetMapping("/config")
    public String testNacosConfigCenter() {
        return configInfo;
    }

}
