package com.oop.model.FacilityUse;

import java.util.ArrayList;

public class InspectionMgt {
    public InspectionMgt(){
        //default constructor
    }
    private ArrayList<Inspection> inspectionsList=new ArrayList<Inspection>();

    public ArrayList<Inspection> getInspectionsList() {
        return inspectionsList;
    }

    public void setInspectionsList(ArrayList<Inspection> inspectionsList) {
        this.inspectionsList = inspectionsList;
    }

    public void addInspection(Inspection inspection){
        inspectionsList.add(inspection);
    }

    public void listInspections(){
        for (Inspection inspect:inspectionsList){
            System.out.println(inspect.toString());
        }
    }
}
