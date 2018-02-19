package com.oop.model.FacilityUse;

import java.util.Date;

public class FacilitySchedule {
    private String scheduleId;
    private String unitId;
    private Date startDateTime;
    private Date endDateTime;
    private String customerId;

    public FacilitySchedule(){
        //default constructor
    }

    //methods
    public String getScheduleId(){
        return scheduleId;
    }

    public void setScheduleId(String newSId){
        this.scheduleId=newSId;
    }

    public String getUnitId(){
        return unitId;
    }

    public void setUnitId(String newUnitId){
        this.unitId=newUnitId;
    }

    public String getCustomerId(){
        return customerId;
    }

    public void setCustomerId(String newCustId){
        this.customerId=newCustId;
    }

    public Date getStartDateTime(){
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

}
