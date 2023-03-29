package pro.sky.calculator.Services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {CalcServiceImpl.class})
@ExtendWith(SpringExtension.class)
class CalcServiceTest {
    @Autowired
    private CalcService calcService;
    @Test
    void devideTestSuccess () {

    }
    @Test
    void devideWrongArgumentException () {

    }
}