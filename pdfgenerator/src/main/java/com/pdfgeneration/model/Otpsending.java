package com.pdfgeneration.model;

public class Otpsending {

    private String toEmail;
    private String subject;
    private String message;
    private String otp;

    public Otpsending() {}

    public Otpsending(String toEmail, String subject, String message, String otp) {
        this.toEmail = toEmail;
        this.subject = subject;
        this.message = message;
        this.otp = otp;
    }

    public String getToEmail() {
        return toEmail;
    }

    public void setToEmail(String toEmail) {
        this.toEmail = toEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}
