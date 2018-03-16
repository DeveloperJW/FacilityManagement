package com.oop.model.Facility;

public class FacilityAddress {
    private String addressId;
    private String street;
    private String unit;
    private String city;
    private String state;
    private String zip;

    public FacilityAddress(){
        //default constructor
    }
    //Address
    public String getAddressId(){
        return addressId;
    }

    public void setAddressId(String newAddressId){
        this.addressId=newAddressId;
    }
    //street
    public String getStreet(){
        return street;
    }

    public void setStreet(String newStreet){
        this.street=newStreet;
    }
    //unit
    public String getUnit(){
        return unit;
    }

    public void setUnit(String newwUnit){
        this.unit=newwUnit;
    }
    //city
    public String getCity(){
        return city;
    }

    public void setCity(String newCity){
        this.city=newCity;
    }
    //state
    public String getState(){
        return state;
    }

    public void setState(String newState){
        this.state=newState;
    }
    //zip code
    public String getZip(){
        return zip;
    }

    public void setZip(String newZip){
        this.zip=newZip;
    }

    public String toString(){
        String result="";
        result="The address of the facility is: "+this.unit+" "+this.street+", "+this.city+", "
                +this.state+", "+this.zip;
        return result;
    }


}
