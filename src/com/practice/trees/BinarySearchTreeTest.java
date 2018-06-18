package com.practice.trees;


import com.practice.lists.ListNode;
import com.practice.lists.MyLinkedList;
import org.junit.Test;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNull;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer> tree = new BinarySearchTree<>(true);
    public BinarySearchTreeTest() {

    }


    @Test
    public void insert() {
        System.out.println("Yolo");
        tree.insert(40);
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.insert(5);
        tree.insert(70);
        assertNull(tree.get(7));
        assertEquals(tree.get(40),Integer.valueOf(40));
        tree.insert(30);
        tree.insert(25);
        tree.insert(125);
        tree.insert(15);
        tree.insert(1);
        assertEquals(Integer.valueOf(70), tree.get(70));
        assertEquals(Integer.valueOf(25), tree.get(25));
        assertNull(tree.get(10));
        tree.insert(100);
        tree.insert(4);
        tree.insert(2);
        tree.insert(3);
        tree.insert(0);
        tree.insert(75);
        tree.insert(60);
        tree.printInOrder();
        System.out.println();
        tree.printPostOrder();
        System.out.println();

        tree.printPreOrder();
        System.out.println("\nNow Let's Delete");
        tree.delete(30);

        tree.printInOrder();
        tree.delete(100);
        tree.printInOrder();
        //tree.insert(2);
        tree.delete(1);
        tree.printInOrder();
        tree.delete(40);
        System.out.println(tree.checkBST(tree.root));
        System.out.println(tree.size(tree.root));
        System.out.println(tree.max());
        System.out.println(tree.min());
        tree.insert(1000);
        tree.printInOrder();
        System.out.println();
        System.out.println(tree.height());


        tree.printLevelOrder();
        System.out.println("================================");
        tree.printInOrder();
        System.out.println("================================");
        tree.printInOrderIteratively();

    }

    @Test
    public void testCheckBst() {
        String value = "1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 17 16 18 19 20 21 22 23 24 25 26 27 28 29 30 31";
        for(String curr : value.split(" ")) {
            tree.insert(Integer.valueOf(curr));;
        }
        System.out.println(tree.checkBST(tree.root));
        System.out.println();

        System.out.println(tree.height());

    }

    @Test
    public void testtreetobinary() {
        String value = "4 2 6 1 3 5 9";
        for(String curr : value.split(" ")) {
            tree.insert(Integer.valueOf(curr));;
        }
        Integer[] ar = new Integer[1];
        Arrays.stream(tree.getArray(ar))
                .forEach(System.out::println);
    }

    @Test
    public void testSortedTreeCreate() {
        Integer[] ar = {1,2,3,5,6,8,9,11,14,23,34,56,78,88,455};
        tree = new BinarySearchTree<>(ar);
        tree.printLevelOrder();
        System.out.println();
        tree.printInOrderIteratively();
        System.out.println();

        System.out.println(tree.height());

    }

    @Test
    public void testSortedListToTreeCreate() {
        Integer[] ar = {1,2,3,5,6,8,9,11,14,23,34,56,78,88,455};
        ListNode<Integer> root = new ListNode<>(ar[0]);
        ListNode<Integer> temp = root;
        for(int i = 1; i <ar.length; i++) {
            temp.next = new ListNode<>(ar[i]);
            temp = temp.next;
        }

        tree = new BinarySearchTree<>(root);
        tree.printLevelOrder();
        System.out.println();
        tree.printInOrderIteratively();
        System.out.println();

        System.out.println(tree.height());


    }

    @Test
    public void testLCA() {
        Integer[] ar = {1,2,3,4,5,6,7,8,9};
        tree = new BinarySearchTree<>(ar);
        tree.printInOrderIteratively();
        int ans = tree.findCommonAncestor(4, 7);
        System.out.println();

        System.out.println(ans);

        System.out.println(tree.height());


    }

    @Test
    public void testCycleInTree() {
        Integer[] ar = {1,2,3,4,5,6,8,9};
        tree = new BinarySearchTree<Integer>();
        tree.insertCycle(ar, 7);
        //tree.printInOrder(); This will throw stackoverflow since there is cycle
        tree.removeCycleDfs();
        tree.printInOrder();

    }



}