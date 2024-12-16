package com.example.duplicate;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MinHasher {

    private final int[] hashFunctions;

    public MinHasher(int numHashes) {
        hashFunctions = new int[numHashes];
        for (int i = 0; i < numHashes; i++) {
            hashFunctions[i] = i * 31 + 17; // Пример генерации хэш-функций
        }
    }

    public int[] computeMinHashes(Set<String> shingles) {
        int[] minHashes = new int[hashFunctions.length];
        for (int i = 0; i < minHashes.length; i++) {
            minHashes[i] = Integer.MAX_VALUE;
        }

        for (String shingle : shingles) {
            int shingleHash = shingle.hashCode();
            for (int i = 0; i < hashFunctions.length; i++) {
                int hash = (shingleHash ^ hashFunctions[i]);
                minHashes[i] = Math.min(minHashes[i], hash);
            }
        }
        return minHashes;
    }
}
