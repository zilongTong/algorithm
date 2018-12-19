package matrix;

public class IllegalParamException extends Exception {

	private static final long serialVersionUID = 5884526176828612675L;
	private static final String msg = "the value of row or column can not be this value.";
	public IllegalParamException() {
		super(msg);
	}
	public IllegalParamException(String msg) {
		super(msg);
	}

}
