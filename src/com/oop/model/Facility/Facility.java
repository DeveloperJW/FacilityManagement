package com.oop.model.Facility;

import java.util.ArrayList;

public class Facility {
    private String facilityId;
    private String facilityName;
    private int capacity;
    private String facilityType;
    private FacilityAddress facilityAddress;
    private String facilityDetail="";

    public Facility(){
    //default constructor
    }

    //methods

    //Facility Detail
    public String getFacilityDetail() {
        return facilityDetail;
    }

    public void setFacilityDetail(String newDetails){
        facilityDetail=newDetails;

    }

    public String getFacilityId(){
        return facilityId;
    }
    //
    public void setFacilityId(String newFacilityId){
        this.facilityId=newFacilityId;
    }
    //
    public String getFacilityName(){
        return facilityName;
    }
    //set
    public void setFacilityName(String newFacilityName){
        this.facilityName=newFacilityName;
    }
    //get method for capacity (do we need to use long type?)
    public int getCapacity(){
        return capacity;
    }
    //set
    public void setCapacity(int newCapacity){
        this.capacity=newCapacity;
    }

    public String getfacilityType(){
        return facilityType;
    }
    //set
    public void setFacilityType(String newFacilityType){
        this.facilityType=newFacilityType;
    }

    //address
    public FacilityAddress getFacilityAddress(){
        return facilityAddress;
    }

    public void setFacilityAddress(FacilityAddress newFacilityAddress){
        this.facilityAddress=newFacilityAddress;
    }


    //TODO: add a method to add details or connect Facility with Facility Details
    public void addFacilityDetail(String newDetail){
        facilityDetail+=newDetail;
    }

    public String toString(){
        String result="";
        result="FacilityID: "+this.facilityId+"\n";
        result+="FacilityName: "+this.facilityName+"\n";
        result+="Capacity: "+this.capacity+"\n";
        result+="Address: "+this.facilityAddress.toString();
        return result;
    }



}
