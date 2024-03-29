
   class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)
        return head;
        ListNode prev=null;
        ListNode current = head;
        ListNode nextNode=null;
        if(current!=null)
         nextNode=current.next;

        while(current!=null)
        {
            current.next=prev;
            prev=current;
            current=nextNode;

            if(nextNode!=null)
            nextNode=nextNode.next;

            
        }

        return prev;
        
    }
}