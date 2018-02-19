package com.oop.model.Facility;

public class BuildingUnit extends Facility {

    private String unitId;
    private String buildingId;
    private int floorLevel;
    private int numOfUnits;
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
    //
    public String getBuildingId(){
        return buildingId;
    }
    public void setBuildingId(String newBuildingId){
        this.buildingId=newBuildingId;
    }
    //
    public int getFloorLevel(){
        return floorLevel;
    }

    public void setFloorLevel(int newFloorLevel){
        this.floorLevel=newFloorLevel;
    }
    //number of units
    public int getNumOfUnits(){
        return numOfUnits;
    }
    public void setNumOfUnits(int newNumOfUnits){
        this.numOfUnits=newNumOfUnits;
    }

}
