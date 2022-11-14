package com.appdeveloperblog;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Methods in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("BeforeAll is executed");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("BeforeEach is executed");
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("AfterEach is executed");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("AfterAll is executed");
    }


    @Test
    @DisplayName("測試 2 + 1 = 3")
    void testIntegerSum_WhenTwoPlusOne_ShouldReturnThree() {
        int result = calculator.sum(2, 1);
        assertEquals(result, 3);
    }

    @Test
    @DisplayName("測試 2022 - 1911 = 111")
    void testIntegerSub_When() {
        int result = calculator.integerSubtraction(2022, 1911);
        assertEquals(result, 111);
    }
}