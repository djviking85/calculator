package pro.sky.calculator.Services;

import org.springframework.http.ResponseEntity;

public interface CalcService {
    ResponseEntity<String> plus(Integer num1, Integer num2);

    ResponseEntity<String> minus(Integer num1, Integer num2);

    ResponseEntity<String> multiply(Integer num1, Integer num2);

    ResponseEntity<String> divide(Integer num1, Integer num2);
}
