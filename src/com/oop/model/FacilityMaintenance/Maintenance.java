package com.oop.model.FacilityMaintenance;

import java.util.Date;

public class Maintenance {
    private String maintenanceId;
    private String buildingId;
    private String unitId;
    private String problemType;
    private String workerName;
    private String workerContactNum;
    private Date startDateTime;
    private Date endDateTime;
    private MaintenanceRequest request;

    public Maintenance(){
    //default constructor
    }
    //methods
    public String getMaintenanceId(){
        return maintenanceId;
    }

    public void setMaintenanceId(String newMaintId){
        this.maintenanceId=newMaintId;
    }

    public String getBuildingId(){
        return buildingId;
    }

    public void setBuildingId(String newBuildingId){
        this.buildingId=newBuildingId;
    }

    public String getUnitId(){
        return unitId;
    }

    public void setUnitId(String newUnitId){
        this.unitId=newUnitId;
    }

    public String getProblemType(){
        return problemType;
    }

    public void setProblemType(String newProblemType){
        this.problemType=newProblemType;
    }

    public String getWorkerName(){
        return workerName;
    }

    public void setWorkerName(String newWorkerName){
        this.workerName=newWorkerName;
    }

    public String getWorkerContactNum(){
        return workerContactNum;
    }

    public void setWorkerContactNum(String newNumber){
        this.workerContactNum=newNumber;
    }

    public Date getStartDateTime() {
        return startDateTime;
    }
    public void setStartDateTime(Date newStartDate){
        this.startDateTime=newStartDate;
    }

    public Date getEndDateTime(){
        return endDateTime;
    }

    public void setEndDateTime(Date newEndDate){
        this.endDateTime=newEndDate;
    }

    public long getTimeDurationInHour(Date start, Date end){
        return (end.getTime()-start.getTime())/(60*60*1000);
    }

    public MaintenanceRequest getRequest() {
        return request;
    }

    public String toString(){
        String result="";
        result="MaintenanceID: "+this.maintenanceId+"\n";
        result+="Problem Type: "+this.problemType+"\n";
        result+="Worker Name: "+this.workerName+"\n";
        result+="Worker Contact Number: "+this.workerContactNum.toString();
        return result;
    }
}
