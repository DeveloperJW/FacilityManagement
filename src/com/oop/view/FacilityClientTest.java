package com.oop.view;

import com.oop.model.Facility.Facility;
import com.oop.model.Facility.FacilityAddress;
import com.oop.model.Facility.FacilityDetail;

import static org.junit.jupiter.api.Assertions.*;

class FacilityClientTest {
    protected FacilityClient facilityClient;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        facilityClient=new FacilityClient();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        facilityClient=null;
    }

    @org.junit.jupiter.api.Test
    void getCapacityTest() {
        Facility facility=new Facility();
        facility.setCapacity(300);
        assertEquals(300, facility.getCapacity());
    }

}