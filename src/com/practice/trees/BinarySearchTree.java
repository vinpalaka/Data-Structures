package com.practice.trees;

import com.practice.lists.ListNode;
import com.practice.lists.MyLinkedList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.regex.Matcher;

public class BinarySearchTree<E extends Comparable<E>> {
    Node<E> root;
    boolean printSwitch = true;

    public BinarySearchTree(boolean printSwitch) {
        this.printSwitch = printSwitch;
    }

    public BinarySearchTree(E[] sortedArray) {
        root = sortedArrayToBST(sortedArray);
    }

    public BinarySearchTree(ListNode<E> sortedList) {
        root = sortedListToBST(sortedList);
    }

    public BinarySearchTree() {

    }

    public Node<E> sortedListToBST(ListNode<E> head) {
        if(head == null)
            return null;
        if(head.next == null) {
            return new Node<E>(head.item);
        }
        ListNode<E> temp = head;
        ListNode<E> slow = head;
        ListNode<E> fast = head;
        ListNode<E> pre = head;

        //When fast one is at end, slow one will be in middle, so slow will be new parent
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;//When we are calling recursivley, we want it to stop at slow now.
        Node<E> node = new Node<E>(slow.item);//slow reachs middle
        node.left = sortedListToBST(temp);
        node.right = sortedListToBST(slow.next);
        return node;
    }


    /**
     * Converts sorted array into balanced bst
     * This approach would work on normal tree too but not sorted.
     * @param nums
     * @return
     */
    public Node<E> sortedArrayToBST(E[] nums) {
        if(nums == null)
            return null;
        return makeTree(0, nums.length-1, nums);
    }

    private Node<E> makeTree(int start, int end, E[] nums) {
        Node<E> node = null;
        if(start <= end) {
            int mid = (start + end)/2;
            node = new Node<E>(nums[mid]);
            node.left = makeTree(start, mid - 1, nums);
            node.right = makeTree(mid + 1, end, nums );
        }
        return node;
    }

    public E get(E value) {
        Node<E> node = find(value, root);
        return node == null ? null : node.data;
    }

    private Node<E> find(E value, Node<E> node) {
        if(node == null || node.data.equals(value))
            return node;
        else if(value.compareTo(node.data) > 0)
            return find(value, node.right); //Go right if value is bigger
        else
            return find(value, node.left);
    }

    public void insert(E value) {
        root = insert(value, root);
    }

    public E delete(E value) {
        return value;
    }


    public int size(Node<E> node) {
        if(node == null)
            return 0;
        return size(node.left) + 1 + size(node.right);
    }

    public E max() {
        return findMax(root);
    }

    private E findMax(Node<E> root) {
        if(root.right == null) {
            return root.data;
        } else {
            return findMax(root.right);
        }
    }

    public E min() {
        return findMin(root);
    }

    private E findMin(Node<E> root) {
        if(root.left == null) {
            return root.data;
        } else {
            return findMin(root.left);
        }
    }

    /**
     * Inserts given node into binary search tree.
     * @param value
     * @param node
     * @return
     */
    private Node<E> insert(E value, Node<E> node) {
        if(node == null) {
            return new Node<>(value);
        }

        if(node.data.compareTo(value) > 0) {
            node.left = insert(value, node.left);
        } else if(node.data.compareTo(value) < 0) {
            node.right = insert(value, node.right);
        }
        return node;
    }

    /**
     * Deletes key from tree.
     * @param root
     * @param key
     * @return
     */
    public Node<E> delete(Node<E> root, E key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;

        /* Otherwise, recur down the tree */
        if (root.data.compareTo(key) > 0)
            root.left = delete(root.left, key);
        else if (root.data.compareTo(key) < 0)
            root.right = delete(root.right, key);

            // if key is same as root's key, then This is the node
            // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }

        return root;
    }

    private E minValue(Node<E> node)
    {
        E minv = node.data;
        while (node.left != null)
        {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }


    /**
     * Breadth first search of tree
     * Broken!!!!!!!!!!
     */
    public void printLevelOrder() {
        System.out.println("Level Order: ");
        int h = height();
        for(int i = 0; i < h; i++) {
            printLevelOrder(root, i);
        }
    }

    private void printLevelOrder(Node<E> root, int i) {
        if(root == null) {
            return;
        }
        if(i == 1) {
            System.out.print(root.data+ ", ");
        } else if(i > 1) {
            printLevelOrder(root.left, i -1);
            printLevelOrder(root.right, i -1);
        }
    }

    /**
     * Finds the longest branch from root
     * @return
     */
    public int height() {
        if(root == null) {
            return 0;
        } else {
           return  height(root);
        }
    }


    private int height(Node<E> root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;

       return Math.max(left, right);

    }

    public void printInOrder() {
        if(this.printSwitch) {
            System.out.println("InOrder: ");
            printInOrder(root);
        }
    }

    public void printInOrderIteratively() {
        if(this.printSwitch) {
            Node<E> temp = root;
            ArrayDeque<Node<E>> stack = new ArrayDeque<>();
            pushToLeft(temp, stack);

            while(!stack.isEmpty()) {
                Node<E> curr = stack.pop();
                System.out.print(curr.data + ", ");
                if(curr.right != null) {
                    pushToLeft(curr.right, stack);
                }
            }
        }
    }

    private void pushToLeft(Node<E> temp, ArrayDeque<Node<E>> stack) {
        while(temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
    }

    private void printInOrder(Node n) {
        if(n.left != null) {
            printInOrder(n.left);
        }
        System.out.print(n.data + ", ");
        if(n.right!=null) {
            printInOrder(n.right);
        }
    }
    public void printPreOrder() {
        if(this.printSwitch) {
            System.out.println("PreOrder: ");
            printPreOrder(root);
        }
    }

    private void printPreOrder(Node n) {
        System.out.print(n.data + ", ");
        if(n.left != null) {
            printPreOrder(n.left);
        }

        if(n.right!=null) {
            printPreOrder(n.right);
        }
    }

    public void printPostOrder() {
        if(this.printSwitch) {
            System.out.println("PostOrder: ");
            printPostOrder(root);
        }
    }

    private void printPostOrder(Node n) {
        if(n.left != null) {
            printPostOrder(n.left);
        }
        if(n.right!=null) {
            printPostOrder(n.right);
        }
        System.out.print(n.data + ", ");
    }

    public boolean checkBST(Node root) {
        if(root != null) {
            return checkNode(root);
        }
        String[] vals = "".split("");
        vals[2].substring(0, vals[2].indexOf("P"));
        return true;
    }
    private boolean checkNode(Node<E> node) {
        System.out.println(node.data);
        boolean result = true;
        Integer value = 160;
        if(node.data.equals(15)) {
            System.out.println("yo");
        }
        if(node.left != null) {
            if(node.left.data.compareTo( node.data) > 0 || node.left.data.equals(value)) {
                result =false;
            } else {
                result = checkNode(node.left);
            }
        }
        if(result && node.right != null) {
            if(node.right.data.compareTo(node.data) < 0 || node.right.data.equals(value)) {
                result = false;
            } else {
                result = checkNode(node.right);
            }
        }
        return result;
    }

    public void insertCycle(E[] nums, E data) {
        root = makeTree(0, nums.length - 1, nums);

        insertCycle(data, root);
    }

    private Node<E> insertCycle(E value, Node<E> node) {
        if(node == null) {
            return new Node<>(value);
        }

        if(node.data.compareTo(value) > 0) {
            node.left = insertCycle(value, node.left);
            if(node.left != null && node.left.data.equals(value)) {
                node.left.left = node;
            }

        } else if(node.data.compareTo(value) < 0) {
            node.right = insertCycle(value, node.right);
            if(node.right != null && node.right.data.equals(value)) {
                node.right.right = node;
            }
        }
        return node;
    }

    public void removeCycleDfs() {
        HashSet<Node> visited = new HashSet<>();
        Node<E> temp = root;
        root = removeCycleDfs(visited, temp);
    }

    private Node<E> removeCycleDfs(HashSet<Node> visited, Node<E> temp) {
        if(temp == null || visited.contains(temp))
            return null;

        visited.add(temp);
        temp.left = removeCycleDfs(visited, temp.left);
        temp.right = removeCycleDfs(visited, temp.right);
        return temp;
    }

    public void removeCycleBfs() {
        HashSet<Node> visited = new HashSet<>();
        ArrayDeque<Node> q = new ArrayDeque<>();
        Node<E> temp = root;
        q.add(temp);
        root = removeCycleBfs(visited, q, temp);
    }

    private Node<E> removeCycleBfs(HashSet<Node> visited, ArrayDeque<Node> q, Node<E> temp) {
        return null;
    }

    private class Node<E> {
        Node<E> left;
        Node<E> right;
        E data;

        Node(E data) {
            this.data = data;
        }

    }

    public E[] getArray( E[] ar) {
        if(root != null) {
            Node temp = root;
            ar = getArray(temp, ar, 0);
            return ar;
        }
        return null;
    }
    int pos = 0;
    private E[] getArray(Node n, E[] ar, int pos1) {
        pos = pos;
        if(n == null)
            return ar;
        ar = getArray(n.left, ar, pos);
        if(pos == ar.length) {
            ar = Arrays.copyOf(ar, pos * 2);
        }

        ar[pos++] = (E) n.data;
        ar = getArray(n.right, ar, pos);
        return ar;
    }

    /**
     * Finds the least common ancsestor.
     * Traverses list in preorder.
     * @param node
     * @param n1
     * @param n2
     * @return node if it is equal or in between n1 and n2
     */
    public Node<E> lca(Node<E> node, E n1, E n2) {

        if (node == null)
            return null;

        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.data.compareTo(n1) > 0 && node.data.compareTo(n2) > 0)
            return lca(node.left, n1, n2);

        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.data.compareTo(n1) < 0 && node.data.compareTo(n2) < 0)
            return lca(node.right, n1, n2);

        return node;
    }


    public E findCommonAncestor(E one, E two) {
        return lowestCommonAncestor(root, new Node<>(one), new Node<>(two)).data;
    }
    /**
     * Finds lca on non bST as well.
     * So does not use comparison
     * @param node
     * @param p
     * @param q
     * @return
     */
    public Node<E> lowestCommonAncestor(Node<E> node, Node<E> p, Node<E> q) {
        if(node==null){
            return null;
        }
        if(p.data.equals(node.data)||q.data.equals(node.data)){
            return node;
        }
        Node<E> left=lowestCommonAncestor(node.left,p,q);
        Node<E> right=lowestCommonAncestor(node.right,p,q);
        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return node;
        }
    }



}
