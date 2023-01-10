package com.Consurmer.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDetail {
    private String detail = "Topic_Parking_details";
    private String var = "Variable";
    private int parkingNumber;
}
