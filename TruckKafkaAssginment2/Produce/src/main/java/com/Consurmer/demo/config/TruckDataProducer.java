package com.Consurmer.demo.config;

import java.io.*;

public class TruckDataProducer {
    File file = new File(
            "src/main/resources/TrucksDataSet.txt");
    // Creating an object of BufferedReader class
 public static   BufferedReader br;

    {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
