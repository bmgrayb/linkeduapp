/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
import model.AppointmentModel;

/**
 *
 * @author brando
 */
public class AppointmentDAOImpl implements AppointmentDAO{

    @Override
    public ArrayList<AppointmentModel> getAllAppointments() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Appointment";
        
        ArrayList<AppointmentModel> appt = new ArrayList<AppointmentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Date visitDate;
            int universityID, studentID;

            while(rs.next()){
                
                studentID = rs.getInt("studentID");
                universityID = rs.getInt("universityID");
                visitDate = rs.getDate("visitdate");
                
                AppointmentModel temp = new AppointmentModel();
                
                temp.setUniversityID(universityID);
                temp.setStudentID(studentID);
                temp.setVisitDate(visitDate);
            
                appt.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return appt;
        
    }

    @Override
    public ArrayList<AppointmentModel> getUniversityAppointments(int univID) {
        
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.Appointment where universityid = " + univID;
        
        ArrayList<AppointmentModel> appt = new ArrayList<AppointmentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Date visitDate;
            int universityID, studentID;

            while(rs.next()){
                
                studentID = rs.getInt("studentID");
                universityID = rs.getInt("universityID");
                visitDate = rs.getDate("visitdate");
                
                AppointmentModel temp = new AppointmentModel();
                
                temp.setUniversityID(universityID);
                temp.setStudentID(studentID);
                temp.setVisitDate(visitDate);
            
                appt.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return appt;
    }

    @Override
    public ArrayList<AppointmentModel> getStudentAppointments(int stuID) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.Appointment where studentid = " + stuID;
        
        ArrayList<AppointmentModel> appt = new ArrayList<AppointmentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Date visitDate;
            int universityID, studentID;

            while(rs.next()){
                
                studentID = rs.getInt("studentID");
                universityID = rs.getInt("universityID");
                visitDate = rs.getDate("visitdate");
                
                AppointmentModel temp = new AppointmentModel();
                
                temp.setUniversityID(universityID);
                temp.setStudentID(studentID);
                temp.setVisitDate(visitDate);
            
                appt.add(temp);
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return appt;
        
    }

    @Override
    public AppointmentModel getAppointment(int studentID, int universityID, Date date) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.Appointment where studentID = " + studentID 
                + " and universityID = " + universityID
                + " and visitdate = '" + date.toString() + "'";
        
        AppointmentModel appt = new AppointmentModel();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            Date visitDate;
            int newUniversityID, newStudentID;

            while(rs.next()){
                
                newStudentID = rs.getInt("studentID");
                newUniversityID = rs.getInt("universityID");
                visitDate = rs.getDate("visitdate");
                                
                appt.setUniversityID(newUniversityID);
                appt.setStudentID(newStudentID);
                appt.setVisitDate(visitDate);
            
            } 
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    
        return appt;
        
    }

    @Override
    public int addAppointment(AppointmentModel appt) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.Appointment values("
            + appt.getUniversityID()
            + "," + appt.getStudentID()
            + ",'" + appt.getVisitDate().toString()
            +"')";
            
            row = stmt.executeUpdate(insertString);
            System.out.println("Insert String: " + insertString);
            DBConn.close();
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return row;
    }
        
    
}
