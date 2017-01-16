package jsmart.interfaces.impl;

import java.util.Map;

import jsmart.entity.ValidateMsg;
import jsmart.interfaces.ValidateField;

public class NotNullHandler implements ValidateField{

	public ValidateMsg validate(String fieldName, Map<String, Object> values, ValidateMsg msg) {
		String value = (String) values.get("value");
		if(value == null || "null".equals(value)){
			msg.setResult(Boolean.FALSE);
			msg.getMsg().append("属性:"+fieldName+" 不能为空值;");
		}
		return msg;
	}
}
