
public class StackImpl extends AbstractStack {
	
	public StackImpl(List list) {
		//check if list is empty
		super(list);
	}
	
	public boolean isEmpty() {
		if(internalList.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}
	
	public int size() {
		return internalList.size();
	}
	
	public void push(Object item) {
		internalList.add(item);
	}
	
	public ReturnObject top() {
		return internalList.get(internalList.size() - 1);
	}
	
	public ReturnObject pop() {
		return internalList.remove(internalList.size() - 1);
	}
	
	public String toString() {
		return internalList.toString();
	}
}
