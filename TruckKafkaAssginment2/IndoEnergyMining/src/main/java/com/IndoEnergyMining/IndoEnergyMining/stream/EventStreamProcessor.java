package com.IndoEnergyMining.IndoEnergyMining.stream;

//import com.google.gson.Gson;
import com.IndoEnergyMining.IndoEnergyMining.model.Truck;
import com.google.gson.Gson;
import jakarta.annotation.PostConstruct;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KTable;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import javax.annotation.PostConstruct;

@Component
public class EventStreamProcessor {

    @Autowired
    private StreamsBuilder streamsBuilder;

//    public static KTable<String,String> availableParkings ;

    @PostConstruct
    public void streamTopology() {
        Gson gson = new Gson();
        KStream<String, String> kStream = streamsBuilder.stream("FULL_TRUCK_DATA", Consumed.with(Serdes.String(), Serdes.String()));
//        kStream.peek((k,v)-> System.out.println("---------********"+v));
        KStream<String, Truck> truckDataForFilter =
                kStream.map((k, v) -> {
            Truck p = gson.fromJson(v, Truck.class);
            return KeyValue.pair(k, p);
        });

           truckDataForFilter=   truckDataForFilter.filter((k, truck) -> {
               if((truck.getEnvironmentalCondition()!=null && truck.getEnvironmentalCondition().equalsIgnoreCase("snow"))||
                       (truck.getEnvironmentalCondition().equalsIgnoreCase("HeavyRain"))||
                       (truck.getEnginePerformance()<100)||(truck.getTyrePressure()>50)){
                   return true;
               }
               return false;
           });

        KStream<String,String> sendToNewTopic =   truckDataForFilter.peek((k,v)-> System.out.println("----->"+v)).map((k,v)->
           {
               String obj = gson.toJson(v);
            return KeyValue.pair("key",obj);
           });
           sendToNewTopic.to("FAILED_TRUCKS", Produced.with(Serdes.String(),Serdes.String()));
           //.peek((k, v) -> System.out.println("converted--->" + v));


//          truckDataForFilter.foreach((k,v)-> System.out.println(v));
    }
}
