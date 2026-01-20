package com.pdfgeneration.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.pdfgeneration.model.Otpsending;

@Service
public class OtpSendWithMail {

    @Autowired
    private JavaMailSender sender;

    public String generateOtp() {
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000); // 6-digit OTP
        return String.valueOf(otp);
    }

    public void sendEmail(Otpsending email) {
    
    String gn =	generateOtp() ;
    	       
    	    email.setOtp(gn);
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getToEmail());
            message.setSubject(email.getSubject());

            String customMessage = email.getMessage() + "\nYOUR OTP IS: " + email.getOtp();
            message.setText(customMessage);

            sender.send(message);

            System.out.println("OTP sent successfully to " + email.getToEmail());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
