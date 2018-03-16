package com.oop.model.Facility;

public class FacilityDetail {
    private String details;

    public FacilityDetail(String someDetails){
        //default constructor
        this.details=someDetails;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String detail){
        this.details=detail;
    }
    public String toString(){
        return "Facility details: "+this.details;
    }
}
