package pro.sky.calculator.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.calculator.Exceptions.NoNumberExceptions;
import pro.sky.calculator.Exceptions.WrongArgumentException;

@Service
public class CalcServiceImpl implements CalcService {
    public ResponseEntity<String> plus(Integer num1, Integer num2) {
        int result = num1 + num2;
        return ResponseEntity.ok(String.format("%s + %s = %s", num1, num2, result));
    }

    public ResponseEntity<String> minus(Integer num1, Integer num2) {
        int result = num1 - num2;

        return ResponseEntity.ok(String.format("%s - %s = %s", num1, num2, result));
    }

    public ResponseEntity<String> multiply(Integer num1, Integer num2) {
        int result = num1 * num2;
        return ResponseEntity.ok(String.format("%s * %s = %s", num1, num2, result));
    }

    public ResponseEntity<String> divide(Integer num1, Integer num2) {
        if (num2 == 0) {
            throw new WrongArgumentException("На ноль делить нельзя");
        }
        int result = num1 / num2;
        return ResponseEntity.ok(String.format("%s : %s = %s", num1, num2, result));
        }

    public void exceptionNoNumber(Integer num1, Integer num2) {
        if ((num1 == null) || (num2 == null)) {
            throw new NoNumberExceptions(" НЕ можно быть пустым");
        }
    }
    }
