package tree;

import org.junit.Assert;
import org.junit.Test;
import tree.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N111_MinimumDepthOfBinaryTree {
    @Test
    public void N111_MinimumDepthOfBinaryTree() {
        int i4 = minDepth(new TreeNode(2,
                null, new TreeNode(3, null, new TreeNode(4,
                null, new TreeNode(5,
                null, new TreeNode(6))))));
        Assert.assertEquals(5, i4);
        int i = minDepth(new TreeNode(0, new TreeNode(0, new TreeNode(), null), null));
        Assert.assertEquals(3, i);
        int i2 = minDepth(new TreeNode(0,
                new TreeNode(0, new TreeNode(), null), new TreeNode()));
        Assert.assertEquals(2, i2);
        int i3 = minDepth(new TreeNode(0, new TreeNode(0, new TreeNode(), new TreeNode(0, new TreeNode(0), new TreeNode())), new TreeNode()));
        Assert.assertEquals(2, i3);
    }

    // Definition for a binary tree node.


    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        //队列存储二叉树每一层的结点
        List<TreeNode> list = new ArrayList<TreeNode>();
        int depth = 1;    //用于存储最小深度
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();  //每次存储一层的结点个数
            for (int i = 0; i < size; i++) {
                TreeNode temp = list.remove(0);
                //循环退出条件：当左右子结点都为空
                if (temp.left == null && temp.right == null) {
                    return depth;
                }

                if (temp.left != null) {
                    list.add(temp.left);
                }
                if (temp.right != null) {
                    list.add(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }


}
