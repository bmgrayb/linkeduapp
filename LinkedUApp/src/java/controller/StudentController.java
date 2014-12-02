/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.StudentModel;
import model.AppUserModel;
import dao.AppUserDAO;
import dao.AppUserDAOImpl;
import dao.RecruiterDAO;
import dao.RecruiterDAOImpl;
import dao.UniversityDAO;
import dao.UniversityDAOImpl;
import model.RecruiterModel;

/**
 *
 * @author chris
 */
@ManagedBean
@SessionScoped
public class StudentController {
    private StudentModel theUserModel;
    private String response;
    
    public StudentController(){
        theUserModel = new StudentModel();
    }

    /**
     * @return the theUserModel
     */
    public StudentModel getTheUserModel() {
        return theUserModel;
    }

    /**
     * @param theUserModel the theUserModel to set
     */
    public void setTheUserModel(StudentModel theUserModel) {
        this.theUserModel = theUserModel;
    }

    /**
     * @return the response
     */
    public String getResponse() {
        String str = "";
        str += "Hello Student:\nUsername: " + theUserModel.getUsername();
        str += "\nName: "+theUserModel.getFirstName() + " " + theUserModel.getLastName();
        str += "\nEmail: "+theUserModel.getEmail() + "\nPassword: "+theUserModel.getPassword();
        str += "\nPaid Service: " + theUserModel.getIsPaidService();
        response = str;
        return response;
    }

    /**
     * @param response the response to set
     */
    public void setResponse(String response) {
        this.response = response;
    }
    
    public String addStudent(){
        StudentDAO aStudentDAO = new StudentDAOImpl();
        int status = aStudentDAO.addStudent(theUserModel);
        AppUserDAO aUserDAO= new AppUserDAOImpl();
        AppUserModel tempModel=new AppUserModel();
        tempModel.setUsername(theUserModel.getUsername());
        tempModel.setPassword(theUserModel.getPassword());
        tempModel.setUserType("student");
        aUserDAO.addUser(tempModel);
        if (status == 1)
            return "dashboard.xhtml";
        else return "error.xhml";
    }//end create Student
    
    
    public void requestInfoFromRecruiter(int recID){
        StudentModel stu = this.getTheUserModel();
        RecruiterDAO recDAO = new RecruiterDAOImpl();
        RecruiterModel rec = recDAO.getRecruiterByID(recID);
        UniversityDAO uDAO = new UniversityDAOImpl();
        String uniName = uDAO.getUniversityByID(rec.getUniversityID()).getOfficalName();
        
        
        String mailStr = "Hello "+rec.getFirstName()+" "+rec.getLastName()+",\n\n";
        mailStr += "My name is "+stu.getFirstName()+" "+stu.getLastName()+" and I am interested ";
        mailStr += "in getting more information about "+uniName+".\n\n";
        mailStr += "Thanks,\n"+"   "+stu.getFirstName()+" "+stu.getLastName();
        
        String subject = "I would like to know more about your university.";
        
       // sendEmail(mailStr,stu.getEmail(),rec.getEmail(),subject);
    }

}//end class
