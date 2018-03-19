package com.oop.model.Facility;

import java.util.ArrayList;

public class FacilityManagement {
    ArrayList<Facility> facilityArrayList;
    ArrayList<FacilityDetail> detailsArrayList;

    public FacilityManagement(){
        //default constructor
        this.facilityArrayList=new ArrayList<Facility>();
    }

    public ArrayList<Facility> getFacilityArrayList() {
        return facilityArrayList;
    }

    public void setFacilityArrayList(ArrayList<Facility> someList){
        this.facilityArrayList=someList;
    }

    //added manager classes and methods
    public void addFacility(Facility someFacility){
        this.facilityArrayList.add(someFacility);
        System.out.println("New Facility Added. ");
    }
    public void removeFacility(Facility facilityToRemove){
        if (this.facilityArrayList.contains(facilityToRemove)){
            this.facilityArrayList.remove(facilityToRemove);
            System.out.println("The Facility is removed. ");
        }else{
            System.out.println("The Facility you entered is not in the list. Please double check your entry.");
        }
    }

    public void listFacilities(){
        for (Facility facility: facilityArrayList){
            System.out.println(facility);
        }
    }

    public int requestAvailableCapacity(Facility facility){
        return facility.getCapacity();
    }

    /**
    public void addFacilityDetail(Facility facility, FacilityDetail detail){
        facility.getFacilityDetail().add(detail);
        System.out.println("New Facility Detail has been added. ");
    }
     */

    public void listFacilityDetail(){
        for (FacilityDetail detail: detailsArrayList){
            System.out.println(detail);
        }
    }


}
