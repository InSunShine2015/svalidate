package jsmart.interfaces.impl;

import java.util.Map;
import java.util.regex.Pattern;

import jsmart.entity.ValidateMsg;
import jsmart.interfaces.ValidateField;

public class RegHandler implements ValidateField {

	public ValidateMsg validate(String fieldName, Map<String, Object> values, ValidateMsg msg) {
		String reg = (String) values.get("reg");
		String fieldValue = (String) values.get("value");
		if(fieldValue == null || "null".equals(fieldValue)){
			msg.setResult(Boolean.FALSE);
			msg.getMsg().append(fieldName+"为null；");
			return msg;
		}
		Pattern p = Pattern.compile(reg);
		if(! p.matcher((String)fieldValue).matches()){
			msg.setResult(Boolean.FALSE);
			msg.getMsg().append(fieldName+" 属性非指定格式；");
		}
		return msg;
	}

}
