package com.oop.model.FacilityUse;

import java.util.ArrayList;

public class UsageMgt {
    public UsageMgt(){
        //default constructor
    }
    private ArrayList<Usage> usagesList=new ArrayList<Usage>();

    public void addUsage(Usage u){
        this.usagesList.add(u);
    }

    public void removeUsage(Usage u){
        if (usagesList.contains(u)){
            this.usagesList.remove(u);
        }
        else{
            System.out.println("Error, usage not existing. Please check your entry.");
        }
    }

    public void listActualUsage(){
        for (Usage u: usagesList){
            System.out.println(u.toString());
        }
    }

}
