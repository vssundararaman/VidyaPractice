package com.vidya.fb;

import com.vidya.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 938. Range Sum of BST
 * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Example 2:
 *
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */
public class RangeSumOfBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root,7,15));
    }

    static int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;

        if (root == null) {
            return sum;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            if (current.val >= low && current.val <= high) {
                sum += current.val;
            }

            if (current.left != null && current.val > low) {
                queue.add(current.left);
            }

            if (current.right != null && current.val < high) {
                queue.add(current.right);
            }

        }
        return sum;
    }
}
