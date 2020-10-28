package list;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: iqqcode
 * @Date: 2020-10-17 22:11
 * @Description:删除链表重复节点[无序-有序]
 */

public class AddLinkList {

    public static class Node {

        public int val;
        public Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static Node listGenerator(int length, String[] numbers) {
        Node head = new Node(Integer.parseInt(numbers[0]));
        Node cur = head;
        for (int i = 1; i < length; i++) {
            cur.next = new Node(Integer.parseInt(numbers[i]));
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] numbers = in.nextLine().split(" ");
        Node head = listGenerator(n, numbers);
        printList(head);
    }
}
