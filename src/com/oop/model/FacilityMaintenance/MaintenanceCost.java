package com.oop.model.FacilityMaintenance;

import java.util.Date;

public class MaintenanceCost extends Maintenance{
    private String maintenanceReqId;
    private double materialCost;
    private static double laborHourlyRate=25;
    private double laborCost;
    private boolean paidOrNot;

    public MaintenanceCost(){
        super();

    }

    //methods
    public String getMaintenanceReqId(){
        return maintenanceReqId;
    }

    public void setMaintenanceReqId(String newReqId){
        this.maintenanceReqId=newReqId;
    }

    public double getMaterialCost(){
        return materialCost;
    }

    public void setMaterialCost(double newMaterialCost){
        this.materialCost=newMaterialCost;
    }

    /**
     * getLaborCost() method
     * @return the total labor cost based on maintenance time duration
     */
    public double getLaborCost(){
        Date startTime=super.getStartDateTime();
        Date endTime=super.getEndDateTime();
        long TimeDuration=super.getTimeDurationInHour(startTime,endTime);
        return TimeDuration*laborHourlyRate;

    }

    public void setLaborCost(double newLaborCost){
        this.laborCost=newLaborCost;
    }

    public double getTotalCost(){
        return materialCost+laborCost;
    }

    public boolean getPaidOrNot(){
        return paidOrNot;
    }

    public void setPaidOrNot(Boolean newPaymentStatus){
        this.paidOrNot=newPaymentStatus;
    }
}
