/**
 * This is only a implementation of basic LinkedList operations
 */
public class MyLinkedList {
	private Node first;
	private int count;
	
	public void clear() {
		this.first=null;
		this.count=0;
	}
	
	public void add(Object e)
	{
		if(first==null)
		{
			first=new Node(e,null);
			count++;
			return;
		}
		Node cur=first;
		while(cur.next!=null)cur=cur.next;
		cur.next=new Node(e,null);
		count++;
	}
	
	public void remove(int index)
	{
		if(index>=count) throw new IndexOutOfBoundsException();
		if(index==0) {
			first=first.next;
			count--;
			return;
		}
		Node cur=first;
		for(int i=1;i<index;i++)
		{
			cur=cur.next;
		}
		cur.next=cur.next.next;
		count--;
	}
	
	public int size()
	{
		return count;
	}
	@Override
	public String toString()
	{
		if(this.first==null)return null;
		String a="["+first.ele;
		Node cur=first.next;
		for(int i=1;i<count;i++)
		{
			a+=", "+cur.ele;
			cur=cur.next;
		}
		return a+"]";
	}
	
	//Class Node
	class Node
	{
		Object ele;
		Node next;
		Node(Object e,Node n)
		{
			ele=e;
			next=n;
		}
	}
}