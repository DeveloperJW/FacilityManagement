package com.oop.model.FacilityMaintenance;

import java.util.Date;

public class MaintenanceRequest{
    private String reqId;
    private Date reqDate;
    private String customerId;
    private String unitId;


    public MaintenanceRequest(){

    }

    //methods
    public String getReqId(){
        return reqId;
    }

    public void setReqId(String newReqId){
        this.reqId=newReqId;
    }

    public Date getReqDate(){
        return reqDate;
    }

    public void setReqDate(Date newReqDate){
        this.reqDate=newReqDate;
    }

    public String getCustomerId(){
        return customerId;
    }

    public void setCustomerId(String newCustId){
        this.customerId=newCustId;
    }

    public String getUnitId(){
        return unitId;
    }

    public void setUnitId(String newUnitId){
        this.unitId=newUnitId;
    }

}
