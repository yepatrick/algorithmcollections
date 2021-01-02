package com.patye.algorithmcollections.tree;

import lombok.Builder;
import lombok.Value;

import java.util.Stack;

public class IterativeTreeHeightSolver<T> implements TreeHeightSolver<T> {

    @Override
    public int treeHeight(Tree<T> tree) {
        if (tree == null) {
            return 0;
        }

        Stack<TreeWithHeight<T>> stack = new Stack<>();
        stack.push(TreeWithHeight.<T>builder().height(1).tree(tree).build());

        int height = 0;
        while (!stack.empty()) {
            TreeWithHeight<T> top = stack.pop();
            height = Math.max(height, top.height);
            if (top.getTree().getBranches() != null) {
                for (Tree<T> branch : top.getTree().getBranches()) {
                    stack.push(TreeWithHeight.<T>builder().height(top.height + 1).tree(branch).build());
                }
            }
        }

        return height;
    }

    @Builder
    @Value
    private static class TreeWithHeight<T> {
        Tree<T> tree;
        int height;
    }
}
