package by.touchsoft.task.validator;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CodeValidatorTest {

    @Test
    void validateTestEx1(){
        String input = "{}}{}}";
        Set<String> expected = new HashSet<>();
        expected.add("{{}}");
        expected.add("{}{}");
        Set<String> actual = CodeValidator.validate(input);
        assertEquals(expected, actual);
    }

    @Test
    void validateTestEx2(){
        String input = "{}x}x}";
        Set<String> expected = new HashSet<>();
        expected.add("{x}x");
        expected.add("{xx}");
        expected.add("{}xx");
        Set<String> actual = CodeValidator.validate(input);
        assertEquals(expected, actual);
    }

    @Test
    void validateTestEx3(){
        String input = "{";
        Set<String> actual = CodeValidator.validate(input);
        System.out.println(actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    void isValidTest() {
        String input = "{{}{}}{}";
        boolean actual = CodeValidator.isValid(input);
        assertTrue(actual);

        input = "{{}{}";
        actual = CodeValidator.isValid(input);
        assertFalse(actual);
    }
}