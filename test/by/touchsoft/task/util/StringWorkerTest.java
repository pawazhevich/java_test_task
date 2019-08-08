package by.touchsoft.task.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringWorkerTest {
    @Test
    void trimBracketsTest(){
        String input = "}a}b{c{";
        String expected = "abc";
        String actual = StringWorker.trimBrackets(input);
        assertEquals(expected, actual);
    }

    @Test
    void removeSymbolsAtTest(){
        String input = "0123456";
        Integer[] indexList = {0,3,6};
        ArrayList<Integer> indexes = new ArrayList<>(Arrays.asList(indexList));
        String expected = "1245";
        String actual = StringWorker.removeSymbolsAt(indexes, input);
        assertEquals(expected, actual);
    }
}