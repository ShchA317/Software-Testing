package com.example.tpo1;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.example.tpo1.task2.HeapSort;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HeapSortTests {

    @RepeatedTest(50)
    public void randomTest(){
        int length = RandomUtil.getPositiveInt() % 100;
        int[] arr = new Random().ints(length).toArray();
        int[] expected = Arrays.stream(arr).sorted().toArray();
        HeapSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void sortedAscTest() {
        int[] arr = {-1,-2,-3,-4,5,6,7,8,9};
        int[] expected = Arrays.stream(arr.clone()).sorted().toArray();
        HeapSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void sortedDescTest() {
        int[] arr = {9,8,7,6,5,4,3,2,1,0,-2,-1};
        int[] expected = Arrays.stream(arr.clone()).sorted().toArray();
        HeapSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void equalsArrayTest() {
        int[] arr = {0,0,0,0,0,0,0,0};
        int[] expected = arr.clone();
        HeapSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void oneElementArrayTest() {
        int[] arr = {1};
        int[] expected = arr.clone();
        HeapSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    public void zeroElementArrayTest() {
        int[] arr = {};
        int[] expected = arr.clone();
        HeapSort.sort(arr);
        assertArrayEquals(expected, arr);
    }

    @ParameterizedTest
    @MethodSource("arrExpectedArr")
    public void heapifyRootChoiceTest(int[] arr, int[] expected){
        HeapSort.heapify(arr, 2, 0);
        assertArrayEquals(expected, arr);
    }

    static Stream<Arguments> arrExpectedArr() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{2,1,3}),
                Arguments.of(new int[]{2,1,3}, new int[]{2,1,3}),
                Arguments.of(new int[]{3,1,2}, new int[]{3,1,2})
        );}
}
