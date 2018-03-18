package com.oop.view;
import com.oop.model.Facility.*;
import com.oop.model.FacilityMaintenance.*;
import com.oop.model.FacilityUse.*;

import java.util.ArrayList;

public class FacilityClient {

    public static void main(String args[]) throws Exception {
        //First example Facility
        Facility facility1 = new Facility();
        facility1.setFacilityId("1");
        facility1.setFacilityName("Loyola Hall");
        facility1.setCapacity(300);

        FacilityAddress facilityAddress = new FacilityAddress();
        facility1.setFacilityAddress(facilityAddress);
        facilityAddress.setAddressId("1");
        facilityAddress.setStreet("1234 W Loyola Hall");
        facilityAddress.setCity("Chicago");
        facilityAddress.setState("IL");
        facilityAddress.setUnit("Unit 666");
        facilityAddress.setZip("60626");

        //Second example Facility
        Facility facility2 = new Facility();
        facility2.setFacilityId("2");
        facility2.setFacilityName("Cuneo Hall");
        facility2.setCapacity(300);

        FacilityAddress facilityAddress2 = new FacilityAddress();
        facility2.setFacilityAddress(facilityAddress2);
        facilityAddress2.setAddressId("2");
        facilityAddress2.setStreet("5678 W Loyola Ave");
        facilityAddress2.setCity("Chicago");
        facilityAddress2.setState("IL");
        facilityAddress2.setUnit("Unit 111");
        facilityAddress2.setZip("60626");

        //some test methods
        //ExampleFacility1();
        //ExampleFacility2();
        addNewFacilityTest(facility1);
        System.out.println();
        addNewFacilityTest(facility2);


    }

    public static void addNewFacilityTest(Facility facility){
        FacilityManagement facilityManagement= new FacilityManagement();
        facilityManagement.addFacility(facility);
        facilityManagement.listFacilities();
        System.out.println("New facility have been added. ");
    }

    //

}
