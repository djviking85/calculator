package pro.sky.calculator.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pro.sky.calculator.Exceptions.wrongArgumentException;
import pro.sky.calculator.Services.calcServiceImpl;
import pro.sky.calculator.Exceptions.noNumberExceptions;

@RestController
@RequestMapping("/calculator")
public class calcController {
    private final pro.sky.calculator.Services.calcService calcService;
    public calcController(calcServiceImpl calcService) {
        this.calcService = calcService;
    }
    @ExceptionHandler(wrongArgumentException.class)
    public ResponseEntity<?> handleDevideToZero(wrongArgumentException e) {
        return ResponseEntity.badRequest().body(" Делить на ноль нельзя");
    }

    @ExceptionHandler(noNumberExceptions.class)
    public ResponseEntity<?> noNumberInPrint(noNumberExceptions e) {
        return ResponseEntity.badRequest().body(" число не может бьыть пустым");
    }


    @GetMapping()
    public String helloCalculator() {
        return "Добро пожаловать в калькулятор!";
    }

    @GetMapping("/plus")
    public String plus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        ResponseEntity<String> resultat = calcService.plus(num1, num2);
        return num1 + "+" + num2 + "=" + resultat;
    }

    @GetMapping("/minus")
    public String minus(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        ResponseEntity<String> resultat = calcService.minus(num1, num2);
        return num1 + "-" + num2 + "=" + resultat;
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        ResponseEntity<String> resultat = calcService.multiply(num1, num2);
        return num1 + "*" + num2 + "=" + resultat;
    }

    @GetMapping("/divide")
    public String divide(@RequestParam("num1") int num1, @RequestParam("num2") int num2) {
        ResponseEntity<String> resultat = calcService.divide(num1, num2);
        return num1 + "/" + num2 + "=" + resultat;
    }
}
//1. Метод по адресу /calculator должен вернуть приветствие “Добро пожаловать в калькулятор".
// 2. Метод по адресу /calculator/plus?num1=5&num2=5 должен сложить num1 и num2 и вернуть результат в формате “5 + 5 = 10”
//3. Метод по адресу /calculator/minus?num1=5&num2=5 должен вычесть из num1 num2 и вернуть результат в формате “5 − 5 = 0”.
//4. Метод по адресу /calculator/multiply?num1=5&num2=5 должен умножить num1 на num2 и вернуть результат в формате “5 * 5 = 25”.
//5. Метод по адресу /calculator/divide?num1=5&num2=5 должен разделить num1 на num2 и вернуть результат в формате “5 / 5 = 1”.
//