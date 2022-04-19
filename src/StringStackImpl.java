import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringStackImpl implements StringStack{

	int counter;
	List stack;
	StringStackImpl(){
		stack = new List();
		this.counter=0;;
	}
	
	@Override
	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public void push(String item) {
		stack.insertAtFront(item);
		counter++;
		
	}

	@Override
	public String pop() throws NoSuchElementException {
		String removed = null;
		try {
			removed=(String) stack.removeFromFront();
		}
		catch (NoSuchElementException ex)
		{
			throw new NoSuchElementException();
		}
		counter--;
		return removed;
	}

	@Override
	public String peek() throws NoSuchElementException {
		if (stack.isEmpty())
			throw new NoSuchElementException();
		return (String) stack.getFirst();
	}

	public void printStack() {
		
		this.printStack(System.out);
		
	}
	
	@Override
	public void printStack(PrintStream stream) {
		
		stack.print(stream);
		
	}

	@Override
	public int size(){
		return this.counter;
	}

}
