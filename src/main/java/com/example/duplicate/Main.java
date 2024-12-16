package com.example.duplicate;

public class Main {

    public static void main(String[] args) {
        String text1 = "Пример текста для анализа.";
        String text2 = "Пример текста для анализаfff.";

        DuplicateDetector detector = new DuplicateDetector(200);
        double similarity = detector.compareTexts(text1, text2, 10);

        System.out.println("Схожесть текстов: " + (similarity * 100) + "%");
    }
}
