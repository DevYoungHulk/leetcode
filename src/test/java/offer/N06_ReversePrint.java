package offer;

import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import java.util.Stack;

public class N06_ReversePrint {
    @Test
    public void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        int[] ints = reversePrint(head);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + ",");
        }
        Assert.assertArrayEquals(ints, new int[]{4, 3, 2, 1});
    }

    public int[] reversePrint(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

}
