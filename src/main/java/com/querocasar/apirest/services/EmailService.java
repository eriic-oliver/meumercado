package com.querocasar.apirest.services;

import java.util.Properties;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.querocasar.apirest.models.EmailModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Singleton
public class EmailService {

    public void enviarEmail(EmailModel conteudo) {

        String enderecoFonte = System.getProperty("querocasarservice@gmail.com");
        String ccEmail = "eriic.oliv@gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        props.put("mail.smtp.socketFactory.fallback", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.starttls.required", "true");
        props.put("mail.smtp.ssl.enable", "false");
        props.put("mail.username", "querocasarservice@gmail.com");
        props.put("mail.password", "$&nH@d0@pPq3R0c4S@r...");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication()
                    {
                        return new PasswordAuthentication("querocasarservice@gmail.com",
                                "$&nH@d0@pPq3R0c4S@r...");
                    }
                });
        session.setDebug(true);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("querocasarservice@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(conteudo.getDestino()));
            message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(ccEmail));
            message.setSubject(conteudo.getTitulo());
            message.setText(conteudo.getTexto());

            Transport.send(message);

        } catch (MessagingException e) {
            System.out.println("Falha ao enviar email \n" + e);
        }
    }
}
