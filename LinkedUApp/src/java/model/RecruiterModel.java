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
public class RecruiterModel {
    private String username, password, firstName, lastName, email;
    private int recruiterID, universityID;
    private boolean isPaidService;

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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
     * @return the recruiterID
     */
    public int getRecruiterID() {
        return recruiterID;
    }

    /**
     * @param recruiterID the recruiterID to set
     */ /*
    public void setRecruiterID(int recruiterID) {
        this.recruiterID = recruiterID;
    }
*/
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
     * @return the isPaidService
     */
    public boolean isIsPaidService() {
        return isPaidService;
    }

    /**
     * @param isPaidService the isPaidService to set
     */
    public void setIsPaidService(boolean isPaidService) {
        this.isPaidService = isPaidService;
    }
}
