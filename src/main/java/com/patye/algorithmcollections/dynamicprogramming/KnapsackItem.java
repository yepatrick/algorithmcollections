package com.patye.algorithmcollections.dynamicprogramming;

/**
 * Abstract item that can be added to a knapsack.
 */
public interface KnapsackItem {
    double getValue();
    int getWeight();
}
