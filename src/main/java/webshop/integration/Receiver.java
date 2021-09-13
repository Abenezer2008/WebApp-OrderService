package webshop.integration;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import webshop.dto.CustomerOrderedEventDTO;
import webshop.dto.ProductOrderedEventDTO;

@Service
public class Receiver {
//    @KafkaListener(topics = {"productOrdered"})
//    public void receiveProductOrderedEvent(@Payload ProductOrderedEventDTO eventDTO){
//        System.out.println("Received Message : " + eventDTO);
//    }
//        @KafkaListener(topics = {"customerOrdered"})
//    public void receiveProductOrderedEvent(@Payload CustomerOrderedEventDTO eventDTO){
//        System.out.println("Received Message : " + eventDTO);
//    }
}
