package com.karma.workhistory.service.util;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.karma.workhistory.model.User;

public class SendEmail {
    
    Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;

	public void sendEmailFunction(User candidate) throws AddressException,
			MessagingException {

		SendEmail SendEmail = new SendEmail();

		SendEmail.setMailServerProperties();
		SendEmail.createEmailMessage(candidate);
		SendEmail.sendEmail();
	}

	public void setMailServerProperties() {

		String emailPort = "587";//gmail's smtp port

		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
		

	}

	public void createEmailMessage(User candidate) throws AddressException,
			MessagingException {
	    	
	    	//User candidate = new User();
		//String[] toEmails = { "indianvicky91@gmail.com" };
		String emailSubject = "Hey There, Your account has been created with Karma";
		String emailBody = "\nThe details are: \n User Name: "+candidate.getEmailId()+"\nPassword: "+candidate.getPassword()+"\n";

		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);

		//for (int i = 0; i < toEmails.length; i++) {
		System.out.println(" email id of entered candidate.getEmailId() "+candidate.getEmailId());
		/* System.out.println(" email id of entered addressee addressee "+candidate.getEmailId());*/
		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(candidate.getEmailId()));
		//}

		emailMessage.setSubject(emailSubject);
		emailMessage.setContent(emailBody, "text/html");//for a html email
		//emailMessage.setText(emailBody);// for a text email

	}

	public void sendEmail() throws AddressException, MessagingException {

		String emailHost = "smtp.gmail.com";
		String fromUser = "kkollak91";//just the id alone without @gmail.com
		String fromUserEmailPassword = "smtpmail";

		Transport transport = mailSession.getTransport("smtp");

		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}

}
