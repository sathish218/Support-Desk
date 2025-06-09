package com.example.supportdesk.Service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmailService {

    private static final String RESEND_API_KEY = "re_RxuhQ2xr_HBYsTbZ2RWD2ioJnF9pp8Thp"; // your Resend API key here
    private static final String RESEND_API_URL = "https://api.resend.com/emails";

    private final RestTemplate restTemplate = new RestTemplate();

    public void sendEmail(String to, String subject, String htmlBody) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(RESEND_API_KEY);

        // JSON payload according to Resend API docs
        String payload = String.format("""
            {
                "from": "Support Desk <your_verified_email@domain.com>",
                "to": ["%s"],
                "subject": "%s",
                "html": "%s"
            }
            """, to, subject, htmlBody);

        HttpEntity<String> request = new HttpEntity<>(payload, headers);

        ResponseEntity<String> response = restTemplate.postForEntity(RESEND_API_URL, request, String.class);

        if (!response.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Failed to send email: " + response.getBody());
        }
    }
}
