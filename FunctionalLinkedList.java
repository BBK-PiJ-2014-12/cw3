
public class FunctionalLinkedList extends LinkedList implements FunctionalList{
    @Override
	public ReturnObject head() {
    	ReturnObject result = new ReturnObjectImpl(get(0).getReturnValue()); 
    	return result;
    }
    
    @Override
    public FunctionalList rest() {
    	FunctionalList tail = new FunctionalLinkedList(); 
    	for(int i= 1; i < size(); i++) {
    		tail.add(get(i).getReturnValue());
    	}
    	return tail; 
    }
}
