package com.oop.dal;
//need to add couple of imports
import com.oop.model.Facility.BuildingUnit;
import com.oop.model.Facility.Facility;
import com.oop.model.FacilityMaintenance.Maintenance;
import com.oop.model.FacilityMaintenance.MaintenanceCost;
import com.oop.model.FacilityMaintenance.MaintenanceRequest;
import com.oop.model.FacilityMaintenance.FacilityProblem;

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
     * makeFacilityMaintRequest() create a new maintenance request
     */
    public void makeFacilityMaintRequest(MaintenanceRequest maintenanceRequest){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement maintPst=null;
        try{
            //create maintenance request query
            String insertMaintReqQuery="INSERT INTO MaintenanceRequest(reqId,reqDate,customerId,unitId) Values(?," +
                    "?,?,?";
            maintPst =con.prepareStatement(insertMaintReqQuery);
            maintPst.setString(1, maintenanceRequest.getReqId());
            maintPst.setObject(2, maintenanceRequest.getReqDate());
            maintPst.setString(3, maintenanceRequest.getCustomerId());
            maintPst.setString(4, maintenanceRequest.getUnitId());
            maintPst.executeUpdate();
        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving MaintenanceRequest object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
    }

    /**
     * scheduleMaintenance()
     */
    public boolean scheduleMaintenance(Maintenance maintenance){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement scheduleMaintPst=null;
        String scheduleMaintStm="INSERT INTO Maintenance(maintenanceId, buildingId, unitId, problemType," +
                "workerName, workerContactNum, startDateTime, endDateTime) VALUES (?,?,?,?,?,?,?,?)";
        try{
            scheduleMaintPst=con.prepareStatement(scheduleMaintStm);
            scheduleMaintPst.setString(1, maintenance.getMaintenanceId());
            scheduleMaintPst.setString(2, maintenance.getBuildingId());
            scheduleMaintPst.setString(3, maintenance.getUnitId());
            scheduleMaintPst.setString(4, maintenance.getProblemType());
            scheduleMaintPst.setString(5, maintenance.getWorkerName());
            scheduleMaintPst.setString(6, maintenance.getWorkerContactNum());
            scheduleMaintPst.setObject(7, maintenance.getStartDateTime());
            scheduleMaintPst.setObject(8, maintenance.getEndDateTime());
            scheduleMaintPst.executeUpdate();

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the Maintenance object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return false;
    }

    /**
     * calcMaintenanceCostForFacility
     */
    public boolean calcMaintenanceCostForFacility(MaintenanceCost maintenanceCost){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement maintCostPst=null;
        String costStm="INSERT INTO MaintenanceCost(maintenanceReqId, materialCost, laborHourlyRate,laborCost, paidOrNot) " +
                "VALUES(?,?,25,?,?)";

        try{
            maintCostPst=con.prepareStatement(costStm);
            maintCostPst.setString(1, maintenanceCost.getMaintenanceReqId());
            maintCostPst.setDouble(2, maintenanceCost.getMaterialCost());
            maintCostPst.setDouble(3, 25);
            maintCostPst.setDouble(4, maintenanceCost.getLaborCost());
            maintCostPst.setBoolean(5, maintenanceCost.getPaidOrNot());
            maintCostPst.executeUpdate();
        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return false;
    }

    /**
     * calcProblemRateForFacility()
     */
    public double calcProblemRateForFacility(Facility facility){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement problemRatePst=null;
        double problemRate=0;
        String problemRateStm="SELECT count(maintProblemId)/(count(unitId)) as p_rate FROM Maintenance,BuildingUnit";
        try{
            ResultSet problemRateRs=stmt.executeQuery(problemRateStm);
            System.out.println("FacilityMaintenanceDAO: *************** Query \" + calcProblemRateQuery);");
            if(problemRateRs.next()){
                problemRate=problemRateRs.getDouble("p_rate");
            }
        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return problemRate;
    }

    /**
     * calcDownTimeForFacility()
     */
    public long calcDownTimeForFacility(Maintenance maintenance){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement calcDownTimePst=null;
        long durationInHour=0;
        try{
            String downTimeStm="SELECT startDateTime, endDateTime FROM Maintenance WHERE maintenanceId='?'";
            calcDownTimePst=con.prepareStatement(downTimeStm);
            calcDownTimePst.setObject(1, maintenance.getStartDateTime());
            calcDownTimePst.setObject(2, maintenance.getEndDateTime());
            calcDownTimePst.executeUpdate();
            Date start=maintenance.getStartDateTime();
            Date end=maintenance.getEndDateTime();
            durationInHour=maintenance.getTimeDurationInHour(start,end);

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return durationInHour;
    }

    /**
     * Method listMaintRequests() return a list of MaintenanceRequest
     * @return List<MaintenanceRequest>
     */
    public List<MaintenanceRequest> listMaintRequests(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement listMaintReqPst=null;
        List<MaintenanceRequest> maintReqList= new ArrayList<MaintenanceRequest>();
        try{
            //
            stmt=con.createStatement();
            String listMaintReqQuery="SELECT * FROM MaintenanceRequest WHERE reqId='?'";
            ResultSet maintReqRS=stmt.executeQuery(listMaintReqQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query \" + listMaintReqQuery);");
            //Get Facility
            MaintenanceRequest maintenanceRequest=new MaintenanceRequest();


            while(maintReqRS.next()) {
                maintenanceRequest.setReqId(maintReqRS.getString("reqId"));
                maintenanceRequest.setReqDate(maintReqRS.getDate("reqDate"));
                maintenanceRequest.setCustomerId(maintReqRS.getString("customerId"));
                maintenanceRequest.setUnitId(maintReqRS.getString("unitId"));
                maintReqList.add(maintenanceRequest);
            }
            //close to manage resources
            maintReqRS.close();

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return maintReqList;

    }

    /**
     * listMaintenance()
     * @return
     */
    public List<Maintenance> listMaintenance(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement listMaintPst=null;
        List<Maintenance> maintList= new ArrayList<Maintenance>();
        try{
            //
            stmt=con.createStatement();
            String listMaintQuery="SELECT * FROM Maintenance WHERE maintenanceId='?'";
            ResultSet maintRS=stmt.executeQuery(listMaintQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query \" + listMaintReqQuery);");
            //Get Facility
            Maintenance maint=new Maintenance();


            while(maintRS.next()) {
                maint.setMaintenanceId(maintRS.getString("maintenanceId"));
                maint.setBuildingId(maintRS.getString("buildingID"));
                maint.setUnitId(maintRS.getString("unitID"));
                maint.setProblemType(maintRS.getString("problemType"));
                maint.setWorkerName(maintRS.getString("workerName"));
                maint.setWorkerContactNum(maintRS.getString("workerContactNum"));
                maint.setStartDateTime(maintRS.getDate("startDateTime"));
                maint.setEndDateTime(maintRS.getDate("endDateTime"));
                maintList.add(maint);
            }
            //close to manage resources
            maintRS.close();

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return maintList;
    }

    /**
     * listFacilityProblem()
     */
    public List<FacilityProblem> listFacilityProblem(){
        Connection con=DBHelper.getConnection();
        Statement stmt=null;
        PreparedStatement listFacilityProblemPst=null;
        List<FacilityProblem> facilityProblemList= new ArrayList<FacilityProblem>();
        try{
            //
            stmt=con.createStatement();
            String listFacilityProblemQuery="SELECT * FROM FacilityProblem WHERE super().reqId='?'";
            ResultSet problemRS=stmt.executeQuery(listFacilityProblemQuery);
            System.out.println("FacilityMaintenanceDAO: *************** Query \" + listFacilityProblemQuery);");
            //Get
            //MaintenanceRequest maintenanceRequest=new MaintenanceRequest();
            FacilityProblem facilityProblem=new FacilityProblem();

            while(problemRS.next()) {
                facilityProblem.setMaintProblemId(problemRS.getString("maintProblemId"));
                facilityProblem.setMaintProblemType(problemRS.getString("maintProblemType"));
                facilityProblem.setMaintProblemDetails(problemRS.getString("maintProblemDetails"));
                facilityProblem.setFixedOrNot(problemRS.getBoolean("fixedOrNot"));
                //question: can subclass get attribute from super class?
                facilityProblem.setReqId(problemRS.getString("reqId"));
                facilityProblem.setUnitId(problemRS.getString("unitID"));
                facilityProblem.setCustomerId(problemRS.getString("customerId"));
                facilityProblemList.add(facilityProblem);
            }
            //close to manage resources
            problemRS.close();

        }
        catch (SQLException se) {
            System.err.println("FacilityMaintenanceDAO: Threw a SQLException retrieving the facility object.");
            System.err.println(se.getMessage());
            se.printStackTrace();
        }
        return null;
    }
}
