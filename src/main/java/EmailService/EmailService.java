package com.student.careerlearning.service;

import java.util.Random;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));
    }

    public void sendOtp(String email, String otp) {

        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(email);
        message.setSubject("Student Career & Learning - Email Verification");

        message.setText(
                "Hello,\n\n"
                + "Your OTP for email verification is: " + otp + "\n\n"
                + "This OTP is valid for a limited time.\n"
                + "Please do not share this OTP with anyone.\n\n"
                + "Student Career & Learning Management System"
        );

        mailSender.send(message);
    }
}