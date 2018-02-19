package com.oop.model.FacilityMaintenance;

public class MaintenanceProblem extends MaintenanceRequest {
    private String maintProblemId;
    private String maintProblemType;
    private String maintProblemDetails;
    private boolean fixedOrNot;

    public MaintenanceProblem(){
        //default constructor
        super();
    }

    public String getMaintProblemId() {
        return maintProblemId;
    }

    public void setMaintProblemId(String newMainProblemId){
        this.maintProblemId=newMainProblemId;
    }

    public String getMaintProblemType(){
        return maintProblemType;
    }

    public void setMaintProblemType(String newProblemType){
        this.maintProblemType=newProblemType;
    }

    public String getMaintProblemDetails(){
        return maintProblemDetails;
    }

    public void setMaintProblemDetails(String newDetails){
        this.maintProblemDetails=newDetails;
    }

    public boolean getFixedOrnot(){
        return fixedOrNot;
    }

    public void setFixedOrNot(Boolean newStatus){
        this.fixedOrNot=newStatus;
    }
}
