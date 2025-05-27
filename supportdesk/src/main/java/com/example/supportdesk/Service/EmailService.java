package com.example.supportdesk.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    /**
     * Sends a simple plain text email.
     *
     * @param to Recipient email address
     * @param subject Email subject
     * @param body Email body text
     */
    public void sendEmail(String to, String subject, String body) {
        try {
            // Append the sign-off to the email body
            String fullBody = body + "\n\nBest regards,\nIT-support team";

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(fullBody);
            mailSender.send(message);
            System.out.println("Email sent to " + to);
        }
        catch (Exception e) {
            System.err.println("Error sending email: " + e.getMessage());
            // You can rethrow or handle exceptions as needed
        }
    }
}
