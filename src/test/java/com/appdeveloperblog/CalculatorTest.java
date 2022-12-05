package com.appdeveloperblog;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

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

    @DisplayName("Test integer subtraction [minuend, subtrahend, expectedResult")
    @ParameterizedTest
    @MethodSource("integerSubtractionInputParameters")
    // 參數化測試使使用不同參數多次進行測試成為可能。它們與常規的@Test方法一樣被宣告，但是使用 @ParameterizedTest註解。
    // 此外，您必須聲明至少一個源，該源將為每個調用提供參數，然後使用測試方法中的參數，即使用 @MethodSource("方法名稱")。
    // 如果MethodSource的來源名稱和此測試程式名稱一樣，可以省略不寫。
    // i.e, 將integerSubtractionInputParameters改名成integerSubtraction後，註解可以改寫成 @MethodSource()
    void integerSubtraction(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test "+minuend+" - "+subtrahend+" = "+expectedResult);
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, actualResult,
                ()->minuend + "-" + subtrahend + "did not produce" + expectedResult);
    }

    private static Stream<Arguments> integerSubtractionInputParameters() {
         return Stream.of(
                 Arguments.of(33, 1, 32),
                 Arguments.of(24, 1, 23),
                 Arguments.of(54, 1, 53)
         );
    }
}