package xyz.ganghua.business.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "ganghua-usercenter-engine")
public interface UserCenterService {

    @GetMapping("/usercenter/pament/{id}")
    public String paymentInfo(@PathVariable("id") Long id);

    @GetMapping("/usercenter/config")
    public String testNacosConfigCenter();
}

