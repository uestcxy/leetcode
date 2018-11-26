import java.util.List;

/**
 * Created by xiayuan on 2018/5/15.
 */
public class Solution {
    /**
     * 合并两个有序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result = l1;
                result.next = l2;
                l1 = l1.next;
                result = result.next;
            } else {
                result = l2;
                result.next = l1;
                l2 = l2.next;
                result = result.next;
            }
        }
        return result;
    }

    /**
     * 两数相加
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return null;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode listNode = mergeTwoLists(l1, l2);
        System.out.println(listNode);

    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // TODO: 2018/5/15 还没看懂
        ListNode current = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = current;
            current = temp;
        }
        return current;
    }

    /**
     * 删除倒数第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int num = 0;
        int number = 0;
        ListNode current = head;
        while (current != null) {
            num++;
            current = current.next;

        }
        current = head;
        while (current != null) {
            number++;
            if (number == num - n) {
                current.next = current.next.next;
            } else if (num - n == 0) {
                return head.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    /**
     * 删除节点
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            return;
        }
        //1 -> 2 -> 3 -> 4
        //1->3->3->4
        //1->3->4
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
