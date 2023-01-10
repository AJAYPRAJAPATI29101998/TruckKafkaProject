package com.IndoEnergyMining.IndoEnergyMining.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Truck {
    private String truckId;
    private int averageSpeed;
    private int enginePerformance;
    private int tyrePressure;
    private String environmentalCondition;
}
