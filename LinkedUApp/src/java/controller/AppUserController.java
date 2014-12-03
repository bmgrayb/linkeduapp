/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
//import javax.inject.Named;
import model.AppUserModel;
import dao.AppUserDAO;
import dao.AppUserDAOImpl;
import dao.StudentDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.RecruiterModel;
import model.StudentModel;
/**
 *
 * @author mcpouls
 */
//@Named(value = "appUserController")
@ManagedBean
@SessionScoped
public class AppUserController 
{
    private String response;
    private AppUserModel theModel;
    private StudentModel stu;
    private RecruiterModel rec;
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
        str+="\n Your password is " + theModel.getPassword();
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
    
    private boolean checkLoggedIn()
    {
        if(theModel.getUsername()!=null && theModel.getUsername().length()>0)
        {return true;}
        else
        {return false;}
    }
    
    public String login()
    {
        AppUserDAO apd = new AppUserDAOImpl();   
        theModel = apd.getUserByUsername(theModel.getUsername());
        if(validate())
        {
            //AppUserDAO apd=new AppUserDAOImpl();
            //if(apd.getUserType(theModel.getUsername()).equals("student"))
            stu = new StudentDAOImpl().getStudentByUsername(theModel.getUsername());
            if(theModel.getUserType().equalsIgnoreCase("Student"))
            {return "dashboard.xhtml";}
            else
            {return "dashboard-recruiter.xhtml";}
            //return "dashboard.xhtml";
        }
        else
        {
            return "error.xhtml";
        }
    }
    
    public boolean validate()
    {
        AppUserDAO apd = new AppUserDAOImpl();
        //if(checkLoggedIn())
        if(apd.validate(theModel.getUsername(), theModel.getPassword()))
        {
            /*if(apd.validate(theModel.getUsername(), theModel.getPassword()))
            {return true;}
            else
            {return false;}*/
            return true;
        }
        else
        {
            return true;
        }
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
