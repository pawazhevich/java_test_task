package by.touchsoft.task.util;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArrayCombinerTest {

    @Test
    void productTest() {
        Integer[] first = {1,2,3};
        Integer[] second = {5,6};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(first)));
        list.add(new ArrayList<>(Arrays.asList(second)));

        HashSet<ArrayList<Integer>> actual = ArrayCombiner.product(list);

        Integer[][] expectedList = {{3, 5}, {2, 5}, {3, 6}, {1, 5}, {2, 6}, {1, 6}};
        HashSet<ArrayList<Integer>> expected = new HashSet<>();

        Stream.of(expectedList).forEach(o->{
            ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(o));
            expected.add(temp);
        });

        assertEquals(expected, actual);
    }
}