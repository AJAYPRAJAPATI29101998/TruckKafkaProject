package com.Consurmer.demo;

import com.Consurmer.demo.config.KafkaProducer;
import com.Consurmer.demo.config.TruckDataProducer;
import com.Consurmer.demo.model.ParkingDetail;
import com.Consurmer.demo.model.Truck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class DemoApplication {

	private static KafkaProducer kafkaProducer;

	public DemoApplication(KafkaProducer kafkaProducer) {
		this.kafkaProducer = kafkaProducer;
	}

	public static void main(String[] args) throws InterruptedException, IOException {

		SpringApplication.run(DemoApplication.class, args);
//		while (true){
//			ParkingDetail parkingDetail = new ParkingDetail();
//			parkingDetail.setParkingNumber(getAvailableSpaces());
//			kafkaProducer.sendMessage(parkingDetail);
//			Thread.sleep(2000,0);
//		}

		TruckDataProducer tr = new TruckDataProducer();
		String st;

		while ((st = TruckDataProducer.br.readLine()) != null) {
			if(st.length()==0){
				break;
			}
			String []data = st.split("[, ]+" );
			Truck truck = new Truck(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),
					data[4]);

			kafkaProducer.sendMessage(truck);
			System.out.println(truck);
			Thread.sleep(2000,0);

		}
	}

}
