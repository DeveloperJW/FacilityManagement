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
     * assignFacilityToUse
     */
    public boolean assignFacilityToUse(Facility facility){
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
     * vacateFacility()
     */
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
