package com.appdeveloperblog;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Methods in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    // 方法要為static，有此註解的方法會在所有Test Methods執行前執行。
    static void setup() {
        System.out.println("BeforeAll is executed");
    }

    @BeforeEach
    //有此註解的方法會在當前Class中的所有Test Methods執行前執行。
    void beforeEachTestMethod() {
        calculator = new Calculator();
        System.out.println("BeforeEach is executed");
    }

    @AfterEach
    //有此註解的方法會在當前Class中的所有Test Methods執行後執行。
    void afterEachTestMethod() {
        System.out.println("AfterEach is executed");
    }

    @AfterAll
    // 有此註解的方法要為static，有此註解的方法會在所有Test Methods執行後執行。
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