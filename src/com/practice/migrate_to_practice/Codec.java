package com.practice.migrate_to_practice;

import java.util.ArrayDeque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public static class TreeNode{
        TreeNode right;
        TreeNode left;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public String serialize(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        String rep = "";
        if(root==null) {
            return rep+null;
        }

        rep+=root.val+",";
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.remove();
            TreeNode left = curr.left;
            TreeNode right = curr.right;
            if(left == null) {
                rep+= null +",";
            } else {
                rep+=left.val + ",";
                q.add(left);
            }

            if(right == null) {
                rep+= null +",";
            } else {
                rep+=right.val + ",";
                q.add(right);
            }
        }
        System.out.println();

        System.out.println(rep);
        return rep;
    }



    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        if(data==null) {
            return null;
        }
        String[] ar = data.split(",");
        int i = 0;
        if("null".equals(ar[i]) ||ar[i] == null) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(ar[i++]));
        q.add(root);
        int size = ar.length;
        while(!q.isEmpty()) {
            if(i == size)
                return root;
            TreeNode temp = q.remove();
            int j = 0;
            while("null".equals(ar[i]) ||ar[i] == null) {
                j++;
                i++;
                if(i == size)
                    return root;
                if(j % 2 == 0) {
                    temp = q.remove();
                    j=0;
                }

            }
            if(j % 2 == 0) {
                TreeNode left = new TreeNode(Integer.valueOf(ar[i++]));
                temp.left = left;
                q.add(left);
            }

            //j=0;
            while("null".equals(ar[i]) ||ar[i] == null) {

                i++;
                j++;
                if(i == size)
                    return root;
                if(j % 2 == 0) {
                    temp = q.remove();
                    j=0;
                }
            }
            if(i == size)
                return root;
            TreeNode right = new TreeNode(Integer.valueOf(ar[i++]));
            temp.right = right;
            q.add(right);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
