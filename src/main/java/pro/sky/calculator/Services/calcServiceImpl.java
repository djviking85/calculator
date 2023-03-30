package pro.sky.calculator.Services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pro.sky.calculator.Exceptions.noNumberExceptions;
import pro.sky.calculator.Exceptions.wrongArgumentException;

@Service
public class calcServiceImpl implements calcService {
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
            throw new wrongArgumentException("На ноль делить нельзя");
        }
        int result = num1 / num2;
        return ResponseEntity.ok(String.format("%s : %s = %s", num1, num2, result));
        }

    public void exceptionNoNumber(Integer num1, Integer num2) {
        if ((num1 == null) || (num2 == null)) {
            throw new noNumberExceptions(" НЕ можно быть пустым");
        }
    }
    }
