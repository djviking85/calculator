package pro.sky.calculator.Services;

import org.assertj.core.internal.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.calculator.Exceptions.WrongArgumentException;
import pro.sky.calculator.utils.ResulGenerator;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ContextConfiguration(classes = {CalcServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalcServiceParamTest {
    // создаем параметизированные тесты на +-*/
    @Autowired
    private CalcService calcService;

    public static Stream<Arguments> divideParams() {
        return Stream.of(
                Arguments.of(2, 2, ResulGenerator.divideResult(2, 2, 1)),
                Arguments.of(100, 5, ResulGenerator.divideResult(100, 5, 20))
        );
    }
    public static Stream<Arguments> plusParams() {
        return Stream.of(
                Arguments.of(2, 2, ResulGenerator.plusResult(2, 2, 4)),
                Arguments.of(100, 5, ResulGenerator.plusResult(100, 5, 105))
        );
    }
    public static Stream<Arguments> minusParams() {
        return Stream.of(
                Arguments.of(2, 2, ResulGenerator.minusResult(2, 2, 0)),
                Arguments.of(100, 5, ResulGenerator.minusResult(100, 5,95))
        );
    }
    public static Stream<Arguments> multiplyParams() {
        return Stream.of(
                Arguments.of(2, 2, ResulGenerator.multiplyResult(2, 2, 4)),
                Arguments.of(100, 5, ResulGenerator.multiplyResult(100, 5, 500))
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