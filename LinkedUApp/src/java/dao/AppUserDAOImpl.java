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
import model.AppUserModel;

/**
 *
 * @author brando
 */
public class AppUserDAOImpl implements AppUserDAO{

    @Override
    public boolean validate(String username, String password) {
        boolean valid = false;
        
        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT PASSWORD FROM LINKEDU.UNIVERSITY WHERE USERNAME = '" + username + "'";
        String newPassword="";
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
           
            while(rs.next()){
                newPassword = rs.getString("password");
            } 
            rs.close();
            stmt.close();
            
        } catch (Exception e) {
            System.err.println("ERROR: Problems with SQL select");
            e.printStackTrace();
        }
        try {
            DBConn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        
        
        if(newPassword != null && password.equals(newPassword))
            valid = true;
        
        return valid;
    }

    @Override
    public int addUser(AppUserModel user) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.AppUser values('"
            + user.getUsername()
            + "','" + user.getPassword()
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
