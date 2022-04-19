import java.io.PrintStream;
import java.util.NoSuchElementException;

public class StringQueueImpl implements StringQueue{

	int counter;
	List queue;
	StringQueueImpl(){
		queue = new List();
		this.counter=0;
	}
	
	@Override
	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public void put(String item) {
		queue.insertAtBack(item);
		counter++;
		
	}

	@Override
	public String get() throws NoSuchElementException {
		String removed;
		try{
			removed=(String) queue.removeFromFront();
		}
		catch(NoSuchElementException e){
			throw new NoSuchElementException();
		}
		counter--;
		return removed;
	}

	@Override
	public String peek() throws NoSuchElementException { 
		if (queue.isEmpty()) {
			throw new NoSuchElementException();
		}
		return (String) queue.getFirst();
	}

	public void printQueue() {
		
		this.printQueue(System.out);
		
	}
	
	@Override
	public void printQueue(PrintStream stream) {
		queue.print(stream);
	}

	@Override
	public int size() {
		return counter;
	}

}
