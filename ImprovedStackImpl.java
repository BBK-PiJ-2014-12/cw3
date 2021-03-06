/**
 * A stack with extra methods to reverse the stack or remove objects other than the top one. 
 * 
 * @author Zsolt Balvanyos
 *
 */
public class ImprovedStackImpl implements ImprovedStack{
	private List internalList;
		
    public ImprovedStackImpl(List list) {
	  this.internalList = list;
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
	
	@Override	
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
	
	@Override
 	public ImprovedStack reverse() {
		List reversedList = new LinkedList();
		ImprovedStack reversedStack = new ImprovedStackImpl(reversedList);
		
		for(int i = size() - 1; 0 <= i; i--) {
			reversedStack.push(internalList.get(i).getReturnValue());
		}
		return reversedStack;
	}

 	@Override
	public void remove(Object object) {
 		int endOfList = size();
		for(int i = 0; i < endOfList; i++) {
				if(internalList.get(i).getReturnValue().equals(object)) {
				internalList.remove(i);
				i--;
				endOfList--;
			}
		}
	}
}
