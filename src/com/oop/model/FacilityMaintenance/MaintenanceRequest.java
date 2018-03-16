package com.oop.model.FacilityMaintenance;

import com.oop.model.Facility.Facility;
import com.oop.model.FacilityUse.Customer;

import java.util.Date;

public class MaintenanceRequest{
    private String reqId;
    private Date reqDate;
    private String customerId;
    private String unitId;
    private Customer customer;
    private Facility facility;


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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public String toString(){
        String result="The maintenance request is made by "+this.customer.getLastName()+"\n";
        result+="Request date: "+this.reqDate+"\n";
        result+="Facility :"+this.facility.getFacilityName()+"\n";
        return result;
    }

}
