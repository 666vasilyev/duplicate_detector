package com.example.duplicate;

import java.util.Set;

public class DuplicateDetector {

    private final MinHasher minHasher;

    public DuplicateDetector(int numHashes) {
        this.minHasher = new MinHasher(numHashes);
    }

    public double compareTexts(String text1, String text2, int shingleSize) {
        String canonicalText1 = Canonicalizer.canonicalize(text1);
        String canonicalText2 = Canonicalizer.canonicalize(text2);

        Set<String> shingles1 = Shingler.generateShingles(canonicalText1, shingleSize);
        Set<String> shingles2 = Shingler.generateShingles(canonicalText2, shingleSize);

        int[] minHashes1 = minHasher.computeMinHashes(shingles1);
        int[] minHashes2 = minHasher.computeMinHashes(shingles2);

        return jaccardSimilarity(minHashes1, minHashes2);
    }

    private double jaccardSimilarity(int[] hashes1, int[] hashes2) {
        int intersection = 0;
        for (int i = 0; i < hashes1.length; i++) {
            if (hashes1[i] == hashes2[i]) {
                intersection++;
            }
        }
        return (double) intersection / hashes1.length;
    }
}
