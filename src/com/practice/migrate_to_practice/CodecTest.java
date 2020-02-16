package com.practice.migrate_to_practice;

import org.junit.Test;

import static org.junit.Assert.*;

public class CodecTest {

    @Test
    public void serialize1() {
        Codec codec = new Codec();
        Codec.TreeNode one = new Codec.TreeNode(1);
        Codec.TreeNode two = new Codec.TreeNode(2);
        Codec.TreeNode three = new Codec.TreeNode(3);
        Codec.TreeNode four = new Codec.TreeNode(4);
        Codec.TreeNode five = new Codec.TreeNode(5);

        one.left = two;
        one.right = three;

        three.left = four;
        three.right = five;

        printTree(one);

        Codec.TreeNode result = codec.deserialize(codec.serialize(one));
        System.out.println();
        printTree(result);


    }

    @Test
    public void serialize2() {
        Codec codec = new Codec();
        Codec.TreeNode one = new Codec.TreeNode(1);
        Codec.TreeNode two = new Codec.TreeNode(2);
        one.right = two;

        printTree(one);

        Codec.TreeNode result = codec.deserialize(codec.serialize(one));
        System.out.println();
        printTree(result);


    }

    @Test
    public void serialize3() {
        Codec codec = new Codec();
        Codec.TreeNode one = new Codec.TreeNode(1);
        Codec.TreeNode two = new Codec.TreeNode(2);
        Codec.TreeNode three = new Codec.TreeNode(3);
        Codec.TreeNode four = new Codec.TreeNode(4);
        Codec.TreeNode five = new Codec.TreeNode(5);
        Codec.TreeNode six = new Codec.TreeNode(6);


        one.left = two;
        one.right = five;

        two.left = three;

        five.left = four;
        five.right = six;

        printTree(one);

        Codec.TreeNode result = codec.deserialize(codec.serialize(one));
        System.out.println();
        printTree(result);


    }

    private void printTree(Codec.TreeNode one) {
        if(one != null) {
            System.out.print(one.val + ",");
            printTree(one.left);
            printTree(one.right);
        }
    }
}