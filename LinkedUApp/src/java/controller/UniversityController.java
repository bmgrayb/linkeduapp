/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UniversityDAO;
import dao.UniversityDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.UniversityModel;

/**
 *
 * @author chris
 */
@ManagedBean
@SessionScoped
public class UniversityController {
    private UniversityModel theModel;
    private String response;

    /**
     * @return the theModel
     */
    public UniversityModel getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(UniversityModel theModel) {
        this.theModel = theModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String addUniversity(){
        UniversityDAO uDAO = new UniversityDAOImpl();
        int status = uDAO.addUniversity(theModel);
        if(status == 1)
            return "dashboard.xhtml";
        return "error.xhtml";
    }
}
