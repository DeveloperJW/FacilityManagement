package com.oop.view;

import com.oop.model.FacilityMaintenance.*;

import java.time.LocalDate;

public class FacilityMaintClient {
    public static void main(String args[]) throws Exception{
        //First maintenance example
        Maintenance maintenance1=new Maintenance();
        maintenance1.setMaintenanceId("1");
        maintenance1.setBuildingId("1");
        maintenance1.setUnitId("666");
        maintenance1.setProblemType("Electric");
        maintenance1.setWorkerName("Justin");
        maintenance1.setWorkerContactNum("312-999-9999");

        //second maintenance example
        Maintenance maintenance2=new Maintenance();
        maintenance2.setMaintenanceId("2");
        maintenance2.setBuildingId("2");
        maintenance2.setUnitId("111");
        maintenance2.setProblemType("Electric");
        maintenance2.setWorkerName("David");
        maintenance2.setWorkerContactNum("812-999-9999");

        //set example maintenance request



        //set example FacilityProblem

        //add some new Maintenance
        addMaintenanceTest(maintenance1);
        System.out.println();
        addMaintenanceTest(maintenance2);

    }
    //set up example maintenance
    public static void addMaintenanceTest(Maintenance maintenance){
        MaintenanceMgt maintenanceMgt=new MaintenanceMgt();
        maintenanceMgt.addMaintenance(maintenance);
        maintenanceMgt.listMaintenance();
        System.out.println("New maintenance have been added. ");
    }
}
