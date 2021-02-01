package tree;

import org.junit.Assert;
import org.junit.Test;
import model.TreeNode;

public class N114_FlattenBinaryTreeToLinkedList {
    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
        Assert.assertEquals(root.val, 1);
        root = root.right;
        Assert.assertEquals(root.val, 2);
        root = root.right;
        Assert.assertEquals(root.val, 3);
        root = root.right;
        Assert.assertEquals(root.val, 4);
        root = root.right;
        Assert.assertEquals(root.val, 5);
        root = root.right;
        Assert.assertEquals(root.val, 6);
    }

    TreeNode tmp = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.left = null;
        root.right = tmp;
        tmp = root;
    }
}
