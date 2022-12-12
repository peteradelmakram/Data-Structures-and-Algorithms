public class LinkList {
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

	public void reverseList() {
		Link nxt = null;
		Link prev = null;
		Link curr = head;

		while (curr != null) {
			nxt = curr.next;
			curr.next = prev;

			prev = curr;
			curr = nxt;
		}

		head = prev;
	}

	public void cutList() {
		Link dummy = new Link(0);
		dummy.next = head;

		Link slow = dummy;
		Link fast = head;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		Link second = slow.next;
		slow.next = null;

		Link curr = second;

		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = head;
		head = second;
	}

	public void merge(LinkList l2) {
		Link dummyNode = new Link(0);
		Link currNode = dummyNode;

		Link x = this.head;
		Link y = l2.head;

		while (x != null && y != null) {
			if ((Integer) x.data < (Integer) y.data) {
				currNode.next = x;
				x = x.next;
			} else {
				currNode.next = y;
				y = y.next;
			}

			currNode = currNode.next;
		}

		if (x != null) {
			currNode.next = x;
			x = x.next;
		}

		if (y != null) {
			currNode.next = y;
			y = y.next;
		}

		head = dummyNode.next;
	}

	public void insertLastRecursive(Object o) {
		Link x = new Link(o);
		Link curr = head;
		insertLastRecursiveHelper(x, curr);
	}

	public void insertLastRecursiveHelper(Link o, Link curr) {
		if (curr.next == null) {
			curr.next = o;
			return;
		}

		insertLastRecursiveHelper(o, curr.next);
	}

	public void removeDuplicates() {
		Link curr = head;

		while (curr != null) {
			Link tmp = curr;

			while (tmp != null && tmp.data == curr.data) {
				tmp = tmp.next;
			}

			curr.next = tmp;
			curr = curr.next;
		}
	}

	public void mixListInternal() {
		Link slow = head;
		Link fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Link second = slow.next;
		slow.next = null;

		Link curr = second;
		Link prev = null;
		Link nxt = null;

		while (curr != null) {
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}

		second = prev;
		Link first = head;

		while (first != null && second != null) {
			Link tmpFirst = first.next;
			Link tmpSecond = second.next;

			first.next = second;
			second.next = tmpFirst;

			first = tmpFirst;
			second = tmpSecond;
		}
	}

	public static boolean equals(Link head1, Link head2) {
		Link curr1 = head1;
		Link curr2 = head2;

		while (curr1 != null && curr2 != null) {
			if (!(curr1.data.equals(curr2.data))) {
				return false;
			}

			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		return true;
	}

	public void compress() {
		Link curr = head;

		while (curr != null) {

			Link tmp = head.next;
			Link prev = head;

			while (tmp != null) {
				if (tmp.data.equals(curr.data) && tmp != curr) {
					prev.next = tmp.next;
				} else {
					prev = tmp;
				}
				tmp = tmp.next;
			}

			curr = curr.next;
		}
	}

	public void triplicate() {
		Link curr = head;

		while (curr != null) {
			Link nxt = curr.next;
			curr.next = null;
			Link tmp = curr;

			for (int i = 0; i < 2; i++) {
				tmp.next = new Link(curr.data);
				tmp = tmp.next;
			}
 
			tmp.next = nxt;
			curr = nxt;
		}
	}

	public int specialDifference(int n) {
		Link curr = head;
		int op2 = 0;

		for (int i = 0; i < n; i++) {
			op2 += (int) curr.data;
			curr = curr.next;
		}

		curr = curr.next;

		int op1 = 0;
		while (curr != null) {
			op1 += (int) curr.data;
			curr = curr.next;
		}

		return op1 - op2;
	}

	public void insertDescendingOrder(int val) {
		Link o = new Link(val);

		if (head == null) {
			head = o;
			return;
		}
		if (val > (int) head.data) {
			o.next = head;
			head = o;
			return;
		}

		Link curr = head;

		while (curr != null) {
			if ((int) curr.data > val && curr.next != null && (int) curr.next.data < val) {
				Link nxt = curr.next;
				curr.next = o;
				o.next = nxt;
				break;
			}
			if ((int) curr.data > val && curr.next == null) {
				curr.next = o;
				break;
			}
			curr = curr.next;
		}

	}

	//Returns a new list with values of linked list multiplied from curr to end.
	public LinkList multTillEnd() {
		LinkList res = new LinkList();
		Link curr1 = head;
		Link curr3 = null;

		while (curr1 != null) {
			int prod = 1;
			Link curr2 = curr1.next;

			while (curr2 != null) {
				prod *= (int) curr2.data;
				curr2 = curr2.next;
			}

			Link add = new Link(prod);

			if (res.head == null) {
				res.head = add;
				curr3 = res.head;
			} else {
				curr3.next = add;
				curr3 = curr3.next;
			}

			curr1 = curr1.next;
		}

		return res;
	}

	//Returns true if two values perceding each other subtracted are equal to n
	public boolean subsetDifference(int n) {
		Link curr1 = head;

		while (curr1 != null) {
			Link curr2 = curr1.next;

			while (curr2 != null) {
				if (((int) curr1.data - (int) curr2.data == n)) {
					return true;
				}

				curr2 = curr2.next;
			}
			curr1 = curr1.next;
		}

		return false;
	}

	//Deletes even indices in a list
	public void deleteEvenPosition() {

		if (head == null)
			return;
		head = head.next;
		Link curr = head;

		while (curr != null) {
			if (curr.next != null) {
				if (curr.next.next != null) {
					Link nxt = curr.next.next;
					curr.next = nxt;
				} else {
					curr.next = null;
				}
			}
			curr = curr.next;
		}
	}

	//Removes all duplicate values exisiting in a list.
	public LinkList extractNonDuplicates() {
		LinkList res = new LinkList();
		Link curr = head;
		Link currRes = null;

		while (curr != null) {
			Link tmp = curr;
			Link x = null;

			while (tmp != null && curr.data == tmp.data) {
				tmp = tmp.next;
			}

			if (tmp == null) {
				break;
			} else {
				x = new Link(tmp.data);
			}

			if (res.head == null) {
				res.head = x;
				currRes = res.head;
			} else {
				currRes.next = x;
				currRes = currRes.next;
			}
			curr = tmp;
		}
		return res;

	}

	//Pushes even values in the linked list so that they appear after odd values in the list.
	public void pushEven() {
		Link current = head;
		Link evenHead = null, oddHead = null, evenTail = null, oddTail = null;
		while (current != null) {
			if ((int) current.data % 2 != 0) {
				if (oddHead == null) {
					oddTail = current;
					oddHead = oddTail;
				} else {
					oddTail.next = current;
					oddTail = oddTail.next;
				}
			} else {
				if (evenHead == null) {
					evenTail = current;
					evenHead = evenTail;
				} else {
					evenTail.next = current;
					evenTail = evenTail.next;
				}
			}
			current = current.next;
		}
		oddTail.next = evenHead;
		evenTail.next = null;
		head = oddHead;
	}

	// if Link List is 1 -> 2 -> 3 return 1 -> 2 -> 3 -> 3 -> 2 -> 1
	public void mirror(){
		Link tmp = head, curr = head;

		while(tmp.next != null){
			tmp = tmp.next;
		}

		Link mirrorHead = null;

		while(curr != null){
			if(mirrorHead == null){
				mirrorHead = new Link (curr.data);
			}else{
				Link x = new Link(curr.data);
				x.next = mirrorHead;
				mirrorHead = x;
			}
			curr = curr.next;
		}
		tmp.next = mirrorHead;
	}

	//reverse every 2 numbers.
	public LinkList shuffle(){

		if(head == null || head.next == null){
			return this;
		}
		Link newHead = null, newTail = null;
		Link curr = head;

		while(curr != null){
			if(newHead == null){
				newHead = new Link(curr.next.data);
				newTail = new Link(curr.data);
				newHead.next = newTail;
			}else{
				if(curr.next != null){
					newTail.next = new Link (curr.next.data);
					newTail.next.next = new Link(curr.data);
					newTail = newTail.next.next;
				}else{
					newTail.next = new Link(curr.data);
				}
			}
			if(curr.next != null){
				curr = curr.next.next;
			}else{
				curr = curr.next;
			}			
		}
		LinkList result = new LinkList();
		result.head = newHead;
		return result;
	}

	public void swap(int n, int m){
		if(n == m) return;		
		Link Nl = head, preNl = head;
		for(int i = 0; i < n; i++){
			preNl = Nl;
			Nl = Nl.next;
		}
		Link Ml = head, preMl = head;
		for(int i = 0; i < m; i++){
			preMl = Ml;
			Ml = Ml.next;
		}
		Link tmp = Ml.next;
		if(n == 0){
			head = Ml;
			if(m == 1){
				Ml.next = Nl;
				Nl.next = tmp;
				return;
			}
			Ml.next = Nl.next;
			preMl.next = Nl;
			Nl.next = tmp;
		}else if(m == 0){
			head = Nl;
			if(n == 1){
				tmp = Nl.next;
				Nl.next = Ml;
				Ml.next = tmp;
				return;
			}
			preMl.next = Nl.next;
			Nl.next = preNl;
			preNl.next = Ml;
		}else{
			preNl.next = Ml;
			Ml.next = preMl;
			preMl.next = Nl;
			Nl.next = tmp;
		}
	}

	public class Link {
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

	public static void main(String[] args) {
		LinkList l = new LinkList();
		l.insertLast(1);
		l.insertLast(2);
		l.insertLast(3);
		l.insertLast(4);
		l.insertLast(5);
		l.swap(0,4);
		System.out.println(l);

	}
}
