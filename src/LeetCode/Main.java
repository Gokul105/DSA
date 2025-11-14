package LeetCode;

import java.util.*;

// Definition for singly-linked list
class ListNode {
    int value;
    ListNode next;

    ListNode() {
    }

    ListNode(int value) {
        this.value = value;
    }

    ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        List<ListNode> arrayList = new ArrayList<>(Arrays.asList(lists));

        while (arrayList.size() > 1)
        {
            List<ListNode> mergedList = new ArrayList<>();

            for (int i = 0; i < arrayList.size(); i += 2) {
                ListNode list1 = arrayList.get(i);
                ListNode list2 = (i + 1 < arrayList.size()) ? arrayList.get(i + 1) : null;
                mergedList.add(mergeTwoList(list1, list2));
            }
            arrayList = mergedList;
        }
        return arrayList.get(0);
    }

    public ListNode mergeTwoList(ListNode list1, ListNode list2) {
        var dummy = new ListNode(0);
        var current = dummy;
        while (list1 != null && list2 != null) {
            if (list1.value <= list2.value) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;

        }
        current.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }
}

public class Main {
    public static void main(String[] args) {
        // ✅ Create test linked lists
        ListNode list1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode list3 = new ListNode(2, new ListNode(6));

        // ✅ Add them to an array
        ListNode[] lists = {list1, list2, list3};

        // ✅ Call mergeKLists
        Solution sol = new Solution();
        var merged = sol.mergeKLists(lists);

        // ✅ Print the merged list
        printList(merged);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head = head.next;
        }
        System.out.println();
    }
}
