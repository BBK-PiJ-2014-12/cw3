
public class FunctionalArrayList extends ArrayList implements FunctionalList{
	@Override
    public ReturnObject head() {
    	ReturnObject result = new ReturnObjectImpl(get(0).getReturnValue()); 
    	return result;
    }
	
	@Override
    public FunctionalList rest() {
    	FunctionalList tail = new FunctionalArrayList(); 
    	for(int i= 1; i < size(); i++) {
    		tail.add(get(i).getReturnValue());
    	}
    	return tail; 
    }
}
