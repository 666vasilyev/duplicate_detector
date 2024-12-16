package com.example.duplicate;

import java.text.Normalizer;
import java.util.Locale;

public class Canonicalizer {

    public static String canonicalize(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }
        // Нормализация и преобразование в нижний регистр
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD)
                                       .replaceAll("\\p{M}", ""); // Убираем диакритику
        return normalized.toLowerCase(Locale.ROOT)
                         .replaceAll("[^a-zA-Z0-9\\s]", "") // Убираем лишние символы
                         .replaceAll("\\s+", " ")           // Упрощаем пробелы
                         .trim();
    }
}