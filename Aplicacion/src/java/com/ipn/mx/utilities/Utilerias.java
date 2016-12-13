package com.ipn.mx.utilities;

import java.util.Properties;

import javax.mail.Session;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Usuario
 */
public class Utilerias {
    private String error;
    private final Properties p;
    private Session sesion;
        
    public Utilerias () {
        p = new Properties();
        error = "";
    }
    
    public void init() {
        //Configuracion de servidor de correos
        p.setProperty("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.setProperty("mail.smtp.port", "587"); 
        p.setProperty("mail.smtp.mail.sender", "webappdevelopment3CV4@gmail.com");
        p.setProperty("mail.smtp.user", "webappdevelopment3CV4@gmail.com");
        p.setProperty("mail.smtp.auth", "true");
        //Creacion de la sesion de usuario
        sesion = Session.getDefaultInstance(p);
    }
 
    public boolean enviarMail (String correoDestinatario, String asunto, String textoDelCorreo) {
        try {
            //Creacion del cuerpo de correo
            MimeMessage m = new MimeMessage(sesion);
            Multipart multipart = new MimeMultipart( "alternative" );
            m.setFrom(new InternetAddress((String)p.getProperty("mail.smtp.user")));
            m.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(correoDestinatario));
            m.setSubject(asunto);
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent( textoDelCorreo, "text/html; charset=utf-8" );
            multipart.addBodyPart(htmlPart);
            m.setContent(multipart);
            //Proceso de envio de correo y cierre
            Transport t = sesion.getTransport("smtp");
            t.connect((String)p.getProperty("mail.smtp.user"), "EsWeb@Developer");
            t.sendMessage(m, m.getAllRecipients());
            t.close();
        } catch (Exception e) {
            error = e.toString();
            return false;
        }
        return true;
    }
    
    public String getError () { return error; }
    
    public static void main(String[] args) {
        Utilerias utils = new Utilerias();
        utils.init();
        String correoDestinatario = "rafaellanda.landa4@gmail.com";
        String asunto = "Proceso de registro de usuario";
        String textoDelCorreo = "Su registro fue exitoso.\n" +
                "Usuario: Hola\n" +
                "Contrasena: como estas\n";
        //envio de mensaje
        if ( !utils.enviarMail(correoDestinatario, asunto, textoDelCorreo) ) {
            System.out.println("Error al envio de mensaje email: \n" + utils.getError());
        } else {
            System.out.println("<br><b>¡¡Usuario registrado!!</b>");
        }
    }
}
