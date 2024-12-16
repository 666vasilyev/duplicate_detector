package com.example.duplicate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// поиск дубликатов
public class DuplicateDetector {

    private final MinHasher minHasher;

    public DuplicateDetector(int numHashes) {
        this.minHasher = new MinHasher(numHashes);
    }
    private double jaccardSimilarity(Set<String> shingles1, Set<String> shingles2) {
        Set<String> intersection = new HashSet<>(shingles1);
        intersection.retainAll(shingles2); // Пересечение

        Set<String> union = new HashSet<>(shingles1);
        union.addAll(shingles2); // Объединение

        return (double) intersection.size() / union.size(); // Коэффициент
    }

    public double compareTexts(String text1, String text2, int shingleSize) {
        // Канонизация текстов
        String canonicalText1 = Canonicalizer.canonicalize(text1);
        String canonicalText2 = Canonicalizer.canonicalize(text2);

        // Генерация шинглов
        Set<String> shingles1 = Shingler.generateShingles(canonicalText1, shingleSize);
        Set<String> shingles2 = Shingler.generateShingles(canonicalText2, shingleSize);

        // Вычисление Jaccard-коэффициента для шинглов
        double jaccardSimilarity = jaccardSimilarity(shingles1, shingles2);

        return jaccardSimilarity; 
    }


}
