package demoqa;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FirstJUnitTest {

    @BeforeEach
    void beforeEach() {
        System.out.println("это анатация beforeEach");
    }
    @AfterEach
    void afterEach() {
        System.out.println("это анатация afterEach");
    }

    @Test
    void testFirstJUnit() {
        Assertions.assertTrue(3 > 2);
        System.out.println("Это наш тест 1");
    }

    @Test
    public void testSecondJUnit() {
        System.out.println("Это наш тест 2");
    }
}
