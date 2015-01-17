
public class ArrayList implements List{
	private static final int EMPTY_STRUCTURE = 1;
	private static final int INDEX_OUT_OF_BOUNDS = 2;
	private static final int INVALID_ARGUMENT = 3;
	private int Storage = 3;
	private int lastElement = 0;
	private ReturnObjectImpl[] arrayList = new ReturnObjectImpl[Storage];
	
	ErrorObject errObj = new ErrorObject();
	
	public int getLastElement() {
		return lastElement;
	}
	
	public boolean isEmpty() {
		if(arrayList[0] == null) {
			return true;
		}else{
			return false;
		}
	}
	public int getStorage() {
		return arrayList.length;
	}
	public int size() {
		return lastElement + 1;
	}

	public ReturnObject get(int index) {
		if(isEmpty()) {
			return errObj.createErrorObject(EMPTY_STRUCTURE);
		}else if(0 <= index && index <= lastElement) {
			return arrayList[index];
		}else{
			return errObj.createErrorObject(INDEX_OUT_OF_BOUNDS);
		}
	}

	public ReturnObject remove(int index) {
		ReturnObjectImpl result = arrayList[index];
		
		if(isEmpty()){
			return errObj.createErrorObject(EMPTY_STRUCTURE);
		}else if(index < 0 || lastElement < index) {
			return errObj.createErrorObject(INDEX_OUT_OF_BOUNDS);
		}else if(index == 0 && size() == 1) {
			arrayList[0] = null;
			return result;
		}else{
			if(index != lastElement) {
				for(int i = index; i <= lastElement; i++) {
					arrayList[i] = arrayList[i + 1]; 
				}
			}
			lastElement--;
			if(lastElement + 2 < Storage/2) {	//The + 2 is a buffer
				collapseArray();
			}
			return result;
		}
	}
	
	public ReturnObject add(int index, Object item) {
		if(index < 0 || lastElement + 1 < index) {
			return errObj.createErrorObject(INDEX_OUT_OF_BOUNDS);
		}else if(item == null){
			return errObj.createErrorObject(INVALID_ARGUMENT);
		}else{
			ReturnObjectImpl newItem = new ReturnObjectImpl(item);
			
			if(lastElement + 1 == Storage) {
				expandArray();
			}
			if(index == lastElement + 1) {
				arrayList[index] = newItem;
			}else{
				for(int i = lastElement; index <= i ; i--) {
					arrayList[i + 1] = arrayList[i];
				}
				arrayList[index] = newItem;
			}
			if(!isEmpty()) {
				lastElement++;
			}
			return new ReturnObjectImpl();
		}
	}

	public ReturnObject add(Object item) {
		if(item == null){
			return errObj.createErrorObject(INVALID_ARGUMENT);
		}else{
			ReturnObjectImpl newItem = new ReturnObjectImpl(item);
			
			if(lastElement + 1 == Storage) {
				expandArray();
			}
			if(!isEmpty()) {
				lastElement++;
			}
			arrayList[lastElement] = newItem;
			
			return new ReturnObjectImpl();
		}
	}
	
	public void expandArray() {
		ReturnObjectImpl[] tempArray = new ReturnObjectImpl[Storage * 2];
		for(int i = 0; i < Storage; i++) {
			tempArray[i] = arrayList[i];
		}
		arrayList = tempArray;
		Storage = Storage * 2;
	}
	
	public void collapseArray() {
		ReturnObjectImpl[] tempArray = new ReturnObjectImpl[Storage / 2];
		for(int i = 0; i < Storage/2; i++) {
			tempArray[i] = arrayList[i];
		}
		arrayList = tempArray;
		Storage = Storage / 2;		
	}
	
	public String toString() {
		String result = "";
		if(isEmpty()){
			result = result + errObj.createErrorObject(EMPTY_STRUCTURE).getReturnValue();
		}else{
			for(int i = 0; i <= lastElement; i++) {
				result = result + arrayList[i].getReturnValue() + " ";
			}
		}
		return result; 
	}
}
