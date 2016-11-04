package com.ipn.mx.negocio;
//Envio de correos usando servidor de correo gmail

import java.io.File;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Usuario
 */
public class Correo {
    private static  Properties propiedades;
    
    private int     PORT;
    private String  protocolo;
    private String  MAIL_SERVER_HOST;
    private String  usuario;
    private String  password;
    private boolean autenticacion;
    private boolean initTLSProtocol;
    
    private Session sesion;
    private MimeMessage mensajeToSend;
    private Transport envio;
    
    private String correoDestinatario;
    private String asunto;
    private StringBuilder mensaje;
    
    public Correo() {
        propiedades = new Properties();
    }
    
    public Correo(int PORT, String protocolo, String MAIL_SERVER_HOST, String usuario, String password, boolean autenticacion, boolean initTLSProtocol) {
        this.PORT = PORT;
        this.protocolo = protocolo;
        this.MAIL_SERVER_HOST = MAIL_SERVER_HOST;
        this.usuario = usuario;
        this.password = password;
        this.autenticacion = autenticacion;
        this.initTLSProtocol = initTLSProtocol;
        propiedades = new Properties();
    }

    /**
     * @return the propiedades
     */
    public static Properties getPropiedades() {
        return propiedades;
    }

    /**
     * @param aPropiedades the propiedades to set
     */
    public static void setPropiedades(Properties aPropiedades) {
        propiedades = aPropiedades;
    }

    /**
     * @return the PORT
     */
    public int getPORT() {
        return PORT;
    }

    /**
     * @param PORT the PORT to set
     */
    public void setPORT(int PORT) {
        this.PORT = PORT;
    }

    /**
     * @return the protocolo
     */
    public String getProtocolo() {
        return protocolo;
    }

    /**
     * @param protocolo the protocolo to set
     */
    public void setProtocolo(String protocolo) {
        this.protocolo = protocolo;
    }

    /**
     * @return the MAIL_SERVER_HOST
     */
    public String getMAIL_SERVER_HOST() {
        return MAIL_SERVER_HOST;
    }

    /**
     * @param MAIL_SERVER_HOST the MAIL_SERVER_HOST to set
     */
    public void setMAIL_SERVER_HOST(String MAIL_SERVER_HOST) {
        this.MAIL_SERVER_HOST = MAIL_SERVER_HOST;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the autenticacion
     */
    public boolean isAutenticacion() {
        return autenticacion;
    }

    /**
     * @param autenticacion the autenticacion to set
     */
    public void setAutenticacion(boolean autenticacion) {
        this.autenticacion = autenticacion;
    }

    /**
     * @return the initTLSProtocol
     */
    public boolean isInitTLSProtocol() {
        return initTLSProtocol;
    }

    /**
     * @param initTLSProtocol the initTLSProtocol to set
     */
    public void setInitTLSProtocol(boolean initTLSProtocol) {
        this.initTLSProtocol = initTLSProtocol;
    }

    /**
     * @param correoDestinatario the correoDestinatario to set
     */
    public void setCorreoDestinatario(String correoDestinatario) {
        this.correoDestinatario = correoDestinatario;
    }

    /**
     * @param asunto the asunto to set
     */
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(StringBuilder mensaje) {
        this.mensaje = mensaje;
    }
    
    public void configuracionDatos() {
        getPropiedades().setProperty("mail.smtp.host", getMAIL_SERVER_HOST());
        getPropiedades().setProperty("mail.smtp.starttls.enable", String.valueOf(isInitTLSProtocol()));
        getPropiedades().setProperty("mail.smtp.port", String.valueOf(getPORT()));
        getPropiedades().setProperty("mail.smtp.user", getUsuario());
        getPropiedades().setProperty("mail.smtp.auth", String.valueOf(isAutenticacion()));
    }
    
    public void crearSession() {
        sesion = Session.getDefaultInstance(getPropiedades());
    }
    
    public void armarMensaje(StringBuilder mensaje, String format) throws Exception {
        if (sesion != null) {
            try {
                mensajeToSend = new MimeMessage(sesion);
                mensajeToSend.setFrom(new InternetAddress(usuario));
                mensajeToSend.addRecipient(Message.RecipientType.TO,
                        new InternetAddress(correoDestinatario));
                mensajeToSend.setSubject(asunto);
                switch (format) {
                    case "html":
                        Multipart multipart = new MimeMultipart( "alternative" );
                        MimeBodyPart htmlPart = new MimeBodyPart();
                        htmlPart.setContent( mensaje.toString(), "text/html; charset=utf-8" );
                        multipart.addBodyPart(htmlPart);
                        mensajeToSend.setContent(multipart);
                        break;
                    case "text":
                        mensajeToSend.setText(mensaje.toString());
                        break;
                    default:
                        throw new Exception("Error: debe especificar un formato de envio de texto.");
                }
            } catch (AddressException ex) {
                System.out.println("Ha ocurrido un error al agregar direccion: " + ex.getMessage());
            } catch (MessagingException ex) {
                System.out.println("Ha ocurrido un error al armar el mensaje de envio: " + ex.getMessage());
            }
        } else {
            throw new Exception("Error de sesion");
        }
    }
    
    public void adjuntarArchivo(File archivo) {
        
    }
    
    public void adjuntarArchivo(File[] archivos) {
        
    }
    
    public void enviarMensaje() {
        envio = null;
        try {
            envio = sesion.getTransport(getProtocolo());
            envio.connect(getUsuario(), getPassword());
            envio.sendMessage(mensajeToSend, mensajeToSend.getAllRecipients());
        } catch (NoSuchProviderException ex) {
            System.out.println("Error al configurar protocolo: " + ex.getMessage());
        } catch (MessagingException ex) {
            System.out.println("Error al enviar mensaje: " + ex.getMessage());
        } finally {
            if (envio != null) {
                try {
                    envio.close();
                } catch (MessagingException ex) {
                    System.out.println("Error al cerrar enlace de transporte: " + ex.getMessage());
                }
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        Correo correo = new Correo();
        correo.setProtocolo("smtp");
        correo.setMAIL_SERVER_HOST("smtp.gmail.com");
        correo.setInitTLSProtocol(true);
        correo.setPORT(587);
        correo.setUsuario("correo");
        correo.setAutenticacion(true);
        
        correo.configuracionDatos();
        correo.crearSession();
        
        correo.setAsunto("Proceso de registro de usuario");
        correo.setCorreoDestinatario("correo");
        StringBuilder textoDelCorreo = new StringBuilder();
        textoDelCorreo.append("Su registro fue exitoso.\n").append("Usuario: Hola\n").append("Contrasena: como estas\n");
        correo.armarMensaje(textoDelCorreo, "text");
        correo.enviarMensaje();
    }
}
