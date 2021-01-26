package tree;

import org.junit.Assert;
import org.junit.Test;

import javax.swing.tree.TreeNode;

public class N110_BalancedBinaryTree {
    @Test
    public void N110_BalancedBinaryTree() {
        TreeNode treeNode1 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        Assert.assertTrue(isBalanced(treeNode1));
        TreeNode treeNode2 = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7, new TreeNode(9), new TreeNode(10))));
        Assert.assertFalse(isBalanced(treeNode2));
    }

    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode node) {
        if (null == node) {
            return 0;
        }
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
