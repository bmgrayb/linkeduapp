/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.RecruiterDAO;
import dao.RecruiterDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.RecruiterModel;
import model.AppUserModel;
import dao.AppUserDAO;
import dao.AppUserDAOImpl;

/**
 *
 * @author chris
 */
@ManagedBean
@SessionScoped
public class RecruiterController {
    private RecruiterModel theModel;
    private String response;

    public RecruiterController(){
        theModel = new RecruiterModel();
    }
    
    /**
     * @return the theModel
     */
    public RecruiterModel getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(RecruiterModel theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        String str = "";
        str += "Hello Student:\nUsername: " + theModel.getUsername();
        str += "\nName: "+theModel.getFirstName() + " " + theModel.getLastName();
        str += "\nUniversity ID: "+theModel.getUniversityID();
        str += "\nEmail: "+theModel.getEmail() + "\nPassword: "+theModel.getPassword();
        str += "\nPaid Service: " + theModel.isIsPaidService();
        response = str;
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String addRecruiter(){
        RecruiterDAO recDAO = new RecruiterDAOImpl();
        int status = recDAO.addRecruiter(theModel);
        AppUserDAO aUserDAO= new AppUserDAOImpl();
        AppUserModel tempModel=new AppUserModel();
        tempModel.setUsername(theModel.getUsername());
        tempModel.setPassword(theModel.getPassword());
        aUserDAO.addUser(tempModel);
        if(status == 1)
            return "dashboard.xhtml";
        return "error.xhtml";
    }
}
