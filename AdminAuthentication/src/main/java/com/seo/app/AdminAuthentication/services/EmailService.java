//package com.seo.app.UserAuthentication.services;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.SimpleMailMessage;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//import javax.mail.internet.MimeMessage;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class EmailService {
//    private static final Logger log = LoggerFactory.getLogger(EmailService.class);
//
//    @Autowired
//    JavaMailSender javaMailSender;
//
//    @Autowired
//    private SimpleMailMessage simpleMailMessage;
//
//    @Autowired
//    ConnectionService connectionService;
//
//    public String sendPreConfiguredMail(int email_template_id) {
//        SimpleMailMessage mailMessage = new SimpleMailMessage(simpleMailMessage);
//        List<String> subject = new ArrayList<>();
//        List<String> body = new ArrayList<>();
//
//        try {
//            Connection connection = connectionService.createConnection();
//            PreparedStatement statement = connection.prepareStatement("select subject,body from email_templates where email_template_id=" + email_template_id + "");
//            ResultSet rs = statement.executeQuery();
//
//            while (rs.next()) {
//                subject.add(rs.getString("subject"));
//                body.add(rs.getString("body"));
//            }
//
//            if (!(subject.isEmpty()))
//            {
//                mailMessage.setSubject(subject.toString());
//                mailMessage.setText(body.toString());
//                javaMailSender.send(mailMessage);
//                return "Email has been sent successfully.";
//
//            }
//
//        } catch (Exception e) {
//            log.error(e.toString());
//        }
//        return "Failed to send email.";
//
//
//    }
//}
