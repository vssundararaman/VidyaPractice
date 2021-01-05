package com.vidya.dailybyte;

import com.vidya.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeZigZagTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(23);
        root.right = new TreeNode(18);
        root.left.left = new TreeNode(11);
        root.left.right = new TreeNode(43);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(27);
        root.left.left.left = new TreeNode(56);
        root.left.left.right = new TreeNode(78);
        root.left.left.right.left = new TreeNode(87);
        root.right.left.left = new TreeNode(32);
        root.right.left.right = new TreeNode(98);
        root.right.left.right.left = new TreeNode(29);

        System.out.println(zigZagTraversalOrder(root));
    }

    static List<List<Integer>> zigZagTraversalOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<TreeNode> ltor = new Stack<>();
        Stack<TreeNode> rtol = new Stack<>();

        ltor.add(root);
        List<Integer> resultValLst = new ArrayList<>();

        while (!ltor.isEmpty() || !rtol.isEmpty()) {

            while (!ltor.isEmpty()) {
                TreeNode n = ltor.pop();
                resultValLst.add(n.val);
                if (n.left != null) {
                    rtol.add(n.left);
                }
                if (n.right != null) {
                    rtol.add(n.right);
                }
            }
            if(!resultValLst.isEmpty()){
                result.add(new ArrayList<>(resultValLst));
            }
            resultValLst.clear();

            while (!rtol.isEmpty()){
                TreeNode n = rtol.pop();
                resultValLst.add(n.val);
                if(n.right!=null){
                    ltor.add(n.right);
                }
                if(n.left!=null){
                    ltor.add(n.left);
                }
            }

            if(!resultValLst.isEmpty()){
                result.add(new ArrayList<>(resultValLst));
            }

            resultValLst.clear();
        }

        return result;
    }
}
