/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.ApplyModel;

/**
 *
 * @author chris
 */
@ManagedBean
@SessionScoped
public class ApplyController {
    private ApplyModel applyModel = new ApplyModel();
    private String subject;
    
    public ApplyController(){
        
    }//end constructor

    /**
     * @return the applyModel
     */
    public ApplyModel getApplyModel() {
        return applyModel;
    }

    /**
     * @param applyModel the applyModel to set
     */
    public void setApplyModel(ApplyModel applyModel) {
        this.applyModel = applyModel;
    }
    
    public void apply(){
        String body = getEmailBody();
        subject = applyModel.getName()+" would like to apply to your University";
        String sender = applyModel.getEmail();
        String reciever = applyModel.getRecruiterEmail();
        
        sendEmail(body,reciever,sender,subject);
    }//end apply
    
    private String getEmailBody(){
        String str;
        
        str = "A new student would like to apply to your University\n\n";
        str += "Applicant Name:    "+applyModel.getName();
        str += "\nHigh School:   "+applyModel.getHighSchool();
        str +="\nSchool Year:    "+applyModel.getYear();
        str +="\nACT Score:      "+applyModel.getActScore();
        str +="\nSAT Score:      "+applyModel.getSatScore();
        str +="\nEmail Address:  "+applyModel.getEmail();
        str +="\nAbout Yourself: "+applyModel.getEssay();
        
        return str;
    }//end email body
    
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
    
    
}
