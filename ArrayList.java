/**
 * A array list of ReturnObjects. 
 * 
 * @author Zsolt Balvanyos
 *
 */
public class ArrayList implements List{
	private int Storage = 10;
	private int lastElement = 0;
	private ReturnObjectImpl[] arrayList = new ReturnObjectImpl[Storage];
	
	@Override
	public boolean isEmpty() {
		if(arrayList[0] == null) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Returns the current size of the array containing the list
	 * 
	 * @return the current size of the array
	 */
	public int getStorage() {
		return arrayList.length;
	}
	
	/**
	 * Returns the current size of the list containing the list
	 * 
	 * @return the current size of the list
	 */
	public int size() {
		return lastElement + 1;
	}
	
	/**
	 * Returns lastElement which is a pointer to indicate the end of the list in the array. 
	 * 
	 * @return lastElement
	 */
	public int getLastElement() {
		return lastElement;
	}
	
	@Override
	public ReturnObject get(int index) {
		if(isEmpty()) {
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}else if(0 <= index && index <= lastElement) {
			return arrayList[index];
		}else{
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}
	}

	@Override
	public ReturnObject remove(int index) {
		ReturnObjectImpl result = arrayList[index];
		
		if(isEmpty()){
			return new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE);
		}else if(index < 0 || lastElement < index) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
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
	
	@Override
	public ReturnObject add(int index, Object item) {
		if(index < 0 || lastElement + 1 < index) {
			return new ReturnObjectImpl(ErrorMessage.INDEX_OUT_OF_BOUNDS);
		}else if(item == null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
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

	@Override
	public ReturnObject add(Object item) {
		if(item == null){
			return new ReturnObjectImpl(ErrorMessage.INVALID_ARGUMENT);
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
	
	/**
	 * When the current array holding the list gets full the expandArray method is called.
	 * It creates a new array with the double of the size of the current array.
	 * All items are copied into the new array from the old in order. 
	 */
	private void expandArray() {
		ReturnObjectImpl[] tempArray = new ReturnObjectImpl[Storage * 2];
		for(int i = 0; i < Storage; i++) {
			tempArray[i] = arrayList[i];
		}
		arrayList = tempArray;
		Storage = Storage * 2;
	}
	
	/**
	 * If as many elements of the list is removed that the list uses only the half of the current array 
	 * a new array is created with the half of the size of the current array. 
	 * All items are copied int the new array from the old in order. 
	 */
	private void collapseArray() {
		ReturnObjectImpl[] tempArray = new ReturnObjectImpl[Storage / 2];
		for(int i = 0; i < Storage/2; i++) {
			tempArray[i] = arrayList[i];
		}
		arrayList = tempArray;
		Storage = Storage / 2;		
	}
	
	@Override
	public String toString() {
		String result = "";
		if(isEmpty()){
			result = result + new ReturnObjectImpl(ErrorMessage.EMPTY_STRUCTURE).getError();
		}else{
			result = "" + arrayList[0].getReturnValue();
			for(int i = 1; i <= lastElement; i++) {
				result = result + ", " + arrayList[i].getReturnValue();
			}
		}
		return result; 
	}
}
