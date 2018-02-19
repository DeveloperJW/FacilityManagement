package com.oop.view;
import com.oop.model.Facility.*;

public class FacilityClient {
    public static void main(String args[]) throws Exception{

        Facility facility=new Facility();
        facility.setFacilityId("111");
        facility.setFacilityName("Loyola Hall");
        facility.setCapacity(300);

        FacilityAddress facilityAddress=new FacilityAddress();
        facility.setFacilityAddress(facilityAddress);
        facilityAddress.setAddressId("1");
        facilityAddress.setStreet("1234 W Loyola Hall");
        facilityAddress.setCity("Chicago");
        facilityAddress.setState("IL");
        facilityAddress.setUnit("Unit 666");
        facilityAddress.setZip("60626");

    }
}
