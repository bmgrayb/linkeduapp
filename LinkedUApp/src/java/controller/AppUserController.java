/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import javax.inject.Named;
import model.AppUserModel;
import dao.AppUserDAO;
import dao.AppUserDAOImpl;
/**
 *
 * @author mcpouls
 */
@Named(value = "appUserController")
public class AppUserController 
{
    private String response;
    private AppUserModel theModel;
    public AppUserController()
    {
        theModel=new AppUserModel();
    }

    /**
     * @return the response
     */
    public String getResponse() {
        String str="";
        str+="Hello, your username is " + theModel.getUsername();
        str+="\n Your password is " + theModel.getUsername();
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
    public AppUserModel getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(AppUserModel theModel) {
        this.theModel = theModel;
    }
    
    public String addAppUser()
    {
        int status;
        status=0;
        AppUserDAO temp = new AppUserDAOImpl();
        status=temp.addUser(theModel);
        if(status==1)
            return "dashboard.xhtml";
        else
            return "error.xhtml";
    }
    
}
