package com.oop.view;

import com.oop.model.FacilityMaintenance.Maintenance;

import java.time.LocalDate;

public class FacilityMaintClient {
    public static void main(String args[]) throws Exception{
        Maintenance maintenance=new Maintenance();
        maintenance.setMaintenanceId("001");
        maintenance.setBuildingId("001");
        maintenance.setUnitId("666");
        maintenance.setProblemType("Electric");
        maintenance.setWorkerName("Justin");
        maintenance.setWorkerContactNum("312-999-9999");

    }
}
