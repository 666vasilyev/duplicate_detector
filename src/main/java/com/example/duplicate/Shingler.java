package com.example.duplicate;

import java.util.HashSet;
import java.util.Set;

// преобразователь текста в подстроки
public class Shingler {

    public static Set<String> generateShingles(String text, int k) {
        Set<String> shingles = new HashSet<>();
        if (text == null || text.length() < k) {
            return shingles;
        }
        for (int i = 0; i <= text.length() - k; i++) {
            shingles.add(text.substring(i, i + k));
        }
        return shingles;
    }
}
