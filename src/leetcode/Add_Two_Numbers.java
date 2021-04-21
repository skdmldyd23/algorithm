package leetcode;

public class Add_Two_Numbers {
	public class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}
	public static void main(String[] args) {
		ListNode ln1_1 = new ListNode(2);
		ListNode ln1_2 = new ListNode(4);
		ListNode ln1_3 = new ListNode(3);
		ListNode ln2_1 = new ListNode(5);
		ListNode ln2_2 = new ListNode(6);
		ListNode ln2_3 = new ListNode(4);
		ln1_1.next = ln1_2;
		ln1_2.next = ln1_3;
		ln2_1.next = ln2_2;
		ln2_2.next = ln2_3;
		Add_Two_Numbers at = new Add_Two_Numbers();
		at.addTwoNumbers(ln1_1, ln1_3);
	}
	private void addTwoNumbers(ListNode ln1_1, ListNode ln1_3) {
		// TODO Auto-generated method stub
		
	}

}
