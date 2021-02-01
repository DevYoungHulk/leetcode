package tree;

import org.junit.Assert;
import org.junit.Test;
import model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class N113_PathSumII {
    @Test
    public void test() {
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node11 = new TreeNode(11);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node8 = new TreeNode(8);
        TreeNode node13 = new TreeNode(13);
        TreeNode node4_2 = new TreeNode(4);
        TreeNode node1 = new TreeNode(1);
        TreeNode node5_2 = new TreeNode(5);
        node5.left = node4;
        node5.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;
        node8.left = node13;
        node8.right = node4_2;
        node4_2.left = node5_2;
        node4_2.right = node1;

        List<List<Integer>> lists = pathSum(node5, 22);
        System.out.println("-- results --");
        for (List<Integer> r : lists) {
            System.out.println(r.toString());
        }
        Assert.assertEquals(lists.size(), 2);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(root, targetSum, 0, new ArrayList<Integer>(), result);
        return result;
    }

    public void dfs(TreeNode root, int targetSum, int sum, List<Integer> list,
                    List<List<Integer>> result) {
        if (null == root) {
            return;
        }
        list.add(root.val);
        sum += root.val;

        System.out.println("-- calc ing --");
        System.out.println(list.toString());
        if (null == root.left && null == root.right) {
            if (targetSum == sum)
                result.add(new ArrayList<Integer>(list));
            list.remove(list.size() - 1);
            return;
        }
        if (null != root.left) {
            dfs(root.left, targetSum, sum, list, result);
        }
        if (null != root.right) {
            dfs(root.right, targetSum, sum, list, result);
        }
        list.remove(list.size() - 1);
    }

    class Calc {
        TreeNode currentNode;
        int sum;
        List<Integer> links = new ArrayList<Integer>();

        Calc(TreeNode currentNode) {
            this.currentNode = currentNode;
        }
    }


    public List<List<Integer>> pathSum1(TreeNode root, int targetSum) {
        if (null == root) {
            return new ArrayList<List<Integer>>();
        }
        List<Calc> list = new ArrayList<Calc>();
        list.add(new Calc(root));
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        while (!list.isEmpty()) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Calc c = list.remove(0);
                TreeNode tmp = c.currentNode;
                List<Integer> links = c.links;
                int tmpSum = c.sum + tmp.val;
                links.add(tmp.val);
//                System.out.println("-- calc ing --");
//                System.out.println(links.toString());
                if (tmpSum == targetSum && tmp.left == null && tmp.right == null) {
                    results.add(links);
                }
                if (null != tmp.left) {
                    Calc lc = new Calc(tmp.left);
                    lc.links = new ArrayList<Integer>(links);
                    lc.sum = tmpSum;
                    list.add(lc);
                }
                if (null != tmp.right) {
                    Calc lc = new Calc(tmp.right);
                    lc.links = new ArrayList<Integer>(links);
                    lc.sum = tmpSum;
                    list.add(lc);
                }
            }
        }
        return results;
    }


}