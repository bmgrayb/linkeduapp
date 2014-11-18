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
        this.visitDate = visitDate;
    }
}
