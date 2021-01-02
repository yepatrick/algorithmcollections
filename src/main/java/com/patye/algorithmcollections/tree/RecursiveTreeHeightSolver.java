package com.patye.algorithmcollections.tree;

public class RecursiveTreeHeightSolver<T> implements TreeHeightSolver<T> {

    @Override
    public int treeHeight(Tree<T> tree) {
        if (tree == null) {
            return 0;
        }

        if (tree.getBranches() == null || tree.getBranches().isEmpty()) {
            return 1;
        }

        return 1 + tree.getBranches().stream()
            .mapToInt(branch -> treeHeight(branch))
            .max().orElse(0);
    }
}
