package com.vidya.dailybyte;

import com.vidya.common.TreeNode;

public class RootToLeafPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left =  new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(rootToLeafPathSum(root, 22));
    }

    static boolean rootToLeafPathSum(TreeNode root, int sum){
        if (root == null){
            return false;
        } else if(root.left == null && root.right == null){
            return sum - root.val ==0;
        }else{
          return  rootToLeafPathSum(root.left,sum-root.val) ||
                  rootToLeafPathSum(root.right,sum-root.val);
        }
    }
}
