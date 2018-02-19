package com.oop.model.Facility;

public class BuildingUnit extends Facility {

    private String unitId;
    private String buildingId;
    private int floorLevel;
    private double floorArea;
    private String status;
    //private int numOfRooms;

    public BuildingUnit(){
        //default constructor
        //inherit from Superclass
        super();
    }
    //methods
    public String getUnitId(){
        return unitId;
    }
    public void setUnitId(String newUnitId){
        this.unitId=newUnitId;
    }
    public String getBuildingId(){
        return buildingId;
    }
    public void setBuildingId(String newBuildingId){
        this.buildingId=newBuildingId;
    }

    public int getFloorLevel(){
        return floorLevel;
    }

    public void setFloorLevel(int newFloorLevel){
        this.floorLevel=newFloorLevel;
    }

    public double getFloorArea(){
        return floorArea;
    }

    public void setFloorArea(double newFloorArea){
        this.floorArea=newFloorArea;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String newStatus){
        this.status=newStatus;
    }

}
