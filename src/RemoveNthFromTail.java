
public class RemoveNthFromTail {
	
	private ListNode head;
	
	public RemoveNthFromTail(ListNode head){
		this.head = head;
	}
	
	public ListNode getFirstNode(){
		if(head == null)
			return null;
		return this.head;
	}
	public ListNode GetNextNode(ListNode current){
		if(current == null)
				return null;
		if(current.next == null)
			return null;
		return current.next;
		
	}


	
    public ListNode removeNthFromEnd(ListNode head, int n) {

    	
        ListNode fast = head;
        ListNode slow = head;
        
        for(int i=0;i<n;i++) fast=fast.next;
        if(fast==null) return head.next; 
        
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        
        return head;
        
        
    }

}
