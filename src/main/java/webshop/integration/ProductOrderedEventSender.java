package webshop.integration;

import webshop.dto.ProductOrderedEventDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderedEventSender {
    @Autowired
    private KafkaTemplate<String, ProductOrderedEventDTO> kafkaTemplate;

    public void send(ProductOrderedEventDTO productOrderedEventDTO){
        kafkaTemplate.send("productOrdered",productOrderedEventDTO);
    }
}
