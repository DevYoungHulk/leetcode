package tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/clone-n-ary-tree/
 */
public class N1490_CloneNAryTree {

    @Test
    public void coneNAryTree1490() {
        ArrayList<Node> children = new ArrayList<Node>();
        for (int i = 0; i < 3; i++) {
            children.add(new Node(2));
        }
        Node test = new Node(1, children);

        Node result = new Solution().cloneTree(test);
        assertResult(test, result);
        assertResult(null, null);
    }

    private void assertResult(Node node1, Node node2) {
        if (null == node1 && null == node2) {
            Assert.assertTrue(true);
            return;
        }
        Assert.assertNotEquals(node1, node2);
        Assert.assertEquals(node1.val, node2.val);
        List<Node> children1 = node1.children;
        List<Node> children2 = node2.children;
        if (null != children1 && null != children2) {
            Assert.assertEquals(children1.size(), children2.size());
            for (int i = 0; i < children1.size(); i++) {
                Assert.assertEquals(children1.get(i).val, children2.get(i).val);
                Assert.assertNotEquals(children1.get(i), children2.get(i));
            }
        }
    }

    class Node {
        public int val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }


    class Solution {
        public Node cloneTree(Node root) {
            if (null == root) {
                return null;
            }
            Node result;
            if (null == root.children) {
                result = new Node(root.val);
            } else {
                ArrayList<Node> childes = new ArrayList<Node>();
                for (Node c : root.children) {
                    childes.add(cloneTree(c));
                }
                result = new Node(root.val, childes);
            }
            return result;
        }
    }
}
