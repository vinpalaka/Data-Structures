package com.practice.graphs.directed_weighted;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListGraph {
    /**
     * This will convert list where each sublist index will be vertex
     * and elements in sublist will be neighbors
     * @param graphList
     */
    public static Map<Integer, List<Integer>> convertListToGraph(List<List<Integer>> graphList) {
        AtomicInteger counter = new AtomicInteger();
        return graphList.stream()
                .collect(Collectors.toMap(x->counter.getAndIncrement(), x-> x));
    }


    public static int findMinCost(List<List<Integer>> graphList) {
        int max = Integer.MAX_VALUE;
        for(int i = 0; i < graphList.get(0).size(); i++) {
            int current = findMinCost(i, graphList);
            if(current < max) {
                max = current;
            }
        }
        return max;
    }

    private static int findMinCost(int i, List<List<Integer>> graphList) {
            List<Integer> list = graphList.get(i);
            int max = Integer.MAX_VALUE;
            for(int j = 0; j < list.size(); j++) {
                int next = list.get(j);
                if(next == 9) {
                    return 0;
                }else {
                    int value = findMinCost(next, graphList);
                    int cost = (int)Math.pow(Math.abs(next - i), 2) + value;
                    if(cost < max) {
                        max = cost;
                    }
                }


        }
        return max;
    }
}
