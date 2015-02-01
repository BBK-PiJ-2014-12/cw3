
public class ReturnObjectImpl implements ReturnObject {
	private Object item = null;
	private ReturnObjectImpl nextObject = null; 
	private ErrorMessage error = null;
	
	/**
	 * Constructor for new elements in the list.
	 * 
	 * @param item
	 */
	public ReturnObjectImpl(Object item) {
		this.item = item;
	}
	
	/**
	 * Constructor for error messages, sets item to null and error to the relevant error message.
	 * 
	 * @param ErrorMessage
	 */
	public ReturnObjectImpl(ErrorMessage error) {
		this.item = null;
		this.error = error;
	}
	
	/**
	 * Constructor or empty ReturnObjects in case of successful operation in the list. 
	 */
	public ReturnObjectImpl(){};
	
	@Override
	public boolean hasError() {
		if(error != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public ErrorMessage getError() {
		if(!hasError()) {
			return ErrorMessage.NO_ERROR; 
		}else{
			return error;
		}
	}
	
	@Override
	public Object getReturnValue() {
		return item;
	}
	
	/**
	 * Sets the object contained in the ReturnObject to the parameter of the method call.
	 * 
	 * @param o the new item.
	 */
	public void setItem(Object o) {
		this.item = o;
	}
	
	/**
	 * Sets the error message contained in the ReturnObject to the parameter of the method call.
	 * 
	 * @param error
	 */
	public void setError(ErrorMessage error) {
		this.error = error;
	}
	
	/**
	 * Returns a pointer to the next object in the list.
	 * 
	 * @return nextObject
	 */
	public ReturnObjectImpl getNext() {
		return nextObject;
	}
	
	/**
	 * Sets the nextObject in the list to the parameter of the method call.
	 * 
	 * @param nextObject
	 */
	public void setNext(ReturnObjectImpl nextObject) {
		this.nextObject = nextObject;
	}
}