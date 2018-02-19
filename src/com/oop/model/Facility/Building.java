package com.oop.model.Facility;
import java.util.List;

public class Building extends Facility{
    private String buildingId;
    private int numOfFloors;
    private int numOfElevators;
    private int numOfEntrace;
    private int numOfUnits;
    private List<BuildingUnit> buildingUnits;

    public Building(){
        //default constructors
        //inherit from Facility
        super();
    }

    //buildingId
    public String getBuildingId(){
        return buildingId;
    }
    public void setBuildingId(String newBuildingId){
        this.buildingId=newBuildingId;
    }
    //numOfFloors
    public int getNumOfFloors(){
        return numOfFloors;
    }

    public void setNumOfFloors(int newNumOfFloors){
        this.numOfFloors=newNumOfFloors;
    }
    //to be continued...

}
