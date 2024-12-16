package com.example.duplicate;

public class Main {

    public static void main(String[] args) {
        String text1 = "Пример текста для сравнения.";
        String text2 = "Текст для сравнения с примером.";

        DuplicateDetector detector = new DuplicateDetector(100);
        double similarity = detector.compareTexts(text1, text2, 5);

        System.out.println("Схожесть текстов: " + (similarity * 100) + "%");
    }
}
