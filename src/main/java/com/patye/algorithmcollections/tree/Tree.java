package com.patye.algorithmcollections.tree;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Builder
@Value
public class Tree<T> {
    T value;
    List<Tree<T>> branches;
}
