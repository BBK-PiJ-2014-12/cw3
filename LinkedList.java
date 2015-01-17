
public class LinkedList implements List{
	private static final int EMPTY_STRUCTURE = 1;
	private static final int INDEX_OUT_OF_BOUNDS = 2;
	private static final int INVALID_ARGUMENT = 3; 
	private ReturnObjectImpl entryPoint = null;
	private static int size = 0;
	
	ErrorObject errObj = new ErrorObject();
	
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
			return errObj.createErrorObject(EMPTY_STRUCTURE);
		}else if(!(0 <= index && index < size)) {
			return errObj.createErrorObject(INDEX_OUT_OF_BOUNDS);
		}else{
			while(index != counter) {
				p = p.getNext();
				counter++;
			}
			return p;
		}
	}
	
	@Override
	public ReturnObject remove(int index) {
		ReturnObjectImpl p;
		ReturnObjectImpl result; 
		
		if(isEmpty()){
			return errObj.createErrorObject(EMPTY_STRUCTURE);
		}else if(index == 0){
			p = entryPoint;
			entryPoint = p.getNext();
			size--;
			return p;
		}else if(index == size - 1) {
			int counter = 0;
			p = entryPoint;
			while(counter != size - 2) {
				p = p.getNext();
				counter++;
			}
			result = p.getNext();
			p.setNext(null);
			size--;
			return result;
		}else if(0 < index && index < size - 2) {
			int counter = 0;
			p = entryPoint;
			result = null;
			while(counter != index - 1) {
				p = p.getNext();
				counter++;
			}
			result = p.getNext();
			p.setNext(p.getNext().getNext());
			size--;
			return result; 
		}else{
			return errObj.createErrorObject(INDEX_OUT_OF_BOUNDS);
		}
	}

	@Override
	public ReturnObject add(int index, Object item) {
		if(item == null){
			return errObj.createErrorObject(INVALID_ARGUMENT);
		}else if(isEmpty() && index != 0) {
			return errObj.createErrorObject(EMPTY_STRUCTURE);
		}else if(index == 0 && isEmpty()){
			entryPoint = new ReturnObjectImpl(item);
			size++;
			return new ReturnObjectImpl();	
		}else if(index == 0 && !isEmpty()) {
			ReturnObjectImpl p = entryPoint;
			entryPoint = new ReturnObjectImpl(item);
			entryPoint.setNext(p);
			return new ReturnObjectImpl();
		}else if(!(0 <= index && index <= size)) {
			return errObj.createErrorObject(INDEX_OUT_OF_BOUNDS);
		}else if(index == size) {
			return add(item);
		}else{
			int counter = 1;
			ReturnObjectImpl p = entryPoint;
			while(counter != index) {
				p = p.getNext();
				counter++;
			}
			ReturnObjectImpl newObj = new ReturnObjectImpl(item);
			newObj.setNext(p.getNext());
			p.setNext(newObj);
			size++;
			return new ReturnObjectImpl();
		}	
	}
	
	@Override 
	public ReturnObject add(Object item) {
		 if(item == null){
			return errObj.createErrorObject(INVALID_ARGUMENT);
		 }else if(isEmpty()) {
			entryPoint = new ReturnObjectImpl(item);
			size++;
			return new ReturnObjectImpl();
		}else{
			ReturnObjectImpl p = entryPoint;
			while(p.getNext() != null) {
				p = p.getNext();
			}	
			p.setNext(new ReturnObjectImpl(item));
			size++;
			return new ReturnObjectImpl();
		}	
	}
	
	/*private ReturnObject createErrorObject(int errorNumber) {
		ReturnObjectImpl errMes = new ReturnObjectImpl("");
		errMes.setErrorNum(errorNumber);
		errMes.setItem(errMes.getError());
		return errMes;	
	}*/
	
	public String toString() {
		String result = "";
		if(isEmpty()){
			result = result + errObj.createErrorObject(EMPTY_STRUCTURE).getReturnValue();
		}else{
			ReturnObjectImpl p = entryPoint;
			result = "" + p.getReturnValue();
			while(p.getNext() != null) {
				p = p.getNext();
				result = result + " " + p.getReturnValue();
			}
		}
		return result; 
	}
}