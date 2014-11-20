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
import model.RecruiterModel;
import model.StudentModel;

/**
 *
 * @author brando
 */
public class StudentDAOImpl implements StudentDAO{

    @Override
    public ArrayList<StudentModel> getAllStudents() {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student";
        
        ArrayList<StudentModel> s = new ArrayList<StudentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float gpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                gpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                StudentModel temp = new StudentModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(gpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
                
                s.add(temp);
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
    
        return s;
        
    }

    @Override
    public StudentModel getStudentByID(int id) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where studentid = " +id;
        
        StudentModel temp = new StudentModel();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float gpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                gpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(gpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
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
    public ArrayList<StudentModel> getStudentsWithGreaterGPA(double gpa) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");

        String query = "SELECT * FROM linkedu.Student where gpa > " + gpa;
        
        ArrayList<StudentModel> s = new ArrayList<StudentModel>();
        
        try{
            Statement stmt = DBConn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            String username, password, email, firstName, lastName, highSchool;
            String essay, apCourse, universities, majors;
            boolean isPaidService;
            float newGpa;
            int studentID, ACT, SAT, PSAT, NMSQT, year;

            while(rs.next()){
                
                username = rs.getString("username");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                email = rs.getString("email");
                highSchool = rs.getString("highschool");
                essay = rs.getString("essay");
                apCourse = rs.getString("apcourse");
                universities = rs.getString("universities");
                majors = rs.getString("majors");
                studentID = rs.getInt("studentid");
                ACT = rs.getInt("actscore");
                SAT = rs.getInt("satscore");
                PSAT = rs.getInt("psatscore");
                NMSQT = rs.getInt("NMSQTscore");
                year = rs.getInt("classyear");
                newGpa = rs.getFloat("gpa");
                isPaidService = rs.getBoolean("ispaidservice");
            
                StudentModel temp = new StudentModel();
                temp.setUsername(username);
                temp.setPassword(password);
                temp.setStudentID(studentID);
                temp.setEmail(email);
                temp.setFirstName(firstName);
                temp.setLastName(lastName);
                temp.setYear(year);
                temp.setHighSchool(highSchool);
                temp.setGpa(newGpa);
                temp.setACT(ACT);
                temp.setSAT(SAT);
                temp.setPSAT(PSAT);
                temp.setNMSQT(NMSQT);
                temp.setApCourse(apCourse);
                temp.setEssay(essay);
                temp.setUniversities(universities);
                temp.setMajors(majors);
                temp.setIsPaidService(isPaidService);
                
                s.add(temp);
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
    
        return s;
        
    
    }

    @Override
    public int updateStudent(StudentModel stu){
        
         DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "update linkedu.Student "
            + "set password = '" + stu.getPassword() + "', "
            + "set email = '" + stu.getEmail() + "', "
            + "set firstname = '" + stu.getFirstName() + "', "
            + "set lastname = '" + stu.getLastName() + "', "
            + "set year =" + stu.getYear() + ", "
            + "set highschool = '" + stu.getHighSchool() + "' ,"
            + "set gpa = " + stu.getGpa() + ", "
            + "set actscore = " + stu.getACT() + ", "
            + "set satscore = " + stu.getSAT() + ", "
            + "set psatscore = " + stu.getPSAT() +", "
            + "set nmsqtscore = " + stu.getNMSQT() + ", "
            + "set apcourse = '" + stu.getApCourse() + "', "
            + "set essay = '" + stu.getEssay() + "', "
            + "set universities = '" + stu.getUniversities() + "', "
            + "set majors = '" + stu.getMajors() + "', "
            + "set ispaidservice = " + stu.getIsPaidService()
            +"where username = '" + stu.getUsername() + "'";
            
            row = stmt.executeUpdate(insertString);
            System.out.println("Insert String: " + insertString);
            DBConn.close();
            
        } catch(SQLException e){
            System.err.println(e.getMessage());
        }
        
        return row;
        
    }
    
    @Override
    public int addStudent(StudentModel stu) {

        DBHelper.loadDriver("org.apache.derby.jdbc.ClientDriver");
        String myDB = "jdbc:derby://localhost:1527/linkedu";
        Connection DBConn = DBHelper.connect2DB(myDB, "itkstu", "student");
        String insertString = "";
        
        int row = 0;
        
        try{
            Statement stmt = DBConn.createStatement();
            insertString = "INSERT INTO linkedu.Student values('"
            + stu.getUsername()
            + "','" + stu.getPassword()
            + "',default"
            + ",'" + stu.getEmail()
            + "','" + stu.getFirstName()
            + "','" + stu.getLastName()
            + "'," + stu.getYear()
            + ",'" + stu.getHighSchool()
            + "'," + stu.getGpa()
            + "," + stu.getACT()
            + "," + stu.getSAT()
            + "," + stu.getPSAT()
            + "," + stu.getNMSQT()
            + ",'" + stu.getApCourse()
            + "','" + stu.getEssay()
            + "','" + stu.getUniversities()
            + "','" + stu.getMajors()
            + "'," + stu.getIsPaidService()
            +", null"
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
