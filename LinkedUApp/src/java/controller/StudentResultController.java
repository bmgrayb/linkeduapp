/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.MultimediaDAOImpl;
import dao.StudentDAOImpl;
import dao.UniversityDAOImpl;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import model.MultimediaModel;
import model.StudentModel;
import model.UniversityModel;

/**
 *
 * @author brando
 */
@ManagedBean
@SessionScoped
public class StudentResultController {

    private int stuID = -1;
    private String un;
    private StudentModel stu;
    private MultimediaModel mm;
    private String url;
    private UniversityModel featured;
    private ArrayList<UniversityModel> all;
    private int index;
    
    /**
     * Creates a new instance of StudentResult
     */
    public StudentResultController() {
        stu = null; //new StudentDAOImpl().getStudentByUsername(un);//new StudentDAOImpl().getStudentByID(stuID);
        mm = new MultimediaModel();
        all = new UniversityDAOImpl().getShowcasedUniversities();
        url = null;
        index = 0;
    }

    public void setID(ActionEvent event){
        un = (String)event.getComponent().getAttributes().get("username");
        stu = new StudentDAOImpl().getStudentByUsername(un);
        url = new MultimediaDAOImpl().getURLByID(stu.getStudentID()).getUrl();
    }
    
    /**
     * @return the stuID
     */
    public int getStuID() {
        return stuID;
    }

    /**
     * @param stuID the stuID to set
     */
    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

    /**
     * @return the stu
     */
    public StudentModel getStu() {
        return new StudentDAOImpl().getStudentByUsername(un);
    }

    /**
     * @param stu the stu to set
     */
    public void setStu(StudentModel stu) {
        this.stu = stu;
    }

    /**
     * @return the un
     */
    public String getUn() {
        return un;
    }

    /**
     * @param un the un to set
     */
    public void setUn(String un) {
        this.un = un;
    }

    /**
     * @return the mm
     */
    public MultimediaModel getMm() {
        if(mm == null){
            mm = new MultimediaDAOImpl().getURLByID(stuID);
        }
        return mm;
    }

    /**
     * @param mm the mm to set
     */
    public void setMm(MultimediaModel mm) {
        this.mm = mm;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        if(url == null){
            url = new MultimediaDAOImpl().getURLByID(stuID).getUrl();
        }
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the featured
     */
    public UniversityModel getFeatured() {
        return all.get(index);
    }

    /**
     * @param featured the featured to set
     */
    public void setFeatured(UniversityModel featured) {
        this.featured = featured;
    }

    /**
     * @return the all
     */
    public ArrayList<UniversityModel> getAll() {
        return all;
    }

    /**
     * @param all the all to set
     */
    public void setAll(ArrayList<UniversityModel> all) {
        this.all = all;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }
    
    public void changeFeatured(){
        index = (index+1)%all.size();
    }
    
}
