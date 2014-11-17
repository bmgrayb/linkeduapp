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
public class MultimediaModel {
    private int mixtapeID, studentID;
    private String url;
    private float rating;

    /**
     * @return the mixtapeID
     */
    public int getMixtapeID() {
        return mixtapeID;
    }

    /**
     * @param mixtapeID the mixtapeID to set
     */
    public void setMixtapeID(int mixtapeID) {
        this.mixtapeID = mixtapeID;
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
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(float rating) {
        this.rating = rating;
    }
}
