package xyz.ganghua.gatewayweb;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import xyz.ganghua.common.MyConstants;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureWebTestClient
public class GatewayWebApplication {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testHelloWorld(){
        webClient.get()
                .uri("/str")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                // 验证状态
                .expectStatus().isOk()
                // 验证结果，注意结果是字符串格式
                .expectBody(String.class).consumeWith(result  -> assertTrue(result.getResponseBody().contains(MyConstants.HELLO_PREFIX)));
    }
}
