package cri.promotion.monitortool.email;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;

public class EmailSender {
	private static Logger logger = Logger.getLogger(cri.promotion.monitortool.email.EmailSender.class);

	private static final String username = "charalotteruse@gmail.com";
	private static final String password = "gspann@123";
	
	public static String sendEmail(File attachedFile) {
		Properties props = new Properties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		logger.info("Email Connection has established.");
		
		try {
			//Creating a Message object to set the email content
            MimeMessage msg = new MimeMessage(session);
            //Storing the comma seperated values to email addresses
            String to = "soni.kapil2067@gmail.com";

            InternetAddress[] address = InternetAddress.parse(to, true);
            //Setting the recepients from the address variable
            msg.setRecipients(Message.RecipientType.TO, address);
            String timeStamp = new SimpleDateFormat("MM/dd/yyyy").format(new Date());
            msg.setSubject("Missing Promotions as of " + timeStamp);
            msg.setSentDate(new Date());
            msg.setHeader("XPriority", "1");
            
            BodyPart msgBodyPart = new MimeBodyPart();  
            msgBodyPart.setText("Please see attached missing promotions report for today.\n Check the active promotions that are not found in the following stores.");  
            
            // creates body part for the attachment
            MimeBodyPart attachPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            attachPart.attachFile(attachedFile);
            multipart.addBodyPart(attachPart);
            multipart.addBodyPart(msgBodyPart);
            msg.setContent(multipart);

            logger.info("Sending email...");
            Transport.send(msg);
		}catch(MessagingException exception) {
			 logger.info("Unable to send an email" + exception);
			 exception.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("Unable to send an email" + e);
		}
		return "Email has been sent succesfully to the end user.";
	}

}
