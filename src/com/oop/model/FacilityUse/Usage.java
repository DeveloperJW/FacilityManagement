package com.oop.model.FacilityUse;

import com.oop.model.Facility.Facility;
import com.oop.model.Facility.FacilityAddress;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Usage {
    private int maxCapcaity;
    private int resevedGroupSize;
    private Facility facility;
    private FacilityAddress facilityAddress;
    private ArrayList<Facility> facilities_In_Use=new ArrayList<Facility>();
    private boolean isInUse=false;
    private Customer customer;
    private FacilitySchedule facilitySchedule;

    public Usage(Facility someFacility){
        //default constructor
        this.facility=someFacility;
        this.maxCapcaity=someFacility.getCapacity();
        this.facilityAddress=someFacility.getFacilityAddress();
    }

    public Facility getFacility() {
        return facility;
    }

    public int getMaxCapcaity() {
        return maxCapcaity;
    }

    public int getResevedForGroupOf(){
        return resevedGroupSize;
    }

    public void setResevedForGroupOf(int groupSize){
        this.resevedGroupSize=groupSize;
    }

    //isInUseDuringInterval()
    public boolean isInUseDuringInterval(Date date, int duration){
        Date startTime= facilitySchedule.getStartDateTime();
        Date endTime=facilitySchedule.getEndDateTime();
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR,duration);
        Date estResevedEndTime=new Date();
        estResevedEndTime=calendar.getTime();
        //
        boolean result=false;
        //Done: check the logic of the scheduling
        result=(startTime.compareTo(date)*endTime.compareTo(estResevedEndTime)<0);
        return result;
    }

    public void assignFacilityToUse(Facility facility){
        facilities_In_Use.add(facility);
        System.out.println("New reservation is assigned.");
    }

    public void vacateFacility(Facility facility){
        facilities_In_Use.remove(facility);
        System.out.println("The facility is been vacated.");
    }


    public void listActualUsage(){
        for (Facility facility: facilities_In_Use){
            System.out.println("Facility: "+facility+" has reserved for "+resevedGroupSize+" people.");
        }
    }

    public Object calcUsageRate(){
        double percentage=resevedGroupSize/maxCapcaity;
        String result="The usage rate is: "+percentage*100+"%";
        return result;
    }
}
