public class LinkedList implements List{
	
	private ReturnObjectImpl entryPoint = null;
	private static int size = 0;
	
	@Override
	public boolean isEmpty() {
		if(entryPoint==null) {
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public int size() {
		return size;
	}
	
	
	@Override
	public ReturnObject get(int index) {
		int counter = 0;
		ReturnObjectImpl p = entryPoint;
		if(isEmpty()) {
			return createErrorObject(1);
		}else if(!(0 < index && index < size)) {
			return createErrorObject(2);
		}else{
			while(index != counter) {
				p = (ReturnObjectImpl) p.getNext();
			}
			return p;
		}
	}
	
	@Override  // NOT READY!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	public ReturnObject remove(int index) {
		return new ReturnObjectImpl();
	}

	@Override  // NOT READY!!!!!!!!!!!!!!!!!!!!!!!!!
	public ReturnObject add(int index, Object item) {
		return new ReturnObjectImpl();	
	}
	
	@Override 
	public ReturnObject add(Object item) {
		if(isEmpty()) {
			entryPoint = new ReturnObjectImpl(item);
			return new ReturnObjectImpl();
		}else if(item == null){
			return createErrorObject(3);
		}else{
			ReturnObjectImpl p = entryPoint;
			while(p.getNext() != null) {
				p = p.getNext();
			}	
			p.setNext(new ReturnObjectImpl(item));
			return new ReturnObjectImpl();
		}	
	}
	
	private ReturnObject createErrorObject(int errorNumber) {
		ReturnObjectImpl errMes = new ReturnObjectImpl("");
		errMes.setErrorNum(errorNumber);
		errMes.setItem(errMes.getError());
		return errMes;	
	}
	
	public String toString() {
		String result = "";
		if(isEmpty()){
			result = result + createErrorObject(1).getReturnValue();
		}else{
			ReturnObjectImpl p = entryPoint;
			while(p.getNext() != null) {
				result = result + " " + p.getReturnValue();
			}
		}
		return result; 
	}
}