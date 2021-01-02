package com.patye.algorithmcollections.dynamicprogramming;

import com.google.common.collect.Lists;
import lombok.Value;

import java.util.List;

/**
 * Solves the TopCoder problem of ChristmasBatteries.
 * @see <a href="https://community.topcoder.com/stat?c=problem_statement&pm=16717"/>
 */
public class ChristmasBatteries {
    public static int mostFun(int totalBatteries, int totalToys, int x, int y, int z, int m) {
        List<Toy> toys = Lists.newArrayList();

        for (int i = 0; i < totalToys; i++) {
            toys.add(new Toy(i, x, y, z, m));
        }

        return (int) (new ZeroOneKnapsack(totalBatteries).selectItems(toys).stream().mapToLong(Toy::getFun).sum());
    }

    @Value
    private static class Toy implements KnapsackItem {
        long serialNumber;
        long fun;
        int batteries;

        public Toy(long serialNumber, long x, long y, long z, long m) {
            this.serialNumber = serialNumber;
            batteries = (int)(serialNumber % 5);
            // (x + y) % m = ((x % m) + (y % m)) % m
            // See https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/modular-addition-and-subtraction
            fun = (((((x * serialNumber) % m) * serialNumber) % m)
                + ((y * serialNumber) % m)
                + (z % m)) % m;
        }

        @Override
        public double getValue() {
            return fun;
        }

        @Override
        public int getWeight() {
            return batteries;
        }
    }
}
