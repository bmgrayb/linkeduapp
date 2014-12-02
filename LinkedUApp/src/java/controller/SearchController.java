/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import dao.UniversityDAO;
import dao.UniversityDAOImpl;
import java.util.ArrayList;
import model.StudentModel;
import model.UniversityModel;

/**
 *
 * @author chris
 */
public class SearchController {
    
    private String searchType, state;
    private double gpaHigh, gpaLow;
    private int enrollmentHigh, enrollmentLow, year;
    
    
    public SearchController(){
        //Setting default values
        searchType = state = null;
        gpaHigh = gpaLow = -1;
        enrollmentHigh = enrollmentLow = year = -1;
    }//end constructor
    
    public ArrayList<?> search(){
        ArrayList<StudentModel> stuList;
        ArrayList<UniversityModel> uList = new ArrayList<>();
        
        if(searchType.equals("University")){
           UniversityDAO uDAO = new UniversityDAOImpl();
           
           if(enrollmentLow != -1 && state != null){
             //  return uDAO.getUniversitiesByStateAndRange(state,enrollmentLow,enrollmentHigh);
           }
           else if(enrollmentLow != -1){
            //   return uDAO.getUniversitiesBetween(enrollmentLow,enrollmentHigh);
           }
           else if(state != null){
               return uDAO.getUniversitesByState(state);
           }
           else
               return uDAO.getAllUniversities();
        }//end if for is university
        
        if(searchType.equals("Student")){
          StudentDAO stuDAO = new StudentDAOImpl();
          
          if(gpaLow != -1 && year != -1){
            //  return stuDAO.getStudentGPARangeAndYear(year,gpaLow,gpaHigh);
          }
          else if(gpaLow != -1){
            //  return stuDAO.getStudentsGPARange(gpaLow,gpaHigh);
          }
          else if(year != -1){
              return stuDAO.getStudentsByYear(year);
          }
          else
              return stuDAO.getAllStudents();
        }//end if type is student
        
        //will never reach this return statement
        //needed to satisfy java compiler
        return uList;
    }//end search

    /**
     * @return the searchType
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * @param searchType the searchType to set
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the gpaHigh
     */
    public double getGpaHigh() {
        return gpaHigh;
    }

    /**
     * @param gpaHigh the gpaHigh to set
     */
    public void setGpaHigh(double gpaHigh) {
        this.gpaHigh = gpaHigh;
    }

    /**
     * @return the gpaLow
     */
    public double getGpaLow() {
        return gpaLow;
    }

    /**
     * @param gpaLow the gpaLow to set
     */
    public void setGpaLow(double gpaLow) {
        this.gpaLow = gpaLow;
    }

    /**
     * @return the enrollmentHigh
     */
    public int getEnrollmentHigh() {
        return enrollmentHigh;
    }

    /**
     * @param enrollmentHigh the enrollmentHigh to set
     */
    public void setEnrollmentHigh(int enrollmentHigh) {
        this.enrollmentHigh = enrollmentHigh;
    }

    /**
     * @return the enrollmentLow
     */
    public int getEnrollmentLow() {
        return enrollmentLow;
    }

    /**
     * @param enrollmentLow the enrollmentLow to set
     */
    public void setEnrollmentLow(int enrollmentLow) {
        this.enrollmentLow = enrollmentLow;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
}
