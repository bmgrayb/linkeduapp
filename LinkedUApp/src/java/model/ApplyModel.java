/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author chris
 */
public class ApplyModel {
    private String name,highSchool,year,actScore,satScore,email,recruiterEmail,essay;
    
    public ApplyModel(){
        name=highSchool=year=actScore=satScore=email=recruiterEmail=essay="";
    }//end constructor

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the highSchool
     */
    public String getHighSchool() {
        return highSchool;
    }

    /**
     * @param highSchool the highSchool to set
     */
    public void setHighSchool(String highSchool) {
        this.highSchool = highSchool;
    }

    /**
     * @return the year
     */
    public String getYear() {
        return year;
    }

    /**
     * @param year the year to set
     */
    public void setYear(String year) {
        this.year = year;
    }

    /**
     * @return the actScore
     */
    public String getActScore() {
        return actScore;
    }

    /**
     * @param actScore the actScore to set
     */
    public void setActScore(String actScore) {
        this.actScore = actScore;
    }

    /**
     * @return the satScore
     */
    public String getSatScore() {
        return satScore;
    }

    /**
     * @param satScore the satScore to set
     */
    public void setSatScore(String satScore) {
        this.satScore = satScore;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the recruiterEmail
     */
    public String getRecruiterEmail() {
        return recruiterEmail;
    }

    /**
     * @param recruiterEmail the recruiterEmail to set
     */
    public void setRecruiterEmail(String recruiterEmail) {
        this.recruiterEmail = recruiterEmail;
    }

    /**
     * @return the essay
     */
    public String getEssay() {
        return essay;
    }

    /**
     * @param essay the essay to set
     */
    public void setEssay(String essay) {
        this.essay = essay;
    }
}
