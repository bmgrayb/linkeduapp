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
import dao.AppointmentDAO;
import dao.AppointmentDAOImpl;
import dao.StudentDAO;
import dao.StudentDAOImpl;
import dao.UniversityDAO;
import dao.UniversityDAOImpl;
import java.sql.Date;
import java.util.Properties;
import model.AppointmentModel;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.StudentModel;
import model.UniversityModel;

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
        str += "Hello Recruiter:\nUsername: " + theModel.getUsername();
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
            return "dashboard-recruiter.xhtml";
        return "error.xhtml";
    }
    
    public String update(){
        RecruiterDAO recDAO = new RecruiterDAOImpl();
        int status = recDAO.updateRecruiter(theModel);
        if(status == 1)
            return "dashboard-recruiter.xhtml";
        return "error.xhtml";
    }
    

    public void requestInfoFromStudent(int stuID){
        StudentModel student; RecruiterModel rec;
        StudentDAO stuDAO = new StudentDAOImpl();
        student = stuDAO.getStudentByID(stuID);
        String stuEmail = student.getEmail();
        rec = this.getTheModel();
        String recEmail = rec.getEmail();
        UniversityDAO uDAO = new UniversityDAOImpl();
        String recUniversity = uDAO.getUniversityByID(rec.getUniversityID()).getOfficalName();
        
        String mailStr = "Hello "+student.getFirstName()+" "+student.getLastName()+",\n\n";
        mailStr += "I am "+rec.getFirstName()+" "+rec.getLastName()+" from " + recUniversity+".\n";
        mailStr += "We would like to talk to you about to learn more about you.\n\n";
        mailStr += "Thanks,\n"+"   "+rec.getFirstName()+" "+rec.getLastName()+"\n";
        mailStr += "   "+recUniversity;
        
        String subject = student.getFirstName()+"! We would like to know more about you!";
        
        sendEmail(mailStr,stuEmail,recEmail,subject);
        
    }//end requestFromStudent

    
    public void makeAppoinment(Date date, int stuId){
        
        AppointmentModel appt = new AppointmentModel();
        appt.setStudentID(stuId);
        appt.setVisitDate(date);
        appt.setUniversityID(this.getTheModel().getUniversityID());
        
        AppointmentDAO apptDao = new AppointmentDAOImpl();
        StudentDAO stuDAO = new StudentDAOImpl();
        UniversityDAO univDAO = new UniversityDAOImpl();
        int status = apptDao.addAppointment(appt);
        String message = "";
        
        if(status == 1){
            StudentModel stu = stuDAO.getStudentByID(stuId);
            UniversityModel univ = univDAO.getUniversityByID(this.getTheModel().getUniversityID());
            message+="Thank you " + stu.getFirstName() + " " + stu.getLastName() + " for setting up an appointment!";
            message+=" It is on " + appt.getVisitDate() + " with " + univ.getOfficalName() + ".";
            
            sendEmail(message, stu.getEmail(), univ.getEmail(), "Appointment Scheduled");
        }
    }
    
    private void sendEmail(String text, String toEmail, String fromEmail, String subject){        
         // Recipient's email ID needs to be mentioned.
        String to = toEmail;
        
        // Sender's email ID needs to be mentioned
        String from = fromEmail;

        // Assuming you are sending email from this host
        String host = "smtp.ilstu.edu";

        // Get system properties
        Properties properties = System.getProperties();

        // Setup mail server
        properties.setProperty("mail.smtp.host", host);
        properties.setProperty("mail.user", "yourID"); // if needed
        properties.setProperty("mail.password", "yourPassword"); // if needed

        // Get the default Session object.
        Session session = Session.getDefaultInstance(properties);

        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(to));

            // Set Subject: header field
            message.setSubject(subject);

            // Send the actual HTML message, as big as you like
            message.setContent(text,
                    "text/html");

            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
        
    }
    
    public String getUni(){
        UniversityDAO uDAO = new UniversityDAOImpl();
        UniversityModel uMod = uDAO.getUniversityByID(theModel.getUniversityID());
        return uMod.getOfficalName();
    }

}
