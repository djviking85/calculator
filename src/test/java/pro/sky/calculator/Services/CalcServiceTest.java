package pro.sky.calculator.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pro.sky.calculator.Exceptions.WrongArgumentException;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {CalcServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalcServiceTest {
    // создаем тесты на +-*/
    @Autowired
    private CalcService calcService;
    @Test
    void plusTestSuccess () {
        // подготовка входных данных
        Integer num1 = 2;
        Integer num2 = 5;
        // подготовка ожидаемого результата
        String answer = "2+5 = 7";
        Integer  expectedResult = num1 + num2;
        // анчало теста
        Integer actualResult = calcService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);

    }
    @Test
    void plusTestSuccess2 () {
        // подготовка входных данный
        Integer num1 = 4;
        Integer num2 = 4;
        // подготовка ожидаемого результата
        String answer = "4+4 = 8";
        Integer  expectedResult = num1 + num2;
        // анчало теста
        Integer actualResult = calcService.plus(num1, num2);
        assertEquals(expectedResult, actualResult);

    }
    @Test
    void minusTestSuccess () {
// подготовка входных данных
        Integer num1 = 2;
        Integer num2 = 5;
        // подготовка ожидаемого результата
        String answer = "2-5 = -3";
        Integer  expectedResult = num1 - num2;
        // анчало теста
        Integer actualResult = calcService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void minusTestSuccess2 () {
// подготовка входных данных
        Integer num1 = 7;
        Integer num2 = 3;
        // подготовка ожидаемого результата
        String answer = "7+3 = 5";
        Integer  expectedResult = num1 - num2;
        // анчало теста
        Integer actualResult = calcService.minus(num1, num2);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void multipleTestSuccess () {
// подготовка входных данных
        Integer num1 = 2;
        Integer num2 = 5;
        // подготовка ожидаемого результата
        String answer = "2*5 = 10";
        Integer  expectedResult = num1 * num2;
        // анчало теста
        Integer actualResult = calcService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }
    @Test
    void multipleTestSuccess2 () {
// подготовка входных данных
        Integer num1 = 100;
        Integer num2 = 100;
        // подготовка ожидаемого результата
        String answer = "100*100 = 10000";
        Integer expectedResult = num1 * num2;
        // анчало теста
        Integer actualResult = calcService.multiply(num1, num2);
        assertEquals(expectedResult, actualResult);
    }


    @Test
    void devideTestSuccess () {
// подготовка входных данных
        Integer num1 = 100;
        Integer num2 = 100;
        // подготовка ожидаемого результата
        String answer = "100/100 = 1";
        Integer expectedResult = num1 * num2;
        // анчало теста
        Integer actualResult = calcService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void devideTestSuccess2 () {
// подготовка входных данных
        Integer num1 = 100;
        Integer num2 = 5;
        // подготовка ожидаемого результата
        String answer = "100/5 = 20";
        Integer expectedResult = num1 * num2;
        // анчало теста
        Integer actualResult = calcService.divide(num1, num2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void devideWrongArgumentException () {
// подготовка входных данных
        Integer num1 = 100;
        Integer num2 = 0;
        // подготовка ожидаемого результата
        Exception exception = assertThrows (WrongArgumentException.class,() -> {calcService.divide(num1, num2);}
        );
            String exceptMessage = "На ноль делить нельзя";
        // анчало теста
        assertEquals(exceptMessage, exception.getMessage());
    }
}