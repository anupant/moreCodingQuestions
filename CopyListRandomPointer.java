// Definition for singly-linked list with a random pointer.
class RandomListNode {
	   int label;
	   RandomListNode next, random;
	   RandomListNode(int x) { this.label = x; }
};
// 
public class CopyListRandomPointer {
	
	public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode iter = head;
        RandomListNode next;
	// First round: make copy of each node,
	// and link them together side-by-side in a single list.
	while (iter != null) {
		next = iter.next;
        RandomListNode copy = new RandomListNode(iter.label);
		iter.next = copy;
		copy.next = next;
        iter = next;
	}

	// Second round: assign random pointers for the copy nodes.
	iter = head;
	while (iter != null) {
		if (iter.random != null) {
			iter.next.random = iter.random.next;
		}
		iter = iter.next.next;
	}

	// Third round: restore the original list, and extract the copy list.
	iter = head;
	RandomListNode pseudoHead = new RandomListNode(0);
	RandomListNode copyIter = pseudoHead;

	while (iter != null) {
		next = iter.next.next;
        // extract the copy
		copyIter.next = iter.next;
		copyIter = copyIter.next;
        // restore the original list
		iter.next = next;
        iter = next;
	 }

	return pseudoHead.next;
    }
     

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
