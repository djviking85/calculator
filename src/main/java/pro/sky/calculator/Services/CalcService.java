package pro.sky.calculator.Services;

import org.springframework.stereotype.Service;
import pro.sky.calculator.Exceptions.DivideToZeroException;
import pro.sky.calculator.Exceptions.NoNumberExceptions;

@Service
public class CalcService {
    public int plus(int num1, int num2) {
//        if ((num1 == null) || (num2 == null)) {
//            throw new NoNumberExceptions(" НЕ можно быть пустым");
//        }
        exceptionNoNumber(num1, num2);
        return num1 + num2;
    }

    public int minus(int num1, int num2) {
        exceptionNoNumber(num1, num2);
        return num1 - num2;
    }

    public int multiply(int num1, int num2) {
        exceptionNoNumber(num1, num2);
        return num1 * num2;
    }

    public int divide(Integer num1, int num2) {
        if (num1 == null) {
            throw new NoNumberExceptions(" нужно добавить число в ячейку 1");
        } else if (num2 == 0) {
            // почему-то если делать return "На ноль делить нельзя пишет 500 ошибку и все( пришлось понимать как по видео
            throw new DivideToZeroException();
             }
        else
            return num1 / num2;
        }

    public void exceptionNoNumber(Integer num1, Integer num2) {
        if ((num1 == null) || (num2 == null)) {
            throw new NoNumberExceptions(" НЕ можно быть пустым");
        }
    }
    }
