package com.oop.view;

import com.oop.model.FacilityUse.Customer;

public class FacilityUseClient {
    public static void main(String args[]) throws Exception{
        Customer customer=new Customer();
        customer.setCustomerId("001");
        customer.setFirstName("Justin");
        customer.setLastName("Wang");
        customer.setContactNumber("312-999-9999");
        customer.setSsn("999-99-9999");
    }
}
