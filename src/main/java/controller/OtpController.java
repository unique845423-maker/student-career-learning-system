package com.student.careerlearning.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.careerlearning.service.EmailService;
import com.student.careerlearning.service.OtpService;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin
public class OtpController {

    private final OtpService otpService;
    private final EmailService emailService;

    public OtpController(OtpService otpService, EmailService emailService) {
        this.otpService = otpService;
        this.emailService = emailService;
    }

    // Send OTP
    @PostMapping("/send")
    public String sendOtp(@RequestParam String email) {

        String otp = otpService.generateOtp(email);

        emailService.sendOtp(email, otp);

        return "OTP sent successfully";
    }

    // Verify OTP
    @PostMapping("/verify")
    public String verifyOtp(
            @RequestParam String email,
            @RequestParam String otp) {

        boolean verified = otpService.verifyOtp(email, otp);

        if (verified) {
            return "Email verified successfully";
        }

        return "Invalid or expired OTP";
    }
}