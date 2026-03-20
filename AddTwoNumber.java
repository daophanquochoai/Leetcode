class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class AddTwoNumber {
    int length(ListNode head) {
        int count = 0;
        while ( head != null ) {
            count++;
            head = head.next;
        }
        return count;
    }

    void padNode(ListNode head, int pad) {
        ListNode curr = head;
        while ( curr.next != null ) {
            curr = curr.next;
        }
        for ( int i = 0 ; i < pad ; i++ ) {
            curr.next = new ListNode(0);
            head = curr.next;
        }
    }

    void display(ListNode head) {
        while ( head != null ) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    void add(ListNode l1, ListNode l2) {
        int n1 = length(l1);
        int n2 = length(l2);
        if ( n1 < n2 ) {
            padNode(l1, n2 - n1);
        } else if ( n2 < n1 ) {
            padNode(l2, n1 - n2);
        }

        int sum = 0;
        int carry = 0;
        while( l1 != null ){
            sum = l1.val + l2.val + carry;
            carry = sum / 10;
            l1.val = sum % 10;
            l1 = l1.next;
            l2 = l2.next;
        }
         if ( carry > 0 ) {
             ListNode newNode = new ListNode(carry);
             newNode.next = l1;
             l1 = newNode;
        }
    }
}
