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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.mail.FetchProfile.Item;

import model.StudentModel;
import model.UniversityModel;

/**
 *
 * @author chris
 */
@ManagedBean
@SessionScoped
public class SearchController {
    
    private String searchType, state;
    private double gpaHigh, gpaLow;
    private int enrollmentHigh, enrollmentLow, year, gpaIndex, enrollIndex;
    private ArrayList<StudentModel> stu;
    private ArrayList<UniversityModel> univ;
    
    
    public SearchController(){
        //Setting default values
        searchType = "Student";
        state = "none";
        gpaHigh = gpaLow = -1;
        gpaIndex = enrollIndex = -1;
        enrollmentHigh = enrollmentLow = year = -1;
        stu = null;
        univ = null;
    }//end constructor
    
    public void setStu(ArrayList<StudentModel> stu){
        this.stu = stu;
    }
    
    public ArrayList<StudentModel> getStu(){
        return stuSearch();
    }
    
    public void setUniv(ArrayList<UniversityModel> univ){
        this.univ = univ;
    }
    
    public ArrayList<UniversityModel> getUniv(){
        return univSearch();
    }
    
    private ArrayList<StudentModel> stuSearch(){
        ArrayList<StudentModel> temp = null; //new ArrayList<StudentModel>();
        
        if(searchType.equals("Student")){
          StudentDAO stuDAO = new StudentDAOImpl();
          
          if(gpaLow != -1 && year != -1){
              return stuDAO.getStudentGPARangeAndYear(year,gpaLow,gpaHigh);
          }
          else if(gpaLow != -1){
              return stuDAO.getStudentsGPARange(gpaLow,gpaHigh);
          }
          else if(year != -1){
              return stuDAO.getStudentsByYear(year);
          }
          else
              return stuDAO.getAllStudents();
        }//end if type is student
        
        return temp;
    }
    
    private ArrayList<UniversityModel> univSearch(){
        ArrayList<UniversityModel> uList = null; // = new ArrayList<>();
                
       if(searchType.equals("University")){
           UniversityDAO uDAO = new UniversityDAOImpl();
           
           if(enrollmentLow != -1 && !state.equals("none")){
               return uDAO.getUniversitiesByStateAndRange(state,enrollmentLow,enrollmentHigh);
           }
           else if(enrollmentLow != -1){
               return uDAO.getUniversitiesBetween(enrollmentLow,enrollmentHigh);
           }
           else if(!state.equals("none")){
               return uDAO.getUniversitesByState(state);
           }
           else
               return uDAO.getAllUniversities();
        }//end if for is university
        
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

    /**
     * @return the gpaIndex
     */
    public int getGpaIndex() {
        return gpaIndex;
    }

    /**
     * @param gpaIndex the gpaIndex to set
     */
    public void setGpaIndex(int gpaIndex) {
        this.gpaIndex = gpaIndex;
        if(gpaIndex == 1){
            gpaLow = 0.0;
            gpaHigh = 3.0;
        }
        if(gpaIndex == 2){
            gpaLow = 3.0;
            gpaHigh = 3.8;
        }
        if(gpaIndex == 3){
            gpaLow = 3.8;
            gpaHigh = 4.0;
        }
    }

    /**
     * @return the enrollIndex
     */
    public int getEnrollIndex() {
        return enrollIndex;
    }

    /**
     * @param enrollIndex the enrollIndex to set
     */
    public void setEnrollIndex(int enrollIndex) {
        this.enrollIndex = enrollIndex;
        if(enrollIndex == 1){
            enrollmentLow = 0;
            enrollmentHigh = 3000;
        }
        if(enrollIndex == 2){
            enrollmentLow = 3000;
            enrollmentHigh = 30000;
        }
        if(enrollIndex == 3){
            enrollmentLow = 30000;
            enrollmentHigh = 100000;
        }
    }
    
    /*public void setSelectedItem(ValueChangeEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        searchType = context.getApplication().evaluateExpressionGet(context, "#{searchController.searchType}", String.class);
    }*/
    
}
