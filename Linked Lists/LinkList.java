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
	
	public void reverseList(){
		Link curr = head;
		Link previous = null;
		Link next = null;

		while(curr != null){
			next = curr.next;
			curr.next = previous;
			previous = curr;
			curr = next;
		}

		head = previous;
	}

	public void cutList(){
		if(head==null) return;

		Link cur = head;
		Link slow = head;
		Link fast = head;
		Link last = head;

		while(last.next != null){
			last = last.next;
		}

		while(fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}

		Link fin = slow.next;
		slow.next = null;
		last.next = cur;
		head = fin;

	}
	
	public void merge(LinkList l2){
		Link dummyNode = new Link(0);
    	Link currNode = dummyNode;

		Link x = this.head;
		Link y = l2.head;

    	while(x != null && y != null){
      		if((Integer) x.data < (Integer) y.data){
        		currNode.next = x;
        		x = x.next;
      		}else{
        		currNode.next = y;
        		y = y.next;
      		}

      		currNode = currNode.next;
    	}

    	if(x != null){
      		currNode.next = x;
      		x = x.next;
    	}

    	if(y != null){
      		currNode.next = y;
      		y = y.next;
    	}

    	head = dummyNode.next;
	}

	public class Link{
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
		l.insertLast(3);
		l.insertLast(5);
		l.insertLast(6);
		l.insertLast(7);
		
		LinkList l2 = new LinkList();
		l2.insertLast(2);
		l2.insertLast(4);

		l.merge(l2);

		System.out.println(l);
	}
	
}
