package com.example.duplicate;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DuplicateDetectorTest {

    @Test
    public void testCompareTexts() {
        String text1 = "Пример текста для сравнения.";
        String text2 = "Текст для сравнения с примером.";

        DuplicateDetector detector = new DuplicateDetector(100);
        double similarity = detector.compareTexts(text1, text2, 5);

        assertTrue(similarity > 0.5, "Схожесть должна быть больше 50%");
    }
}
