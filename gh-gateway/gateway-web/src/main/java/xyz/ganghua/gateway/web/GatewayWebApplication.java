package xyz.ganghua.gateway.web;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EnableCreateCacheAnnotation
public class GatewayWebApplication {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(GatewayWebApplication.class, args);
    }
}