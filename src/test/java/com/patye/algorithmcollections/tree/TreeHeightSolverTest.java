package com.patye.algorithmcollections.tree;

import com.google.common.collect.ImmutableList;
import org.junit.Assert;
import org.junit.Test;

public class TreeHeightSolverTest {
    private static final Tree TREE_1 = Tree.builder().value(1).build();
    private static final Tree TREE_2 = Tree.builder().value(1)
        .branches(ImmutableList.of(Tree.builder().value(2).build()))
        .build();
    private static final Tree TREE_3 = Tree.builder().value(1)
        .branches(ImmutableList.of(
            Tree.builder().value(2)
                .branches(ImmutableList.of(Tree.builder().value(4).build(),
                    Tree.builder().value(5).build()))
                .build(),
            Tree.builder().value(3)
                .branches(ImmutableList.of(Tree.builder().value(6).build(),
                    Tree.builder().value(7).build()))
                .build()))
        .build();
    private static final Tree TREE_4 = Tree.builder().value(1)
        .branches(ImmutableList.of(
            Tree.builder().value(2).branches(ImmutableList.of(
                Tree.builder().value(4).branches(ImmutableList.of(
                    Tree.builder().value(8).branches(ImmutableList.of(
                        Tree.builder().value(9).build()
                    )).build()
                )).build()
            )).build(),
            Tree.builder().value(3).branches(ImmutableList.of(
                Tree.builder().value(6).build(),
                Tree.builder().value(7).build())
            ).build()
        ))
        .build();
    private static final Tree TREE_5 = Tree.builder().value(1)
        .branches(ImmutableList.of(
            Tree.builder().value(2).branches(ImmutableList.of(
                Tree.builder().value(4).build(),
                Tree.builder().value(5).build())
            ).build(),
            Tree.builder().value(3).branches(ImmutableList.of(
                Tree.builder().value(6).branches(ImmutableList.of(
                    Tree.builder().value(7).branches(ImmutableList.of(
                        Tree.builder().value(8).build()
                    )).build()
                )).build()
            )).build()
        ))
        .build();

    private void testSuit(TreeHeightSolver solver) {
        Assert.assertEquals(0, solver.treeHeight(null));
        Assert.assertEquals(1, solver.treeHeight(TREE_1));
        Assert.assertEquals(2, solver.treeHeight(TREE_2));
        Assert.assertEquals(3, solver.treeHeight(TREE_3));
        Assert.assertEquals(5, solver.treeHeight(TREE_4));
        Assert.assertEquals(5, solver.treeHeight(TREE_5));

    }

    @Test
    public void testIt() {
        testSuit(new RecursiveTreeHeightSolver<Integer>());
        testSuit(new IterativeTreeHeightSolver<Integer>());
    }
}
