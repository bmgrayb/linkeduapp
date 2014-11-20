/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import dao.MultimediaDAO;
import dao.MultimediaDAOImpl;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.inject.Named;
import model.MultimediaModel;

/**
 *
 * @author mcpouls
 */
//@Named(value = "multimediaController")
@ManagedBean
@SessionScoped
public class MultimediaController 
{
    private String response;
    private MultimediaModel theModel;
    public MultimediaController()
    {
        theModel=new MultimediaModel();
    }

    /**
     * @return the response
     */
    public String getResponse() {
        String str="";
        str+="Thank you for uploading media ";
        StudentDAO std=new StudentDAOImpl();
        str+=std.getStudentByID(theModel.getStudentID()).getFirstName();
        str+=" ";
        str+=std.getStudentByID(theModel.getStudentID()).getLastName();
        response=str;
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }

    /**
     * @return the theModel
     */
    public MultimediaModel getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(MultimediaModel theModel) {
        this.theModel = theModel;
    }
    
    
    
    public String addMedia()
    {
        int update;
        MultimediaDAO mm=new MultimediaDAOImpl();
        update=mm.addMultimedia(theModel);
        if(update==1)
            return "dashboard.xhtml";
        else
            return "error.xhtml";
    }
    
}
