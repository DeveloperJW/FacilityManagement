package com.oop.view;

import com.oop.model.FacilityUse.*;

public class FacilityUseClient {
    public static void main(String args[]) throws Exception{
        //set up Customer 1
        Customer customer1=new Customer();
        customer1.setCustomerId("1");
        customer1.setFirstName("Justin");
        customer1.setLastName("Wang");
        customer1.setContactNumber("312-999-9999");
        customer1.setSsn("999-99-9999");

        //set up Customer 2
        Customer customer2=new Customer();
        customer2.setCustomerId("2");
        customer2.setFirstName("David");
        customer2.setLastName("Zhang");
        customer2.setContactNumber("812-999-9999");
        customer2.setSsn("111-11-1111");
        //some methods to test

    }



}
