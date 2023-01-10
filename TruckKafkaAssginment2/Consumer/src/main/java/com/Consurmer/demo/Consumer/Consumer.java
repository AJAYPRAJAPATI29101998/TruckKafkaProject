package com.Consurmer.demo.Consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer{
    private static final Logger LOGGER = LoggerFactory.getLogger(String.class);

    @KafkaListener(topics = "FAILED_TRUCKS"
    ,groupId = "group12")
    public void consume(ConsumerRecord<String,String> record){



        System.out.println(record.value());


    }
}

