class Link
{
	public Object data;
	public Link next;
	public Link previous;
	
	public Link(Object o)   
    {
    	data = o;
    } 
	
	public String toString() {
		return data.toString();
	}
}

public class DoublyLinkedList
{
	private Link first; // reference to first link on list
	private Link last; // reference to first link on list
	
	public DoublyLinkedList()
	{
		first = null;
		last = null;
	}
	public boolean isEmpty()
	{
		return (first == null);
	}
	
	public void insertFirst(Object d)
	{
		Link newLink = new Link(d);
		if( isEmpty() ) { 
			last = newLink;
		} else {
			first.previous = newLink;
		}
		newLink.next = first;
		first = newLink; 
	}
	
	public void insertLast(Object d)
	{
		Link newLink = new Link(d);
		if( isEmpty() ) 
			first = newLink; 
		else
		{
			last.next = newLink;
			newLink.previous = last; 
		}
		last = newLink;
	}
	
	public Object removeFirst() 
	{ 
		Object temp = first.data;
		if(first.next == null)
			last = null; 
		else
			first.next.previous = null; 
		first = first.next;
		return temp;
	}
	
	public Object removeLast()
	{ 
		Object temp = last.data;
		if(first.next == null)
			first = null;
		else
			last.previous.next = null; 
		last = last.previous; 
		return temp;
	}
	public Object getFirst()
	{
		return first.data;
	}
	public Object getLast()
	{
		return last.data;
	}
	public void displayForward()
	{
		System.out.print("[ ");
		Link current = first; 
		while(current != null) 
		{
		System.out.print(current + " ");
		current = current.next; 
		}
		System.out.println("]");
	}	
	
	public void displayBackward()
	{
		System.out.print("[ ");
		Link current = last; 
		while(current != null)
		{
			System.out.print(current + " "); 
			current = current.previous; 
		}
		System.out.println("]");
	}
	
	public boolean insertAfter(Object key, Object dd){
		Link x = new Link(dd);
		Link curr = first;

		while(curr != null){
			if(curr.data.equals(key)){

				if(curr.next == null){
					curr.next = x;
					x.previous = curr;
				}else{
					Link y = curr.next;
					curr.next = x;
					x.previous = curr;
					x.next = y;
				}

				return true;
			}
			curr = curr.next;
		}

		return false;
	}

	public void insertToSorted(Comparable c){
		Link x = new Link(c);
		Link curr = first;
		if(curr == null){
			curr = x;
			first = curr;
			last = curr;
		} 

		while(curr != null){
			if(((Comparable) curr.data).compareTo(c) < 0 
			&& curr.next != null && ((Comparable) curr.next.data).compareTo(c) >= 0 ){
				Link y = curr.next;
				curr.next = x;
				x.previous = curr;
				x.next = y;	
			}

			if(curr.next == null && ((Comparable) curr.data).compareTo(c) < 0 ){
				curr.next = x;
				x.previous = curr;
				last = x;
				return;
			}

			curr = curr.next;
		}
	}

	public void insertionSort(){
		DoublyLinkedList tmp = new DoublyLinkedList();
		Link curr = first;

		while(curr != null){
			tmp.insertToSorted((Comparable) curr.data);
			curr = curr.next;
		}

		this.first = tmp.first;
		this.last = tmp.last;
	}

	public static void main(String[] args) {
		DoublyLinkedList list = new DoublyLinkedList();
		list.insertLast(10);
		list.insertLast(5);
		list.insertLast(3);
		list.insertLast(17);
		list.insertLast(20);

		list.insertionSort();


			
		list.displayForward();
		

	}
	
	
	
	
}