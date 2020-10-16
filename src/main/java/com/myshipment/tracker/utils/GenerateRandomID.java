package com.myshipment.tracker.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * @Author: Austin Oyugi
 * @Date: 18/05/2020
 * @Email: austinoyugi@gmail.com
 */

@Component
public class GenerateRandomID {
    public static String getRandomId() {
        SecureRandom secureRandom = new SecureRandom();
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder generatedString = new StringBuilder();
        for (int i = 0; i < 25; i++) {
            int randomSequence = secureRandom.nextInt(CHARACTERS.length());
            generatedString.append(CHARACTERS.charAt(randomSequence));
        }
        return generatedString.toString();
    }
}