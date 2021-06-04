package be.heh.app.utils;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.java.Log;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

// Lombok
@FieldDefaults(level = AccessLevel.PRIVATE)
@Log
public class SendEmail implements Runnable {

    Session session;
    final String serviceUsername = "ypcdonotreply@gmail.com";
    final String servicePassword = "s56f4dsd5f";
    final String url = "http://localhost:4200/";
    final HashMap<String, String> styleHmap = new HashMap<String, String>();

    EnumEmail enumEmail;
    String to;
    String username;
    String token;

    public SendEmail(EnumEmail enumEmail, String to, String username, String token) {
        this.init();
        this.enumEmail = enumEmail;
        this.to = to;
        this.username = username;
        this.token = token;
        Thread t = new Thread(this);
        t.start();
    }

    private void init() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //TLS

        session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(serviceUsername, servicePassword);
                    }
                });
        //log.info("Gmail connected");

        styleHmap.put("h3", "font-size:24px;letter-spacing:3px;padding-bottom:10px;text-align:center;color:#000;font-weight:400");
        styleHmap.put("h4", "letter-spacing:3px;font-size:20px;text-align:center;color:#000;font-weight:400");
        styleHmap.put("h2", "letter-spacing:2px;padding-bottom:10px;font-size:18px;text-align:center;color:#000;font-weight:400");
        styleHmap.put("footer", "text-align:center;line-height:150%;padding-top:25px;font-size:12px");
        styleHmap.put("container", "font-size:14px;margin:auto;text-align:center");
        styleHmap.put("meg", "margin:auto;max-width:680px;padding:35px 15px 10px;background-color:#fff");
        styleHmap.put("li", "display:inline-block;font-size:40px;padding:15px 30px;margin:10px;border:2px solid grey");
        styleHmap.put("ul", "padding-right:15px");
        styleHmap.put("warning", "color:#de0012!important;");
        styleHmap.put("button", "background-color:#28a5df;border:.1rem solid #28a5df;cursor:pointer;display:inline-block;color:#fff;padding:10px 50px;margin:10px 0;text-align:center;text-transform:uppercase;letter-spacing:1.5px;font-size:12px");
        styleHmap.put("a", "color:#28a5df");
        styleHmap.put("rescue_link", "color:#bcbcbc;font-size:14px");
        styleHmap.put("display", "background:rgba(0,0,0,.1);padding:10px 16px;text-align:left!important");
    }

    @Override
    public void run() {

        String body = "";

        switch (this.enumEmail) {
            case ACCOUNT_CONFIRMATION:
                body = this.accountConfirmation();
                break;
            case AUTH_CODE:
                body = this.authCode();
                break;
            case DELETE_CONFIRMATION:
                body = this.deleteConfirmation();
                break;
            case RESET_PASSWORD:
                body = this.resetPasswordConfirmation();
                break;
        }

        body = "<div class=\"meg\">" +
                "<div>" +
                "<div style=\"width:100%;border-bottom:1px solid #bcbcbc\">" +
                "<h3 class=\"h3\">Naturopath</h3>" +
                "</div>" +
                "<h4 class=\"h4\">Hi " + this.username + "!</h4><h2 class=\"h2\">" + this.enumEmail.subject + "</h2>" +
                "</div>" +
                "<div class=\"container\">" + body + "</div>" +
                "<div>" +
                "<p style=\"text-align:right;font-size:14px;padding-top:15px\">Sincerely, The Naturopath Team</p>" +
                "</div>" +
                "<div class=\"footer\">" +
                "<p>If you don't have a YPC account, delete this email immediately and contact our <a class=\"a\" href=\"" + this.url + "/contact\">customer service</a>" +
                "<i>DATE Naturopath</i>" +
                "</div>" +
                "</div>";

        for (Map.Entry<String, String> pair : styleHmap.entrySet()) {
            body = body.replace("class=\"" + pair.getKey() + "\"", "style=\"" + pair.getValue() + "\"");
        }

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.to));
            message.setSubject(this.enumEmail.subject);
            message.setContent(body, "text/html");

            Transport.send(message);
            //System.out.println("message sent successfully");
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private String link(String link, String buttonName) {
        String fullLink = this.url + link + this.token;
        return "<form action=\"" + fullLink + "\"><button class=\"button\" type=\"submit\">" + buttonName + "</button></form>" +
            "<p class=\"rescue_link\">Or copy this link: <a class=\"rescus_link\">" + fullLink + "</a></p>";
    }

    private String accountConfirmation() {
        return "<div class=\"container\"><p>For security reasons, you must confirm your email address before you continue. Thank you for your patience.</p><p>If you do not confirm your email address within 48 hours, your account will automatically be deleted.</p>" +
                this.link("confirm/", "Confirm Email") +
                "</div>";
    }

    private String deleteConfirmation() {
        return "<div class=\"container\"><p>For security reasons, please confirm that you want to delete your account.</p>" +
                this.link("delete/", "Confirm Deletion") +
                "</div>";
    }

    private String resetPasswordConfirmation() {
        return "<div class=\"container\"><p>For security reasons, you must change you password.</p>" +
                "<p>Do not reuse your passwords. Make sure your password does not sound right. Do it with uppercase letters, lowercase letters, numbers, special characters. Make sure is more than 12 characters.</p>" +
                this.link("reset/", "Update Password") +
                "</div>";
    }

    private String authCode() {
        return "<div class=\"container\"><h4 class=\"h4\">" + this.token + "</h4></div>";
    }

}
