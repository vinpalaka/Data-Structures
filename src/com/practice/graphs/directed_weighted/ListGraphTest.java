package com.practice.graphs.directed_weighted;

import com.practice.graphs.directed_weighted.ListGraph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class ListGraphTest {

    @Test
    public void convertListToGraph() {
        List<Integer> list0 = new ArrayList<>(asList(1, 4, 6));
        List<Integer> list1 = new ArrayList<>(asList(3, 5, 7));
        List<Integer> list2 = new ArrayList<>(asList(8));
        List<Integer> list3 = new ArrayList<>(asList(1, 9, 2));
        List<Integer> list4 = new ArrayList<>(asList(8));
        List<Integer> list5 = new ArrayList<>(asList(7, 8));
        List<Integer> list6 = new ArrayList<>(asList(3, 4));
        List<Integer> list7 = new ArrayList<>(asList(2, 5, 7));
        List<Integer> list8 = new ArrayList<>(asList(4));
        List<Integer> list9 = new ArrayList<>(asList(1, 4));

        List<List<Integer>> graphList = new ArrayList<>(Arrays.asList(list0, list1, list2, list3, list4, list5, list6, list7,list8, list9));
        Map<Integer, List<Integer>> map = ListGraph.convertListToGraph(graphList);
        System.out.println("yol");
    }

    @Test
    public void findMinCost(){
        List<Integer> list0 = new ArrayList<>(asList(1, 2));//0
        List<Integer> list1 = new ArrayList<>(asList(3, 5, 7));//1
        List<Integer> list2 = new ArrayList<>(asList(4));//2
        List<Integer> list3 = new ArrayList<>(asList(2, 4, 7));//3
        List<Integer> list4 = new ArrayList<>(asList(8));//4
        List<Integer> list5 = new ArrayList<>(asList(7, 8));//5
        List<Integer> list6 = new ArrayList<>(asList(3, 7));//6
        List<Integer> list7 = new ArrayList<>(asList(2));//7
        List<Integer> list8 = new ArrayList<>(asList(9));//8
        List<Integer> list9 = new ArrayList<>(asList(1, 4));//9
        List<List<Integer>> graphList = new ArrayList<>(Arrays.asList(list0, list1, list2, list3, list4, list5, list6, list7,list8, list9));
        // 1 2 //0
        //3 4 //1
        //4//2
        //4 //3


        int cost = ListGraph.findMinCost(graphList);
        System.out.println(cost);
    }
}