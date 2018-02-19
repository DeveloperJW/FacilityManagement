package com.oop.dal;
//need to add couple of imports
import com.oop.model.Facility.BuildingUnit;
import com.oop.model.Facility.Facility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java data structures
import java.util.*;

public class FacilityDAO {

    public FacilityDAO() {
        //default constructor
    }
    /**
     *List all the facilities
     * @return List<Facility>
     */
    public List<Facility> listFacilities(){
        Connection con= DBHelper.getConnection();
        Statement stmt=null;
        List<Facility> facilityList=new ArrayList<Facility>();

        try{
            //Get Facility
            stmt=con.createStatement();
            String selectlistFacilitiesQuery="SELECT facilityId, facilityName, facilityType FROM facility";
            ResultSet facilityRS=stmt.executeQuery(selectlistFacilitiesQuery);
            System.out.println("FacilityDAO: *************** Query \" + selectlistFacilitiesQuery);");
            //Get Facility
            Facility facility=new Facility();

            while(facilityRS.next()) {
                facility.setFacilityId(facilityRS.getString("facilityId"));
                facility.setFacilityName(facilityRS.getString("facilityName"));
                facility.setFacilityType(facilityRS.getString("facilityType"));
                facilityList.add(facility);
            }
            //close to manage resources
            facilityRS.close();

        }//end of try

        catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return facilityList;
    }//end of listFacility
    /**
     * Get the facility information
     */
    public Facility getFacilityInformation(){
        String getInfoQuery="SELECT * FROM Facility WHERE facilityId='?'";
        Connection con= DBHelper.getConnection();
        Statement stmt=null;
        Facility facility=new Facility();

        try{
            //Get Facility
            stmt=con.createStatement();
            ResultSet facilityInfoRS=stmt.executeQuery(getInfoQuery);
            System.out.println("FacilityDAO: *************** Query \" + facilityInfoQuery);");
            //Get Facility
            //Facility facility=new Facility();

            while(facilityInfoRS.next()) {
                facility.setFacilityId(facilityInfoRS.getString("facilityId"));
                facility.setFacilityName(facilityInfoRS.getString("facilityName"));
                facility.setFacilityType(facilityInfoRS.getString("facilityType"));
            }
            //close to manage resources
            facilityInfoRS.close();

        }//end of try

        catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return facility;
    }//end of listFacility


    /**
     * Show how many units and capacity are available
     */
    public int requestAvailableCapacity(BuildingUnit unit){
        int availableCap=0;
        String requestQuery="SELECT COUNT(status) FROM BuildingUnit WHERE status='AVAIABLE' AND FacilityID='?'";
        Connection con= DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement capacityStatement=null;

        try{
            stmt=con.createStatement();
            capacityStatement =con.prepareStatement(requestQuery);

            capacityStatement.setString(1, unit.getUnitId());
            ResultSet rs=capacityStatement.executeQuery(requestQuery);
            while(rs.next()){
                availableCap+=rs.getInt(1);
            }
            stmt.close();
        }
        catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return availableCap;
    }



    /**
     * add a new Facility
     * @param
     * @return
     */
    public String addNewFacility(Facility facility){
        String successMsg="New facility been added!";
        Connection con= DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement facilityStatement=null;
        String addQuery="INSERT INTO Facility(facilityId,facilityName,capacity, floorArea, facilityType, status," +
                "facilityAddress) VALUES(?,?);";
        try{
            facilityStatement=con.prepareStatement(addQuery);
            facilityStatement.setString(1,facility.getFacilityId());
            facilityStatement.setString(2,facility.getFacilityName());
            facilityStatement.setInt(3,facility.getCapacity());
        }
        catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return successMsg;
    }

    /**
     * Add details to certain facility
     */
    public void AddFacilityDetail(BuildingUnit unit){
        Connection con= DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement buildingUnitStatement=null;
        String addDetailQuery="INSERT INTO BuildingUnit(unit_id, building_id, floor_level, floorArea, status) VALUES(?,?);";
        try{
            buildingUnitStatement=con.prepareStatement(addDetailQuery);
            buildingUnitStatement.setString(1,unit.getUnitId());
            buildingUnitStatement.setString(2,unit.getBuildingId());
            buildingUnitStatement.setInt(3,unit.getFloorLevel());
            buildingUnitStatement.setDouble(4,unit.getFloorArea());
            buildingUnitStatement.setString(5,unit.getStatus());
        }
        catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }

    }

    /**
     * remove a Facility
     */
    public String removeFacility(Facility facility){
        Connection con= DBHelper.getConnection();
        Statement stmt=null;
        String successMsg="The facility has been removed!";
        PreparedStatement facilityStatement=null;
        String removeQuery="DELETE FROM Facility WHERE facilityId='?'";
        try{
            stmt=con.createStatement();
            PreparedStatement preparedStatement=con.prepareStatement(removeQuery);
            preparedStatement.setString(1,facility.getFacilityId());
            preparedStatement.execute(removeQuery);

            stmt.close();

        }
        catch (SQLException se) {
            System.err.println("FacilityDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return successMsg;
    }
}


