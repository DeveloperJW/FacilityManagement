package com.oop.dal;
//need to add couple of imports
import com.oop.model.Facility.BuildingUnit;
import com.oop.model.Facility.Facility;
import com.oop.model.FacilityUse.FacilitySchedule;
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
    public boolean isInUseDuringInterval(String someUnitId, Date start, Date end){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        Boolean isUsing =true;
        try{
            String isInUseStm="SELECT startDateTime, endDateTime FROM FacilitySchedule WHERE unitId='someUnitId'";
            ResultSet isInUseRS= stmt.executeQuery(isInUseStm);
            System.out.println("FacilityUseDAO: *************** Query \" + isInUseQuery);");
            while(isInUseRS.next()){
                Date currentStart=isInUseRS.getDate("startTimeDate");
                Date currentEnd=isInUseRS.getDate("endTimeDate");
                if(start.getTime()<currentStart.getTime() && end.getTime()<currentStart.getTime()){
                    isUsing=false;
                }
                else if(start.getTime()>currentEnd.getTime()){
                    isUsing=false;
                }
            }

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
    public boolean vacateFacility(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement vacatePst=null;
        String vacateStm="DELETE * FROM FacilitySchedule WHERE unitId='?'";

        try{
            vacatePst=con.prepareStatement(vacateStm);
            vacatePst.executeUpdate();
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
            FacilitySchedule facilitySchedule=new FacilitySchedule();
            Inspection inspection=new Inspection(facilitySchedule);

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
     * listActualUsage() display all the current facility schedule
     */
    public List<FacilitySchedule> listActualUsage(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement listUsagePst=null;
        List<FacilitySchedule> actualUsage=new ArrayList<FacilitySchedule>();
        try{
            stmt=con.createStatement();
            String listActualUsageStm="SELECT * FROM FacilitySchedule";
            ResultSet usageRS=stmt.executeQuery(listActualUsageStm);
            FacilitySchedule facilitySchedule = new FacilitySchedule();

            while(usageRS.next()){
                facilitySchedule.setScheduleId(usageRS.getString("scheduleId"));
                facilitySchedule.setCustomerId(usageRS.getString("customerId"));
                facilitySchedule.setUnitId(usageRS.getString("unitId"));
                facilitySchedule.setStartDateTime(usageRS.getDate("startDateTime"));
                facilitySchedule.setEndDateTime(usageRS.getDate("endDateTime"));
            }
            usageRS.close();

        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return actualUsage;

    }


    /**
     * calcUsageRate()
     */
    public double calcUsageRate(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement usageRatePst=null;
        double usageRate=0;
        String usageRateStm="SELECT COUNT(scheduleId)/COUNT(unitId) as u_rate FROM FacilitySchedule, BuilingUnit";
        try{
            ResultSet usageRateRS=stmt.executeQuery(usageRateStm);
            System.out.println("FacilityUseDAO: *************** Query \" + actualUsageQuery);");
            while(usageRateRS.next()){
                usageRate=usageRateRS.getDouble("u_rate");
            }

        }
        catch (SQLException se) {
            System.err.println("FacilityUseDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return usageRate;
    }




}
