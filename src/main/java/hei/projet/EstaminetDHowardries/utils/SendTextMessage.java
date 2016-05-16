package hei.projet.EstaminetDHowardries.utils;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendTextMessage {

	public void envoyer_email(String Serverstmp,String portStmp, String from, String to, String sujet, String message)
			throws Exception

	{
		try {
			final String username = "estaminet.howardries.resto@gmail.com";
			final String password = "projetestaminet";
	
			java.util.Properties props = new java.util.Properties();
			props.put("mail.smtp.host", "estaminet-howardries.eu");
			props.put("mail.smtp.socketFactory.port", "587");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", 587);
			props.put("mail.imaps.ssl.trust", "*");
			props.put("mail.smtp.ssl.enable", "true");

			Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});

			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
			msg.setSubject(sujet);
			msg.setText(message);
			Transport.send(msg);
		} catch (

		NoSuchProviderException e)

		{
			System.err.println("Pas de transport disponible pour ce protocole");
			System.err.println(e);
		} catch (AddressException e)

		{
			System.err.println("Adresse invalide");
			System.err.println(e);
		} catch (MessagingException e)

		{
			System.err.println("Erreur dans le message");
			System.err.println(e);
		}

	}
}
