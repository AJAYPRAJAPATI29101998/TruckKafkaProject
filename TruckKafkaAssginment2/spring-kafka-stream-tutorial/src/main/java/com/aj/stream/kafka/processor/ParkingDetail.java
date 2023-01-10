package com.aj.stream.kafka.processor;



public class ParkingDetail {
    private String detail = "Topic_Parking_details";
    private String var = "Variable";
    private int parkingNumber;


    public ParkingDetail(String detail, String var, int parkingNumber) {
        this.detail = detail;
        this.var = var;
        this.parkingNumber = parkingNumber;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int getParkingNumber() {
        return parkingNumber;
    }

    public void setParkingNumber(int parkingNumber) {
        this.parkingNumber = parkingNumber;
    }

    @Override
    public String toString() {
        return "ParkingDetail{" +
                "detail='" + detail + '\'' +
                ", var='" + var + '\'' +
                ", parkingNumber=" + parkingNumber +
                '}';
    }
}
