package com.patye.algorithmcollections.dynamicprogramming;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solves the 0-1 knapsack problem using Dynamic Programming (DP).
 * <p>
 * Solution is derived from <a href="">Wikipedia entry of the Knapsack problem</a>.
 * <p>
 * Modified the algorithm for finding the chosen items from the original recursive method to an iterative method.
 */
@RequiredArgsConstructor
public class ZeroOneKnapsack {
    /**
     * The total capacity of the knapsack.
     */
    private final int capacity;

    public <T extends  KnapsackItem> List<T> selectItems(Collection<T> items) {
        // Discard all the items that are bigger than the capacity, there is no way that they can fit there.
        // Also discard items with non-positive values, there is no need to keep them there either.
        List<T> eligibleItems = items
            .stream().filter(item -> item.getWeight() <= capacity && item.getValue() > 0)
            .collect(Collectors.toList());

        double[][] values = new double[eligibleItems.size() + 1][capacity + 1];
        // Each column of the 2D array represents the fixed weight j (j's range is [0, capacity]).
        for (int i = 0; i <= capacity; i++) {
            values[0][i] = 0;
        }

        // Now calculate the total values for selecting each item.
        for (int i = 1; i <= eligibleItems.size(); i++) {
            double vi = eligibleItems.get(i - 1).getValue();
            int wi = eligibleItems.get(i - 1).getWeight();
            for (int j = 0; j <= capacity; j++) {
                if (wi > j) {
                    values[i][j] = values[i - 1][j];
                    // If we choose this item, then the total value of the sack is the sum of the
                    // value of this item and the sum of the values added before this item.
                } else {
                    values[i][j] = Math.max(values[i - 1][j], values[i - 1][j - wi] + vi);
                }
            }
        }

        // Now figure out the items that are chosen.
        List<T> chosenItems = Lists.newArrayList();
        int weightLeft = capacity;
        for (int i = eligibleItems.size() - 1; i >= 0; i--) {
            if (values[i + 1][weightLeft] > values[i][weightLeft]) {
                chosenItems.add(eligibleItems.get(i));
                weightLeft = weightLeft - eligibleItems.get(i).getWeight();
            }
        }

        return chosenItems;
    }
}
