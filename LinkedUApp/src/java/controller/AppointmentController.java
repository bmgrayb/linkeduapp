/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
//import javax.inject.Named;
import model.AppointmentModel;
import dao.AppointmentDAO;
import dao.AppointmentDAOImpl;
import dao.RecruiterDAO;
import dao.RecruiterDAOImpl;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import dao.UniversityDAOImpl;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Date;
import javax.faces.event.ActionEvent;

/**
 *
 * @author mcpouls
 */
//@Named(value = "appointmentController")
@ManagedBean
@SessionScoped
public class AppointmentController 
{
    private String response;
    private AppointmentModel theModel;
    private Date date;
    public AppointmentController()
    {
        theModel=new AppointmentModel();
    }

    public void setRecruiter(ActionEvent event){
        String un = (String)event.getComponent().getAttributes().get("username");
        theModel.setUniversityID(new RecruiterDAOImpl().getRecruiterByUsername(un).getUniversityID());
        //url = new MultimediaDAOImpl().getURLByID(stu.getStudentID()).getUrl();
    }
    
    /**
     * @return the response
     */
    public String getResponse() {
        String str="";
        str+="Thank you for signing up, your appointment is on ";
        AppointmentDAO apt=new AppointmentDAOImpl();
        StudentDAO std=new StudentDAOImpl();
        RecruiterDAO rec=new RecruiterDAOImpl();
        str+=theModel.getVisitDate();
        str+=".\n The student is ";
        str+=std.getStudentByID(theModel.getStudentID()).getFirstName();
        str+=" ";
        str+=std.getStudentByID(theModel.getStudentID()).getLastName();
        str+=".";
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
    public AppointmentModel getTheModel() {
        return theModel;
    }

    /**
     * @param theModel the theModel to set
     */
    public void setTheModel(AppointmentModel theModel) {
        this.theModel = theModel;
    }
    
    public void addAppointment()
    {
        AppointmentDAO apptDAO= new AppointmentDAOImpl();
        StudentDAO stuDAO = new StudentDAOImpl();
        theModel.setVisitDate(new java.sql.Date(getDate().getTime()));
        theModel.setStudentID(stuDAO.getStudentByUsername(theModel.getUsername()).getStudentID());
        theModel.setUniversityID(100);
        
        int status=apptDAO.addAppointment(theModel);
        /*if(status==1)
            return "dashboard-recruiter.xhtml";
        else
            return "error.xhtml";*/
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }
    
}
