package xyz.ganghua.gateway.admin.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class EventSender {

//    @Autowired
//    private RabbitTemplate rabbitTemplate;
//
//    @Autowired
//    private MessageConverter messageConverter;
//
//    @PostConstruct
//    public void init() {
//        rabbitTemplate.setMessageConverter(messageConverter);
//    }
//
//    public void send(String routingKey, Object object) {
//        log.info("routingKey:{}=>message:{}", routingKey, object);
//        rabbitTemplate.convertAndSend(BusConfig.EXCHANGE_NAME, routingKey, object);
//    }
}
