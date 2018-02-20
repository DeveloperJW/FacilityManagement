package com.oop.dal;
//need to add couple of imports
import com.oop.model.Facility.BuildingUnit;
import com.oop.model.Facility.Facility;
import com.oop.model.FacilityUse.Inspection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java data structures
import java.util.*;

public class FacilityUseDAO {

    public FacilityUseDAO(){

    }

    /**
     * Check if the unit is in use during a certain time period
     */
    public boolean isInUseDuringInterval(Date start, Date end){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        Boolean isUsing =false;
        try{


        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return isUsing;
    }

    /**
     * assignFacilityToUse
     */
    public boolean assignFacilityToUse(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement addPst=null;
        try{
            //insert facility
            String addStm="INSERT INTO FacilitySchedule(scheduleId, unitId, startDateTime, endDateTime" +
                    "customerId) VALUES (?,?,?,?,?)";
            addPst.setString(1, "scheduleId");
            addPst.setString(2,"unitId");
            addPst.setObject(3, "startDateTime");
            addPst.setObject(4, "endDateTime");
            addPst.setString(5, "customerId");
            addPst.executeUpdate();

        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        } finally {
            try {
                if (addPst != null) {
                    addPst.close();
                }
                if (con != null) {
                    con.close();
                }
            }catch (SQLException ex){
                System.err.println("FacilityUseDAO: Threw a SQLException saving the Facility object.");
                System.err.println(ex.getMessage());
            }
        }
        return false;
    }
    /**
     * vacateFacility()
     */
    //TODO: need
    public boolean vacateFacility(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return false;
    }

    /**
     * Show a list of inpsections done with the Unit
     * listInspections()
     */
    public List<Inspection> listInspections(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        List<Inspection> inspectionList= new ArrayList<Inspection>();
        try{
            //get inspection
            stmt=con.createStatement();
            String listInspectionsQuery="SELECT inspectionId, inspectorName, inspectionResult, " +
                    "inspectionDate FROM Inspection WHERE UnitId='?'";
            ResultSet inspectionRS=stmt.executeQuery(listInspectionsQuery);
            System.out.println("FacilityUseDAO: *************** Query \" + listInspectionsQuery);");
            //Get Facility
            Facility facility=new Facility();
            Inspection inspection=new Inspection();

            while(inspectionRS.next()) {
                inspection.setInspectionId(inspectionRS.getNString("inspectionId"));
                inspection.setUnitId(inspectionRS.getString("unitId"));
                inspection.setInpectorName(inspectionRS.getNString("inspectorName"));
                inspection.setInspectionResult(inspectionRS.getString("inspectionResult"));
                inspection.setInspectionDate(inspectionRS.getDate("inspectionDate"));
                inspectionList.add(inspection);
            }
            //close to manage resources
            inspectionRS.close();


        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return inspectionList;
    }

    /**
     * listActualUsage()
     */
    //TODO: change List<String>
    public List<String> listActualUsage(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;

    }


    /**
     * calcUsageRate()
     */
    //TODO:Implementation
    public double calcUsageRate(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    }




}
