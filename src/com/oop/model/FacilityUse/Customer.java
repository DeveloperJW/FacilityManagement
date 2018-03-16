package com.oop.model.FacilityUse;

public class Customer {
    private String customerId;
    private String firstName;
    private String lastName;
    private String contactNumber;
    private String address;
    private String ssn;

    public Customer(){
        //default constructor
    }

    //methods
    public String getCustomerId(){
        return customerId;
    }

    public void setCustomerId(String newCustId){
        this.customerId=newCustId;
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String newFirstName){
        this.firstName=newFirstName;
    }

    public String getLastName(){
        return lastName;
    }

    public void setLastName(String newLastName){
        this.lastName=newLastName;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String newAdd){
        this.address=newAdd;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(String newNum){
        this.contactNumber=newNum;
    }

    public String getSsn(){
        return ssn;
    }

    public void setSsn(String newSsn){
        this.ssn=newSsn;
    }

    public String toString(){
        String result="";
        result="CustomerName: "+this.lastName+", "+this.firstName+"\n";
        result+="CutomerAddress: "+this.address+"\n";
        result+="Customer Contact Number: "+this.contactNumber+"\n";

        return result;
    }
}
