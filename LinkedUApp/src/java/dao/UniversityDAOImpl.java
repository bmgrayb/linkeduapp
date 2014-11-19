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
import model.StudentModel;
import model.UniversityModel;

/**
 *
 * @author brando
 */
public class UniversityDAOImpl implements UniversityDAO{

    @Override
    public ArrayList<UniversityModel> getAllUniversities() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.University";
        
        ArrayList<UniversityModel> u = new ArrayList<UniversityModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, officalName, availability;
            String address, city, stAbbr, zip, email;
            boolean isFeatured;
            int universityID, enrollment;


            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                officalName = rs.getString("officialname");
                availability = rs.getString("availability");
                email = rs.getString("email");
                address = rs.getString("address");
                city = rs.getString("city");
                stAbbr = rs.getString("stabbr");
                zip = rs.getString("zip");
                universityID = rs.getInt("universityID");
                enrollment = rs.getInt("enrollment");
                isFeatured = rs.getBoolean("isfeatured");
            
                UniversityModel temp = new UniversityModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setOfficalName(officalName);
                temp.setEmail(email);
                temp.setAvailability(availability);
                temp.setAddress(address);
                temp.setCity(city);
                temp.setStAbbr(stAbbr);
                temp.setZip(zip);
                temp.setUniversityID(universityID);
                temp.setEnrollment(enrollment);
                temp.setIsFeatured(isFeatured);
                
                u.add(temp);
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
    
        return u;
    
    }

    @Override
    public UniversityModel getUniversityByID(int id) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.University where universityid = " +id;
        
        UniversityModel temp = new UniversityModel();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, officalName, availability;
            String address, city, stAbbr, zip, email;
            boolean isFeatured;
            int universityID, enrollment;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                officalName = rs.getString("officialname");
                availability = rs.getString("availability");
                email = rs.getString("email");
                address = rs.getString("address");
                city = rs.getString("city");
                stAbbr = rs.getString("stabbr");
                zip = rs.getString("zip");
                universityID = rs.getInt("universityID");
                enrollment = rs.getInt("enrollment");
                isFeatured = rs.getBoolean("isfeatured");
            
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setOfficalName(officalName);
                temp.setEmail(email);
                temp.setAvailability(availability);
                temp.setAddress(address);
                temp.setCity(city);
                temp.setStAbbr(stAbbr);
                temp.setZip(zip);
                temp.setUniversityID(universityID);
                temp.setEnrollment(enrollment);
                temp.setIsFeatured(isFeatured);
                
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
    
        return temp;
    
    }

    @Override
    public ArrayList<UniversityModel> getUniversitiesEnrollmentGreater(int enrollment) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.University where enrollment > " + enrollment;
        
        ArrayList<UniversityModel> u = new ArrayList<UniversityModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, officalName, availability;
            String address, city, stAbbr, zip, email;
            boolean isFeatured;
            int universityID, newEnrollment;


            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                officalName = rs.getString("officialname");
                availability = rs.getString("availability");
                email = rs.getString("email");
                address = rs.getString("address");
                city = rs.getString("city");
                stAbbr = rs.getString("stabbr");
                zip = rs.getString("zip");
                universityID = rs.getInt("universityID");
                newEnrollment = rs.getInt("enrollment");
                isFeatured = rs.getBoolean("isfeatured");
            
                UniversityModel temp = new UniversityModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setOfficalName(officalName);
                temp.setEmail(email);
                temp.setAvailability(availability);
                temp.setAddress(address);
                temp.setCity(city);
                temp.setStAbbr(stAbbr);
                temp.setZip(zip);
                temp.setUniversityID(universityID);
                temp.setEnrollment(newEnrollment);
                temp.setIsFeatured(isFeatured);
                
                u.add(temp);
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
    
        return u;
    
    }

    @Override
    public ArrayList<UniversityModel> getUniversitiesEnrollmentSmaller(int enrollment) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.University where enrollment < " + enrollment;
        
        ArrayList<UniversityModel> u = new ArrayList<UniversityModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, officalName, availability;
            String address, city, stAbbr, zip, email;
            boolean isFeatured;
            int universityID, newEnrollment;


            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                officalName = rs.getString("officialname");
                availability = rs.getString("availability");
                email = rs.getString("email");
                address = rs.getString("address");
                city = rs.getString("city");
                stAbbr = rs.getString("stabbr");
                zip = rs.getString("zip");
                universityID = rs.getInt("universityID");
                newEnrollment = rs.getInt("enrollment");
                isFeatured = rs.getBoolean("isfeatured");
            
                UniversityModel temp = new UniversityModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setOfficalName(officalName);
                temp.setEmail(email);
                temp.setAvailability(availability);
                temp.setAddress(address);
                temp.setCity(city);
                temp.setStAbbr(stAbbr);
                temp.setZip(zip);
                temp.setUniversityID(universityID);
                temp.setEnrollment(newEnrollment);
                temp.setIsFeatured(isFeatured);
                
                u.add(temp);
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
    
        return u;
    
    }

    @Override
    public int addUniversity(UniversityModel univ) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.University values('"
            + univ.getUsername()
            + "','" + univ.getPassword()
            + "',default"
            + ",'" + univ.getOfficalName()
            + "'," + univ.getEnrollment()
            + ",'" + univ.getAvailability()
            + "','" + univ.getAddress()
            + "','" + univ.getCity()
            + "','" + univ.getStAbbr()
            + "','" + univ.getZip()
            + "','" + univ.getEmail()
            + "'," + univ.isIsFeatured()
            +")";
            
            row = stmt.executeUpdate(insertString);
            System.out.println("Insert String: " + insertString);
            DBConn.close();
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return row;
    
    }
    
}
