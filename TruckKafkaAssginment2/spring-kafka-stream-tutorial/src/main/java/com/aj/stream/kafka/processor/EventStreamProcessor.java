package com.aj.stream.kafka.processor;

import com.google.gson.Gson;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EventStreamProcessor {

    @Autowired
    private StreamsBuilder streamsBuilder;

    public static KTable<String,String> availableParkings ;

    @PostConstruct
    public void streamTopology() {
//        Gson gson = new Gson();
        KStream<String, String> kStream = streamsBuilder.stream("live_avl_free_space", Consumed.with(Serdes.String(), Serdes.String()));
//        KStream<String, ParkingDetail> maped = kStream.map((k, v) -> {
//            ParkingDetail p = gson.fromJson(v, ParkingDetail.class);
//            return KeyValue.pair(k, p);
//        });
//        maped=   maped.filter((k, v) -> v.getParkingNumber() < 10);//.peek((k, v) -> System.out.println("converted--->" + v));
//
//        KStream<String,String> sendToTopic = maped.map((k,v)->{
//            String obj = gson.toJson(v);
//            return KeyValue.pair("key",obj);
//        });
//        sendToTopic.to("live_avbl_empty_space_warning", Produced.with(Serdes.String(), Serdes.String()));
//        availableParkings= streamsBuilder.stream("live_avbl_empty_space_warning", Consumed.with(Serdes.String(), Serdes.String())).toTable();
//        availableParkings.toStream().peek((k,v)-> System.out.println("--->>>>"+v));
    }
}
