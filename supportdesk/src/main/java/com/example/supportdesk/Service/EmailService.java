package com.example.supportdesk.Service;

import org.springframework.stereotype.Service;

@Service
public class EmailService {
    public void sendResolutionEmail(String toEmail, String issue) {
        // Simulated email sending
        System.out.println("Email sent to " + toEmail + " about issue: " + issue);
    }
}
