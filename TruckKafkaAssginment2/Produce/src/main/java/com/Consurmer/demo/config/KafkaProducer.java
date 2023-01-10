package com.Consurmer.demo.config;

import com.Consurmer.demo.model.ParkingDetail;
import com.Consurmer.demo.model.Truck;
import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducer.class);
    private NewTopic topic;

    private KafkaTemplate<String,Truck> kafkaTemplate;

    public KafkaProducer(NewTopic topic, KafkaTemplate<String, Truck> kafkaTemplate) {
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(Truck s){
    LOGGER.info(String.format("Available Praking => %s",s));

    //create message
//        Message<ParkingDetail> message = MessageBuilder
//                .withPayload(s)
//                .setHeader(KafkaHeaders.TOPIC,topic.name())
//                .build();

        kafkaTemplate.send("FULL_TRUCK_DATA",s);
    }
}
