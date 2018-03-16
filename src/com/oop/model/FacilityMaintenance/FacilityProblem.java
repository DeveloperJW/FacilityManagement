package com.oop.model.FacilityMaintenance;

import com.oop.model.Facility.Facility;

public class FacilityProblem extends MaintenanceRequest {
    private String maintProblemId;
    private String maintProblemType;
    private String maintProblemDetails;
    private boolean fixedOrNot;

    public FacilityProblem(){
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

    public String toString(){
        String result="Facility Name: "+this.getFacility().getFacilityName()+"\n";
        result+="Problem Type: "+this.maintProblemType+"\n";
        result+="Problem details: "+this.maintProblemDetails+"\n";
        result+="Current status: "+this.fixedOrNot+"\n";
        return result;
    }
}
