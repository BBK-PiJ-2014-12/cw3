
public class ReturnObjectImpl implements ReturnObject {
	private Object item = null;
	private ReturnObjectImpl nextObject = null; 
	private ErrorMessage error = null;
	
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
	
	public void setItem(Object o) {
		this.item = o;
	}
	
	public void setError(ErrorMessage error) {
		this.error = error;
	}
	
	public ReturnObjectImpl getNext() {
		return nextObject;
	}
	
	public void setNext(ReturnObjectImpl nextObject) {
		this.nextObject = nextObject;
	}
}