package xyz.ganghua.gateway.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.config.GatewayClassPathWarningAutoConfiguration;

@SpringBootApplication(exclude = GatewayClassPathWarningAutoConfiguration.class)
@EnableDiscoveryClient
@EnableCircuitBreaker
//@EnableMethodCache(basePackages = "com.springboot.cloud")
//@EnableCreateCacheAnnotation
public class GatewayAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayAdminApplication.class, args);
    }

}
