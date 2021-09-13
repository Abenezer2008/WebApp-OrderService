package webshop.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import webshop.dto.CustomerOrderedEventDTO;
import webshop.dto.ProductOrderedEventDTO;

@Service
public class CustomerOrderedEventSender {
    @Autowired
    private KafkaTemplate<String, CustomerOrderedEventDTO> kafkaTemplate;

    public void send(CustomerOrderedEventDTO customerOrderedEventDTO){
        kafkaTemplate.send("customerOrdered",customerOrderedEventDTO);
    }
}
