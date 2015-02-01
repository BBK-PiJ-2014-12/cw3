
public class StackImpl extends AbstractStack {
	
	public StackImpl(List list) {
		super(list);
	}
	
	@Override
	public boolean isEmpty() {
		if(internalList.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public int size() {
		return internalList.size();
	}
	
	@Override
	public void push(Object item) {
		internalList.add(item);
	}
	
	public ReturnObject top() {
		return internalList.get(internalList.size() - 1);
	}
	
	@Override
	public ReturnObject pop() {
		return internalList.remove(internalList.size() - 1);
	}
	
	@Override
	public String toString() {
		return internalList.toString();
	}
}
