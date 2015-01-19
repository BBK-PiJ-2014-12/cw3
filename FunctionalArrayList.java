
public class FunctionalArrayList extends ArrayList implements FunctionalList{
    public ReturnObject head() {
    	ReturnObject result = new ReturnObjectImpl(get(0).getReturnValue()); 
    	return result;
    }

    public FunctionalList rest() {
    	FunctionalList tail = new FunctionalLinkedList(); 
    	for(int i= 1; i < size(); i++) {
    		tail.add(get(i).getReturnValue());
    	}
    	return tail; 
    }
}
