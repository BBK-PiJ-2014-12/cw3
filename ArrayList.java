
public class ArrayList implements List{
	private static final int EMPTY_STRUCTURE = 1;
	private static final int INDEX_OUT_OF_BOUNDS = 2;
	private static final int INVALID_ARGUMENT = 3;
	private int STORAGE = 3;
	private int size = 0;
	private int lastElement = 0;
	private ReturnObjectImpl[] arrayList = new ReturnObjectImpl[STORAGE];
	
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

	public int size() {
		return arrayList.length;
	}

	/**
	 * Returns the elements at the given position. 
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject get(int index) {
		if(isEmpty()) {
			return errObj.createErrorObject(EMPTY_STRUCTURE);
		}else if(0 <= index && index < lastElement) {
			return arrayList[index];
		}else{
			return errObj.createErrorObject(INDEX_OUT_OF_BOUNDS);
		}
	}

	/**
	 * Returns the elements at the given position and removes it
	 * from the list. The indeces of elements after the removed
	 * element must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * @param index the position in the list of the item to be retrieved
	 * @return the element or an appropriate error message, 
	 *         encapsulated in a ReturnObject
	 */
	public ReturnObject remove(int index);

	/**
	 * Adds an element to the list, inserting it at the given
	 * position. The indeces of elements at and after that position
	 * must be updated accordignly.
	 * 
	 * If the index is negative or greater or equal than the size of
	 * the list, then an appropriate error must be returned.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param index the position at which the item should be inserted in
	 *              the list
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(int index, Object item);

	/**
	 * Adds an element at the end of the list.
	 * 
	 * If a null object is provided to insert in the list, the
	 * request must be ignored and an appropriate error must be
	 * returned.
	 * 
	 * @param item the value to insert into the list
	 * @return an ReturnObject, empty if the operation is successful
	 *         the item added or containing an appropriate error message
	 */
	public ReturnObject add(Object item) {
		ReturnObjectImpl newItem = new ReturnObjectImpl(item);
		
		if(lastElement == STORAGE) {
			expendArray();
			arrayList[lastElement] = newItem;
			lastElement++;
			return new ReturnObjectImpl();

		}else{
			arrayList[lastElement] = newItem;
			lastElement++;
			return new ReturnObjectImpl();
		}
	}
	
	public void expendArray() {
		ReturnObjectImpl[] tempArray = new ReturnObjectImpl[STORAGE * 2];
		for(int i = 0; i < STORAGE; i++) {
			tempArray[i] = arrayList[i];
		}
		arrayList = tempArray;
		STORAGE = STORAGE * 2;
	}
	
	public String toString() {
		String result = "";
		if(isEmpty()){
			result = result + errObj.createErrorObject(EMPTY_STRUCTURE).getReturnValue();
		}else{
			for(int i = 0; i < lastElement; i++) {
				result = result + arrayList[i].getReturnValue() + " ";
			}
		}
		return result; 
	}
}
