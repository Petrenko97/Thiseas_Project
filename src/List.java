import java.io.PrintStream;

/**
 * Single-link List. Uses {@link ListNode} for list nodes.
 */
public class List
{
	private ListNode firstNode;
	private ListNode lastNode;
	private String name; // string like "list" used in printing
	
	/**
	 * constructor creates empty List with "list" as the name
	 */
	public List()
	{
		this("list");
	} 
	
	/**
	 * constructor creates an empty List with a name.
	 * @param listName the list name
	 */
	public List( String listName)
	{
		name = listName;
		firstNode = lastNode = null;
	} 

	/**
	 * Inserts an element at the front of the list
	 * @param insertItem the inserted data
	 */
	public void insertAtFront( Object insertItem )
	{
		ListNode node = new ListNode( insertItem );
		if ( isEmpty() ) // firstNode and lastNode refer to same object
		firstNode = lastNode = node;
		else { // firstNode refers to new node
			node.nextNode = firstNode;
			firstNode = node;
			//you can replace the two previous lines with this line: firstNode = new ListNode( insertItem, firstNode );
		}
	} 

	/**
	 * Inserts an element at the end of the list
	 * @param insertItem the inserted item
	 */
	

	
	
	public void insertAtBack( Object insertItem )
	{
		ListNode node = new ListNode( insertItem );
		if ( isEmpty() ) // firstNode and lastNode refer to same Object
		firstNode = lastNode = node;
		else { // lastNode's nextNode refers to new node
			lastNode.nextNode = node;
			lastNode = node;
			//you can replace the two previous lines with this line: lastNode = lastNode.nextNode = new ListNode( insertItem );
		}
	} 

	/**
	 * Returns and removes the data from the list head
	 * @return the data contained in the list head
	 * @throws EmptyListException if the list is empty
	 */
	public Object removeFromFront() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		Object removedItem = firstNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if ( firstNode == lastNode )
		firstNode = lastNode = null;
		else
		firstNode = firstNode.nextNode;

		return removedItem; // return removed node data
	} 

	/**
	 * Returns and removes the data from the list tail
	 * @return the data contained in the list tail
	 * @throws EmptyListException if the list is empty
	 */
	public Object removeFromBack() throws EmptyListException
	{
		if ( isEmpty() ) // throw exception if List is empty
		throw new EmptyListException( name );

		Object removedItem = lastNode.data; // retrieve data being removed

		// update references firstNode and lastNode
		if ( firstNode == lastNode )
		firstNode = lastNode = null;
		else // locate new last node
		{
			ListNode current = firstNode;

			// loop while current node does not refer to lastNode
			while ( current.nextNode != lastNode )
			current = current.nextNode;

			lastNode = current; // current is new lastNode
			current.nextNode = null;
		} // end else

		return removedItem; // return removed node data
	} // end method removeFromBack

	/**
	 * Determine whether list is empty
	 * @return true if list is empty
	 */
	public boolean isEmpty()
	{
		return firstNode == null; // return true if List is empty
	} // end method isEmpty

	/**
	 * Prints the list's contents to System.out
	 */
	
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
		} // end if

		stream.printf( "The %s is: ", name );
		ListNode current = firstNode;

		// while not at end of list, output current node's data
		while ( current != null )
		{
			stream.printf( "%s ", current.data );
			current = current.nextNode;
		} // end while

		stream.println( "\n" );
	}
	
	public Object getFirst() {
		return this.firstNode;
	}
	
	public Object getLast() {
		return this.lastNode;
	}
} 
