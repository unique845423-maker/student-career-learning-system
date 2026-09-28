package com.student.careerlearning.service;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
public class OtpService {

    private final Map<String, OtpData> otpStore = new ConcurrentHashMap<>();

    private static final int OTP_VALIDITY_MINUTES = 5;

    public String generateOtp(String email) {

        String otp = String.format(
                "%06d",
                ThreadLocalRandom.current().nextInt(0, 1_000_000)
        );

        LocalDateTime expiryTime =
                LocalDateTime.now().plusMinutes(OTP_VALIDITY_MINUTES);

        otpStore.put(
                email.toLowerCase(),
                new OtpData(otp, expiryTime)
        );

        return otp;
    }

    public boolean verifyOtp(String email, String enteredOtp) {

        String key = email.toLowerCase();

        OtpData otpData = otpStore.get(key);

        if (otpData == null) {
            return false;
        }

        if (LocalDateTime.now().isAfter(otpData.expiryTime)) {
            otpStore.remove(key);
            return false;
        }

        if (otpData.otp.equals(enteredOtp)) {
            otpStore.remove(key);
            return true;
        }

        return false;
    }

    private static class OtpData {

        private final String otp;
        private final LocalDateTime expiryTime;

        public OtpData(String otp, LocalDateTime expiryTime) {
            this.otp = otp;
            this.expiryTime = expiryTime;
        }
    }
}