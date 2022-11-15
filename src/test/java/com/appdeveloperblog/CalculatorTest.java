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
        int result = calculator.integerSum(2, 1);
        assertEquals(result, 3);
    }

    @Test
    @DisplayName("測試 2022 - 1911 = 111")
    void testIntegerSub_When() {
        int result = calculator.integerSubtraction(2022, 1911);
        assertEquals(result, 111);
    }

    @Test
    @DisplayName("測試除0會噴掉")
    void testIntegerDivide_WhenOneDivideBy0_ShouldThrowArithmeticException() {
        //arrange
        int dividend = 1;
        int divisor =  0;
        String expectedExceptionMessage = "/ by zero";

        // act & assert
        //第一個參數放噴錯的類別,第二個為Executable,第三個是可選的訊息（當assert fail時會執行）
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
            // act
            calculator.integerDivide(dividend, divisor);
        }, "沒噴錯");
            // assert
        assertEquals(expectedExceptionMessage,actualException.getMessage(),"Unexpected error message");
    }
}