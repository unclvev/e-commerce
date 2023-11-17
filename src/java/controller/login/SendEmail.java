/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.login;

import java.util.Properties;
import java.util.Random;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import model.Account;

/**
 *
 * @author viet2
 */
public class SendEmail {

    public String getRand() {
        Random rnd = new Random();
        int num = rnd.nextInt(999999);
        return String.format("%06d", num);
    }

    public boolean sendMail(Account a) {
        boolean test = false;
        String toEmail = a.getEmail();
        String fromEmail = "";
        String password = "";

        try {
            Properties pr = new Properties();

            pr.setProperty("mail.smtp.host", "smtp.mail.com");
            pr.setProperty("mail.smtp.host", "587");
            pr.setProperty("mail.smtp.auth", "true");
            pr.setProperty("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(pr, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(fromEmail, password);
                }
            });
            
            Message mess = new MimeMessage(session);
            
            mess.setFrom(new InternetAddress(fromEmail));
            mess.setRecipient(Message.RecipientType.TO,new InternetAddress(toEmail));
            
            mess.setSubject("User email verfication");
            
            mess.setText("Registered sucsessfully. please verify using this code: " + a.getCode());
            
            Transport.send(mess);
            
            test = true;
        
        } catch (Exception e) {
        }

        return test;
    }
}
