package com.practice.lists;

public class FlattenList {

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

    public Node flatten(Node head) {
        Node newHead = null;
        Node prev = null;
        prev = getNewHead(head, newHead, prev);
        Node temp = prev;
        while(temp.prev != null)
            temp = prev.prev;
        return temp;
    }

    private Node getNewHead(Node head, Node newHead, Node prev) {
        while(head != null) {
            newHead = new Node(head.val, head.prev, null, head.child);
            if(head.child != null) {
                getNewHead(head.child, newHead, prev);
            }
            head = head.next;
            prev = newHead;
            newHead = newHead.next;
        }
        return prev;
    }
}
