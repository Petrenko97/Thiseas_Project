import java.io.PrintStream;

public class StringQueueWithOnePointer {
	private ListNode firstNode;
	private String name; 
	
	/**
	 * constructor creates empty List with "list" as the name
	 */
	public StringQueueWithOnePointer()
	{
		this("list");
	} 
	
	/**
	 * constructor creates an empty List with a name.
	 * @param listName the list name
	 */
	public StringQueueWithOnePointer( String listName)
	{
		name = listName;
		firstNode = null;
	} 
	
	public void insert( Object insertItem )
	{
		ListNode node = new ListNode( insertItem );
		if ( isEmpty() ){ 
		firstNode = node;
		firstNode.nextNode = node;
		}else { 
			 node.nextNode=firstNode.nextNode;
			 firstNode.nextNode=node;
			 firstNode=node;
			
		}
	} 
	
	public Object remove() throws EmptyListException{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		Object removedItem = firstNode.nextNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if ( firstNode == firstNode.nextNode )
		firstNode=null;
		else
		firstNode.nextNode=firstNode.nextNode.nextNode;

		return removedItem; // return removed node data
	}
	
	public void print() {
		this.print(System.out);
	}
	
	/**
	 * Print the list's contents to 
	 * @param stream
	 */
	public void print(PrintStream stream)
	{
		if ( isEmpty() )
		{
			stream.printf( "Empty %s\n", name );
			return;
		}

		stream.printf( "The %s is: ", name );
		ListNode current = firstNode.nextNode;

		// while not at end of list, output current node's data
		while ( current != firstNode )
		{
			stream.printf( "%s ", current.data );
			current = current.nextNode;
		} // end while
		stream.printf( "%s ", firstNode.data );
		stream.println( "\n" );
	}
	
	public boolean isEmpty()
	{
		return firstNode == null; // return true if List is empty
	}

}
