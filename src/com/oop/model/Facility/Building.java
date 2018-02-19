package com.oop.model.Facility;
import java.util.List;

public class Building extends Facility{
    private String buildingId;
    private int numOfFloors;
    private int numOfUnits;
    private List<BuildingUnit> buildingUnits;

    public Building(){
        //default constructors
        //inherit from Facility
        super();
    }

    //get and set for buildingId
    public String getBuildingId(){
        return buildingId;
    }
    public void setBuildingId(String newBuildingId){
        this.buildingId=newBuildingId;
    }
    //get and set for number of floors of the building
    public int getNumOfFloors(){
        return numOfFloors;
    }

    public void setNumOfFloors(int newNumOfFloors){
        this.numOfFloors=newNumOfFloors;
    }

    //get and set for number of units of the building
    public int getNumOfUnits(){
        return numOfUnits;
    }

    public void setNumOfUnits(int newNumOfUnits){
        this.numOfUnits=newNumOfUnits;
    }


}
