/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author chris
 */
public class AppointmentModel {
    private int universityID, studentID;
    private Date visitDate;
    private String username;
    private StudentModel stu;
    
    /**
     * @return the universityID
     */
    public int getUniversityID() {
        return universityID;
    }

    /**
     * @param universityID the universityID to set
     */
    public void setUniversityID(int universityID) {
        this.universityID = universityID;
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the visitDate
     */
    public Date getVisitDate() {
        return visitDate;
    }

    /**
     * @param visitDate the visitDate to set
     */
    public void setVisitDate(Date visitDate) {
        java.util.Date date = visitDate;
        this.visitDate = new Date(date.getTime());
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the stu
     */
    public StudentModel getStu() {
        return stu;
    }

    /**
     * @param stu the stu to set
     */
    public void setStu(StudentModel stu) {
        this.stu = stu;
    }
}
