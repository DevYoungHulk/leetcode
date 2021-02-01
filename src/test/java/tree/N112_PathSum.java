package tree;

import org.junit.Assert;
import org.junit.Test;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N112_PathSum {
    @Test
    public void test() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4_2;
        node4_2.right = node1;

        Assert.assertTrue(hasPathSum(node5, 22));
        Assert.assertTrue(hasPathSum2(node5, 22));

        Assert.assertTrue(hasPathSum(new TreeNode(0, new TreeNode(1), new TreeNode(1)), 1));
        Assert.assertTrue(hasPathSum2(new TreeNode(0, new TreeNode(1), new TreeNode(1)), 1));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (null == root) {
            return 0 == targetSum;
        }
        List<TreeNode> list = new ArrayList<TreeNode>();
        List<Integer> sums = new ArrayList<Integer>();
        list.add(root);
        sums.add(0);
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = list.remove(0);
                Integer sumTmp = sums.remove(0);
                int tmpSum = sumTmp + tmp.val;
                if (tmpSum == targetSum && tmp.left == null && tmp.right == null) {
                    return true;
                }
                if (null != tmp.left) {
                    list.add(tmp.left);
                    sums.add(tmpSum);
                }
                if (null != tmp.right) {
                    list.add(tmp.right);
                    sums.add(tmpSum);
                }
            }
        }
        return false;
    }

    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }


}