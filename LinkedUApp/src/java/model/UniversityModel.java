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
public class UniversityModel {
    private String username, password, officalName, availability;
    private String address, city, stAbbr, zip, email;
    private boolean isFeatured;
    private int universityID, enrollment;

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
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the officalName
     */
    public String getOfficalName() {
        return officalName;
    }

    /**
     * @param officalName the officalName to set
     */
    public void setOfficalName(String officalName) {
        this.officalName = officalName;
    }

    /**
     * @return the availability
     */
    public String getAvailability() {
        return availability;
    }

    /**
     * @param availability the availability to set
     */
    public void setAvailability(String availability) {
        this.availability = availability;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the stAbbr
     */
    public String getStAbbr() {
        return stAbbr;
    }

    /**
     * @param stAbbr the stAbbr to set
     */
    public void setStAbbr(String stAbbr) {
        this.stAbbr = stAbbr;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
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
     * @return the isFeatured
     */
    public boolean isIsFeatured() {
        return isFeatured;
    }

    /**
     * @param isFeatured the isFeatured to set
     */
    public void setIsFeatured(boolean isFeatured) {
        this.isFeatured = isFeatured;
    }

    /**
     * @return the universityID
     */
    public int getUniversityID() {
        return universityID;
    }

    /**
     * @param universityID the universityID to set
     */
    /*
    public void setUniversityID(int universityID) {
        this.universityID = universityID;
    } */

    /**
     * @return the enrollment
     */
    public int getEnrollment() {
        return enrollment;
    }

    /**
     * @param enrollment the enrollment to set
     */
    public void setEnrollment(int enrollment) {
        this.enrollment = enrollment;
    }
}
