/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.RecruiterModel;

/**
 *
 * @author brando
 */
public class RecruiterDAOImpl implements RecruiterDAO{

    @Override
    public ArrayList<RecruiterModel> getAllRecruiters() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Recruiter";
        
        ArrayList<RecruiterModel> r = new ArrayList<RecruiterModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, firstName, lastName, email;
            int recruiterID, universityID;
            boolean isPaidService;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                recruiterID = rs.getInt("recruiterid");
                universityID = rs.getInt("universityid");
                isPaidService = rs.getBoolean("ispaidservice");
            
                RecruiterModel temp = new RecruiterModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setRecruiterID(recruiterID);
                temp.setUniversityID(universityID);
                temp.setIsPaidService(isPaidService);
                
                r.add(temp);
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
    
        return r;
    
    }

    @Override
    public RecruiterModel getRecruiterByID(int id) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Recruiter where recruiterid = " +id;
        
        RecruiterModel temp = new RecruiterModel();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, firstName, lastName, email;
            int recruiterID, universityID;
            boolean isPaidService;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                recruiterID = rs.getInt("recruiterid");
                universityID = rs.getInt("universityid");
                isPaidService = rs.getBoolean("ispaidservice");
            
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setRecruiterID(recruiterID);
                temp.setUniversityID(universityID);
                temp.setIsPaidService(isPaidService);
                
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
    public int addRecruiter(RecruiterModel rec) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.Recruiter values('"
            + rec.getUsername()
            + "','" + rec.getPassword()
            + "',default"  
            + "," + rec.getUniversityID()
            + ",'" + rec.getFirstName()
            + "','" + rec.getLastName()
            + "','" + rec.getEmail()
            + "'," + rec.isIsPaidService()
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
