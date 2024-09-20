package Finals;
class Link{
	public Object data;
	public Link next;

	public Link(Object o) {
		this.data = o;
		this.next = null;
	}

	public String toString() {
		return data.toString();
	}
}
class LinkList {
	private Link head;

	public LinkList() {
		head = null;
	}

	public void insertFirst(Object o) {
		Link newLink = new Link(o);
		newLink.next = head;
		head = newLink;
	}

	public Object removeFirst() {
		Object res = head.data;
		head = head.next;
		return res;
	}

	public Object getFirst() {
		return head.data;
	}

	public void insertLast(Object o) {
		Link newLink = new Link(o);
		if (head == null) {
			head = newLink;
			return;
		}
		Link current = head;
		while (current.next != null)
			current = current.next;
		current.next = newLink;
	}

	public Object removeLast() {
		if (head.next == null) {
			Object res = head.data;
			head = null;
			return res;
		}
		Link current = head;
		while (current.next.next != null)
			current = current.next;
		Object res = current.next.data;
		current.next = null;
		return res;
	}

	public Object getLast() {
		Link current = head;
		while (current.next != null)
			current = current.next;
		return current.data;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public String toString() {
		if (head == null)
			return "[ ]";
		String res = "[ " + head.data;
		Link current = head.next;
		while (current != null) {
			res += ", " + current.data;
			current = current.next;
		}
		res += " ]";
		return res;
	}

	/* START OF FINAL PROBLEMS: */
	
	//Exercise 7.2 : Reverse Linked List Internally:
	public void reverse(){
		Link prev = null;
		Link nxt = null;
		Link curr = head;

		while(curr != null){
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}

		head = prev;
	}

	//Exercise 7.4: Remove duplicates from a sorted linked list.
	public void removeDuplicates(){
		Link curr = head;
		while(curr.next != null){
			if(curr.next.next != null && (int) curr.data == (int) curr.next.data){
				curr.next = curr.next.next;
			}
			if(curr.next.next == null && (int) curr.data == (int) curr.next.data){
				curr.next = null;
				break;
			}
			curr = curr.next;
		}
	}

	//Exercise 7.6: Cut List (Divides the list into two halves, puts the second half infront of the first half.)
	public void cutList(){
		Link fast = head;
		Link slow = head;

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		Link midPtr = slow.next;
		slow.next = null;
		
		Link curr = midPtr;
		while(curr.next != null){
			curr = curr.next;
		}

		curr.next = head;
		head = midPtr;

	}

	//Exercise 7.9 : Merge two linked lists:
	public void merge(LinkList l2){
		Link n1 = head;
		Link n2 = l2.head;
		Link dummy = new Link(0);
		Link curr = dummy;

		while(n1 != null && n2 != null){
			if((int) n1.data <= (int) n2.data){
				curr.next = n1;
				n1 = n1.next;
			}else{
				curr.next = n2;
				n2 = n2.next;
			}
			curr = curr.next;
		}

		curr.next = n1 == null ? n2 : n1;
		head = dummy.next;
	}

	//Exercise 8.1:
	public int getCount(){
		int count = 0;
		Link curr = head;

		while(curr != null){
			count++;
			curr = curr.next;
		}

		return count;
	}

	public int countRec(){
		return countRecHelper(head);
	}

	public int countRecHelper(Link n){
		if(n == null) return 0;
		else{
			return 1 + countRecHelper(n.next);
		}
	}

	// Exercise 8.2 : Maximum number in a list.
	public int maxInList(){
		Link curr = head;
		int max = Integer.MIN_VALUE;

		while(curr != null){
			max = Math.max(max, (int) curr.data);
			curr = curr.next;
		}

		return max;
	}

	//Exercise 8.3: Linear search
	public boolean search(int key){
		Link curr = head;
		while(curr != null){
			if((int) curr.data == key){
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public boolean searchRec(int key){
		return searchRec(head, key);
	}

	public boolean searchRec(Link n, int key){
		if(n == null) return false;
		if((int) n.data == key) return true;
		else{
			return searchRec(n.next, key);
		}
	}

	//Exercise 8-4 : Implement a circular singly linked list.
	public class CircularLinkedList{
		Link last;

		public CircularLinkedList(){
			last = null;
		}

		public void insertFirst(Object x){
			if(last == null){
				last = new Link(x);
				return;
			}

			Link n = new Link(x);
			n.next = last.next;
			last.next = n;
		}

		public void insertLast(Object x){
			if(last == null){
				last = new Link(x);
				last.next = new Link(x);
				return;
			}

			Link n = new Link(x);
			n.next = last.next;
			last.next = n;
			last = n;
		}

		public Object removeFirst(){
			Object r = last.next.data;
			last.next = last.next.next;
			return r;
		}

		public Object removeLast(){
			Object tmp = last.data;

			Link curr = last;
			while(curr.next != last){
				curr = curr.next;
			}

			curr.next = curr.next.next;
			last = curr;
			return tmp;
		}
	}

	//Final 2015 : Problem 3 : 
	public void deleteTwoSmallest(){
		if(head == null || head.next == null){
			return;
		}
		int min = (int) head.data + (int) head.next.data;
		int n = 0;
		Link curr = head;
		Link tmp = head;
		while(curr != null && curr.next != null){
			n = (int) curr.data + (int) curr.next.data;
			if(n < min){
				min = n;
				tmp = curr;
			}
			curr = curr.next;
		}
		tmp.data = min;
		if(tmp.next.next == null){
			tmp.next = null;
			return;
		}else if(tmp == head){
			Link nxt = tmp.next.next;
			tmp.next.next = null;
			tmp.next = null;
			head = nxt;			
		}else{
			Link nxt = tmp.next.next;
			Link preTmp = head;

			while(preTmp.next != tmp){
				preTmp = preTmp.next;
			}

			tmp.next.next = null;
			tmp.next = null;
			preTmp.next = nxt;
		}
		Link last = head;

		while(last.next != null){
			last = last.next;
		}

		last.next = tmp;
		
	}
	public LinkList evenOdd(){
		if(head == null || head.next == null){
			head = null;
			return null;
		}
		LinkList l = new LinkList();
		l.head = head.next;
		Link tmp = l.head;
		Link curr = head;
		while(curr.next != null && tmp.next != null){
			curr.next = curr.next.next;
			tmp.next = tmp.next.next;
			curr = curr.next;
			tmp = tmp.next;
		}
		return l;
	}

	public void organize(int k){
		Link curr = head;
		for(int i = 1; i < k; i++){
			curr = curr.next;
		}
		Link nxtHead = curr.next;
		curr.next = null;
		Link slow = new Link(0);
		slow.next = nxtHead;
		Link fast = nxtHead;
		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
		}
		Link preFirst = slow;
		Link postFirst = slow.next;
		preFirst.next = head;
		curr.next = postFirst;
		head = nxtHead;
	}

	public static LinkList weloNeik(String s){
		LinkList l = new LinkList();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			int x = c - '0';
			for(int j = 0; j < x; j++){
				if(l.head == null){
					l.head = new Link(c);
				}else{
					Link n = new Link(c);
					n.next = l.head;
					l.head = n;
				}
			}
		}

		return l;
	}

	public static LinkList commonElements(LinkList l1, LinkList l2){
		LinkList res = new LinkList();
		Link cur1 = l1.head;
		Link cur2 = l2.head;
		Link cur3 = res.head;

		while(cur1 != null && cur2 != null){
			if((int) cur1.data < (int) cur2.data){
				cur1 = cur1.next;
			}else if((int) cur2.data < (int) cur1.data){
				cur2 = cur2.next;
			}else{
				if(res.head == null){
					res.head = new Link(cur1.data);
					cur3 = res.head;
				}else{
					cur3.next = new Link(cur1.data);
					cur3 = cur3.next;
				}
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
		}
		return res;
	}

	public void reverseK(int k){
		head = reverseK(k, head);
	}

	public Link reverseK(int k, Link curr){
		if(curr == null) return curr;
		int count = 0, x = 0;
		Link curCount = curr;
		while(curCount != null){
			curCount = curCount.next;
			x++;
		}
		if(x < k) return curr;
		Link cur = curr;
		Link prev = null;
		Link nxt = null;

		while(count < k && cur != null){
			nxt = cur.next;
			cur.next = prev;
			prev = cur;
			cur = nxt;
			count++;
		}

		if(nxt != null){
			curr.next = reverseK(k, nxt);
		}

		return prev;
	}

	public void removeInRange(int lo, int hi){
		while((int) head.data < lo || (int) head.data > hi){
			head = head.next;
		}
		Link curr = head;
		while(curr.next != null){
			if((int) curr.next.data < lo || (int) curr.next.data > hi){
				curr.next = curr.next.next;
			}else{
				curr = curr.next;
			}
		}
	}

	public static void main(String[] args) {
		LinkList l1 = new LinkList();
		l1.insertLast(5);
		l1.insertLast(12);
		l1.insertLast(6);
		l1.insertLast(3);
		l1.insertLast(9);
		l1.insertLast(0);
		l1.insertLast(2);
		
	
		l1.removeInRange(3, 6);

		System.out.println(l1);
	}
}


