package com.Consurmer.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {


    @Bean
    public NewTopic topic(){
        return TopicBuilder.name("FULL_TRUCK_DATA")
                .build();
    }

    @Bean
    public NewTopic topic2(){
        return TopicBuilder.name("FAILED_TRUCKS")
                .build();
    }

}
