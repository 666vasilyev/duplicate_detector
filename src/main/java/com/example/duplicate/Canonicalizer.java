package com.example.duplicate;

import java.text.Normalizer;
import java.util.Locale;

// канонизатор
public class Canonicalizer {

    /**
     * Канонизирует текст: удаляет лишние символы, приводит текст к нижнему регистру,
     * упрощает пробелы и нормализует Unicode.
     *
     * @param text Исходный текст
     * @return Канонизированный текст
     */
    public static String canonicalize(String text) {
        if (text == null || text.isEmpty()) {
            return "";
        }

        // Шаг 1: Нормализация Unicode
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD)
                                       .replaceAll("\\p{M}", ""); // Убираем диакритические знаки

        // Шаг 2: Приведение к нижнему регистру и удаление лишних символов
        String cleaned = normalized.toLowerCase(Locale.ROOT)
                                    .replaceAll("[^a-zа-я0-9\\s]", "") // Убираем неалфавитные символы
                                    .replaceAll("\\s+", " ")           // Упрощаем пробелы
                                    .trim();                           // Убираем лишние пробелы по краям

        return cleaned;
    }
}