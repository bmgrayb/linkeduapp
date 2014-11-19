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
import model.MultimediaModel;

/**
 *
 * @author brando
 */
public class MultimediaDAOImpl implements MultimediaDAO{

    @Override
    public ArrayList<MultimediaModel> getAllURL() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Multimedia";
        
        ArrayList<MultimediaModel> mult = new ArrayList<MultimediaModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String url;
            int mixtapeID, studentID;
            float rating;

            while(rs.next()){
                
                studentID = rs.getInt("studentID");
                mixtapeID = rs.getInt("mixtapeID");
                url = rs.getString("url");
                rating = rs.getFloat("rating");
                
                MultimediaModel temp = new MultimediaModel();
                
                temp.setStudentID(studentID);
                temp.setMixtapeID(mixtapeID);
                temp.setUrl(url);
                temp.setRating(rating);
            
                mult.add(temp);
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
    
        return mult;
        
        
    }

    @Override
    public ArrayList<MultimediaModel> getURLByID(int studentID) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM LINKEDU.Multimedia where studentID = " + studentID;
        
        ArrayList<MultimediaModel> mult = new ArrayList<MultimediaModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String url;
            int mixtapeID, newStudentID;
            float rating;

            while(rs.next()){
                
                newStudentID = rs.getInt("studentID");
                mixtapeID = rs.getInt("mixtapeID");
                url = rs.getString("url");
                rating = rs.getFloat("rating");
                
                MultimediaModel temp = new MultimediaModel();
                
                temp.setStudentID(studentID);
                temp.setMixtapeID(mixtapeID);
                temp.setUrl(url);
                temp.setRating(rating);
            
                mult.add(temp);
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
    
        return mult;
    
    }

    @Override
    public int addMultimedia(MultimediaModel mult) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.Multimedia values(default,"
            + mult.getStudentID()
            + ",'" + mult.getUrl() + "'"
            + "," + mult.getRating()
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
