package com.patye.algorithmcollections.dynamicprogramming;

import com.patye.algorithmcollections.dynamicprogramming.ChristmasBatteries;
import org.junit.Assert;
import org.junit.Test;

public class ChristmasBatteriesTest {
    @Test
    public void test0() {
        Assert.assertEquals(1, ChristmasBatteries.mostFun(0, 5, 1, 1, 1, 1000));
    }

    @Test
    public void test1() {
        Assert.assertEquals(14, ChristmasBatteries.mostFun(3, 5, 1, 1, 1, 1000));
    }

    @Test
    public void test2() {
        Assert.assertEquals(11, ChristmasBatteries.mostFun(3, 5, 1, 1, 1, 13));
    }

    @Test
    public void test3() {
        Assert.assertEquals(0, ChristmasBatteries.mostFun(4, 10000, 123, 456, 789, 1));
    }

    @Test
    public void test4() {
        Assert.assertEquals(100, ChristmasBatteries.mostFun(7, 4, 3, 5, 7, 997));
    }

    @Test
    public void test5() {
        Assert.assertEquals(143371, ChristmasBatteries.mostFun(2, 12345, 234, 34, 5, 117));
    }
}
