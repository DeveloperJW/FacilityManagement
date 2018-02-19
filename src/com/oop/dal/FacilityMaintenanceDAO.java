package com.oop.dal;
//need to add couple of imports
import com.oop.model.Facility.BuildingUnit;
import com.oop.model.Facility.Facility;
import com.oop.model.FacilityMaintenance.Maintenance;
import com.oop.model.FacilityMaintenance.MaintenanceRequest;
import com.oop.model.FacilityMaintenance.MaintenanceProblem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java data structures
import java.util.*;

public class FacilityMaintenanceDAO {

    public FacilityMaintenanceDAO(){

    }

    /**
     * makeFacilityMaintRequest()
     */
    public boolean makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement maintReqPst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return false;

    }

    /**
     * scheduleMaintenance()
     */
    public boolean scheduleMaintenance(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement scheduleMaintPst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return false;
    }

    /**
     * calcMaintenanceCostForFacility
     */
    public double calcMaintenanceCostForFacility(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement calcMaintCostPst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    }

    /**
     * calcProblemRateForFacility()
     */
    public double calcProblemRateForFacility(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement calcProblemRatePst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    }

    /**
     * calcDownTimeForFacility()
     */
    public Date calcDownTimeForFacility(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement calcDownTimePst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return 0;
    }

    /**
     * listMaintRequests()
     */
    public List<MaintenanceRequest> listMaintRequests(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement listMaintReqPst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;

    }

    /**
     * listMaintenance()
     */
    public List<Maintenance> listMaintenance(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement listMaintPst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;
    }

    /**
     * listFacilityProblem()
     */
    public List<MaintenanceProblem> listFacilityProblem(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement listFacilityProblemPst=null;
        try{

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;
    }
}
