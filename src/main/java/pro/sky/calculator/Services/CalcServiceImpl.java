package pro.sky.calculator.Services;

import org.springframework.stereotype.Service;
import pro.sky.calculator.Exceptions.NoNumberExceptions;
import pro.sky.calculator.Exceptions.WrongArgumentException;

@Service
public class CalcServiceImpl implements CalcService {
    public Integer plus(Integer num1, Integer num2) {
        if ((num1 == null) || (num2 == null)) {
            throw new NoNumberExceptions(" НЕ можно быть пустым");
        }

        return num1 + num2;
    }

    public Integer minus(Integer num1, Integer num2) {

        return num1 - num2;
    }

    public Integer multiply(Integer num1, Integer num2) {

        return num1 * num2;
    }

    public Integer divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new WrongArgumentException(" нужно добавить число в ячейку 2 и на ноль делить нелья");
        }
            return num1 / num2;
        }

    public void exceptionNoNumber(Integer num1, Integer num2) {
        if ((num1 == null) || (num2 == null)) {
            throw new NoNumberExceptions(" НЕ можно быть пустым");
        }
    }
    }
