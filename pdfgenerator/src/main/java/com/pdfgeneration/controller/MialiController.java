package com.pdfgeneration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pdfgeneration.model.Otpsending;
import com.pdfgeneration.service.OtpSendWithMail;

@RestController
@RequestMapping("/otp")
public class MialiController {

    @Autowired
    private OtpSendWithMail otpSendWithMail;

    @PostMapping("/generate")
    public ResponseEntity<String> sendOtpEmail(@RequestBody Otpsending request) {

        try {
            otpSendWithMail.sendEmail(request);
            return ResponseEntity.ok("OTP successfully sent to email");
        } catch (Exception e) {
            return ResponseEntity.internalServerError()
                    .body("Failed to send OTP");
        }
    }
}
