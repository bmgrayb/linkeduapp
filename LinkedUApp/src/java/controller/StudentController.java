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
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
        
        sendEmail(mailStr,rec.getEmail(),stu.getEmail(),subject);
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
        
    }//end send mail
}//end class
