package pro.sky.calculator.Services;

import pro.sky.calculator.Exceptions.NoNumberExceptions;

public interface CalcService {
    Integer plus(Integer num1, Integer num2);

    Integer minus(Integer num1, Integer num2);

    Integer multiply(Integer num1, Integer num2);

    Integer divide(Integer num1, Integer num2);
}
