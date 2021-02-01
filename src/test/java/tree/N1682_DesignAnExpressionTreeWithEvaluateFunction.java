package tree;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class N1682_DesignAnExpressionTreeWithEvaluateFunction {
    @Test
    public void test() {
        String[] data = new String[]{"3", "4", "+", "2", "*", "7", "/"};
        Assert.assertEquals(new TreeBuilder().buildTree(data).evaluate(), 2);
        String[] data2 = new String[]{"4", "5", "7", "2", "+", "-", "*"};
        Assert.assertEquals(new TreeBuilder().buildTree(data2).evaluate(), -16);
        String[] data3 = new String[]{"4", "2", "+", "3", "5", "1", "-", "*", "+"};
        Assert.assertEquals(new TreeBuilder().buildTree(data3).evaluate(), 18);
        String[] data4 = new String[]{"100", "200", "+", "2", "/", "5", "*", "7", "+"};
        Assert.assertEquals(new TreeBuilder().buildTree(data4).evaluate(), 757);
    }

    /**
     * This is the interface for the expression tree Node.
     * You should not remove it, and you can define some classes to implement it.
     */

    abstract class Node {
        public abstract int evaluate();

        // define your fields here
    }

    class StringNode extends Node {

        public StringNode left;

        public StringNode right;

        public String val;

        public StringNode() {
        }

        @Override
        public int evaluate() {
            if ("+".equals(this.val)) {
                return this.left.evaluate() + this.right.evaluate();
            } else if ("-".equals(this.val)) {
                return this.left.evaluate() - this.right.evaluate();
            } else if ("*".equals(this.val)) {
                return this.left.evaluate() * this.right.evaluate();
            } else if ("/".equals(this.val)) {
                return this.left.evaluate() / this.right.evaluate();
            }
            return Integer.parseInt(this.val);
        }
    }


    /**
     * This is the TreeBuilder class.
     * You can treat it as the driver code that takes the postinfix input
     * and returns the expression tree represnting it as a Node.
     */
    private static final List<String> F = Arrays.asList("+", "-", "*", "/");

    class TreeBuilder {
        Node buildTree(String[] postfix) {
            Stack<StringNode> tmp = new Stack<StringNode>();
            for (String p : postfix) {
                StringNode node = new StringNode();
                node.val = p;
                if (F.contains(p)) {
                    node.right = tmp.pop();
                    node.left = tmp.pop();
                }
                tmp.push(node);
            }
            return tmp.pop();
        }
    }


/**
 * Your TreeBuilder object will be instantiated and called as such:
 * TreeBuilder obj = new TreeBuilder();
 * Node expTree = obj.buildTree(postfix);
 * int ans = expTree.evaluate();
 */
}
