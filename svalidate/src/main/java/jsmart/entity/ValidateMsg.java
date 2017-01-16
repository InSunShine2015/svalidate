package jsmart.entity;

public class ValidateMsg {
	//验证结果
	private boolean result = Boolean.TRUE;
	//验证结果信息
	private StringBuilder msg = new StringBuilder();

  

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public StringBuilder getMsg() {
		return msg;
	}

	public void setMsg(StringBuilder msg) {
		this.msg = msg;
	}
	
	
}
