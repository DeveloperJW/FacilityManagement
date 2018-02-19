package com.oop.model.Facility;

public class Facility {
    private String facilityId;
    private String facilityName;
    private int capacity;
    private double floorArea;
    private String facilityType;
    private String status;
    private FacilityAddress facilityAddress;

    public Facility(){
    //default constructor
    }

    //methods
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
    //
    public double getFloorArea(){
        return floorArea;
    }
    public void setFloorArea(double newArea){
        this.floorArea=newArea;
    }
    //
    public String getStatus(){
        return status;
    }
    public void setStatus(String newStatus){
        this.status=newStatus;
    }
    //Facility type
    public String getGetFacilityType(){
        return facilityType;
    }

    public void setFacilityType(String newType){
        this.facilityType=newType;
    }

    //address
    public FacilityAddress getFacilityAddress(){
        return facilityAddress;
    }

    public void setFacilityAddress(FacilityAddress newFacilityAddress){
        this.facilityAddress=newFacilityAddress;
    }




}
