package pro.sky.calculator.Services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.calculator.utils.resulGenerator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {calcServiceImpl.class})
@ExtendWith(SpringExtension.class)
class calcServiceParamTest {
    // создаем параметизированные тесты на +-*//
    @Autowired
    private pro.sky.calculator.Services.calcService calcService;

    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of(2, 2, resulGenerator.divideResult(2, 2, 1)),
                Arguments.of(100, 5, resulGenerator.divideResult(100, 5, 20))
        );
    }
    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of(2, 2, resulGenerator.plusResult(2, 2, 4)),
                Arguments.of(100, 5, resulGenerator.plusResult(100, 5, 105))
        );
    }
    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of(2, 2, resulGenerator.minusResult(2, 2, 0)),
                Arguments.of(100, 5, resulGenerator.minusResult(100, 5,95))
        );
    }
    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of(2, 2, resulGenerator.multiplyResult(2, 2, 4)),
                Arguments.of(100, 5, resulGenerator.multiplyResult(100, 5, 500))
        );
    }
    @ParameterizedTest
    @MethodSource("divideParams")
    void devideSuccess(int num1, int num2, ResponseEntity<String> excpectedResult) {
        Assertions.assertEquals(calcService.divide(num1, num2), excpectedResult);
    }
    @ParameterizedTest
    @MethodSource("plusParams")
    void plusSuccess(int num1, int num2, ResponseEntity<String> excpectedResult) {
        Assertions.assertEquals(calcService.plus(num1, num2), excpectedResult);
    }
    @ParameterizedTest
    @MethodSource("minusParams")
    void minusSuccess(int num1, int num2, ResponseEntity<String> excpectedResult) {
        Assertions.assertEquals(calcService.minus(num1, num2), excpectedResult);
    }
    @ParameterizedTest
    @MethodSource("multiplyParams")
    void multiplySuccess(int num1, int num2, ResponseEntity<String> excpectedResult) {
        Assertions.assertEquals(calcService.multiply(num1, num2), excpectedResult);
    }
}