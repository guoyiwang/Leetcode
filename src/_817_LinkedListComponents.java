public class _817_LinkedListComponents {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public int numComponents(ListNode head, int[] G){
        int count = 0;
        while(head != null){
            if(searchForValue(head.val, G) && (head.next != null || !searchForValue(head.next.val, G))){
                count++;
            }
            head = head.next;
        }
        return count;
    }
    private boolean searchForValue(int val, int[] vals){
        for(int i = 0; i < vals.length;i++){
            if(val == vals[i]){
                return true;
            }
        }
        return false;
    }
}
