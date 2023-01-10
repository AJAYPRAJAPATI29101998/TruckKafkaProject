//package com.vishaluplanch.stream.kafka;
//
//import com.vishaluplanch.stream.kafka.processor.EventStreamProcessor;
//import org.apache.kafka.streams.kstream.KTable;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class Controller {
//
//
//
//
//    @GetMapping("/as")
//    public void helloGFG()
//    {
//        System.out.println("*******************Available Parkings*****************");
//        EventStreamProcessor.availableParkings.toStream().peek((k,v)-> System.out.println("------->"+v));
//    }
//}
