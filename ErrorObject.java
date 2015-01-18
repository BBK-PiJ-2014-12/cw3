
public class ErrorObject {
	public ReturnObject createErrorObject(int errorNumber) {
		ReturnObjectImpl errMes = new ReturnObjectImpl("");
		errMes.setErrorNum(errorNumber);
		errMes.setItem(errMes.getError());
		return errMes;	
	}
}
