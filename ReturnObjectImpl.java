
public class ReturnObjectImpl implements ReturnObject {
	private Object item = null;
	private ReturnObjectImpl nextObject = null; 
	private int errorNum = 0;

	
	public ReturnObjectImpl(Object item) {
		this.item = item;
	}
	
	public ReturnObjectImpl(){};
	
	@Override
	public boolean hasError() {
		boolean result = false;
		if(errorNum!=0) {
			result = true;
		}
		return result;
	}
	
	@Override
	public ErrorMessage getError() {
		if(!hasError()) {
			return ErrorMessage.NO_ERROR; 
		}else{
			if(errorNum == 1) {return ErrorMessage.EMPTY_STRUCTURE;}
			else if(errorNum == 2) {return ErrorMessage.INDEX_OUT_OF_BOUNDS;}
			else {return ErrorMessage.INVALID_ARGUMENT;}
		}
	}
	
	@Override
	public Object getReturnValue() {
		return item;
	}
	
	public void setItem(Object o) {
		this.item = o;
	}
	
	public int getErrorNum(){
		return errorNum;
	}
	
	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}
	
	public ReturnObjectImpl getNext() {
		return nextObject;
	}
	
	public void setNext(ReturnObjectImpl nextObject) {
		this.nextObject = nextObject;
	}
}