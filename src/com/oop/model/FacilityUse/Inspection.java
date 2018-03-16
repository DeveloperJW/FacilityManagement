package com.oop.model.FacilityUse;
import java.util.Date;

public class Inspection {
    private String inspectionId;
    private String unitId;
    private String inpectorName;
    private String inspectionResult;
    private Date InspectionDate;
    private FacilitySchedule facilitySchedule;

    public Inspection(FacilitySchedule schedule){
    //default constructor
        this.facilitySchedule=schedule;
    }
    ///methods
    public String getInspectionId(){
        return inspectionId;
    }

    public void setInspectionId(String newInspectionId){
        this.inspectionId=newInspectionId;
    }

    public String getUnitId(){
        return unitId;
    }

    public void setUnitId(String newUnitId){
        this.unitId=newUnitId;
    }

    public String getInpectorName(){
        return inpectorName;
    }

    public void setInpectorName(String newName){
        this.inpectorName=newName;
    }

    public String getInspectionResult(){
        return inspectionResult;
    }

    public void setInspectionResult(String newResult){
        this.inspectionResult=newResult;
    }

    public Date getInspectionDate(){
        return InspectionDate;
    }

    public void setInspectionDate(Date newDate){
        this.InspectionDate=newDate;
    }

    public String toString(){
        String result="";
        result="The information about Inspection is as followings:"+"\n";
        result+="Inspection requested by "+facilitySchedule.getCustomerId()+"\n";
        result+="Inspection requested on date"+InspectionDate+"\n";
        return result;
    }

}
