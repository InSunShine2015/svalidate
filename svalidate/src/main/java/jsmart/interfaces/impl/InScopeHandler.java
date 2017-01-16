package jsmart.interfaces.impl;

import java.util.Map;

import jsmart.annotation.VInScope.ScopeType;
import jsmart.entity.ValidateMsg;
import jsmart.interfaces.ValidateField;

public class InScopeHandler implements ValidateField{

	public ValidateMsg validate(String fieldName, Map<String, Object> values, ValidateMsg msg) {
		String value = (String) values.get("value");
		if(value == null || "null".equals(value)){
			msg.setResult(Boolean.FALSE);
			msg.getMsg().append(fieldName+"属性值为null");
			return msg;
		}
		int intValue = Integer.parseInt(value);
		int min = (Integer) values.get("min")==null?0:(Integer) values.get("min");
		int max = (Integer) values.get("max")==null?0:(Integer) values.get("max");
		ScopeType type = (ScopeType) values.get("type");
		switch (type) {
		case OPEN_OPEN:
			if(intValue<=min || intValue>=max){
				msg.setResult(Boolean.FALSE);
				msg.getMsg().append(fieldName+"属性值未在指定属性值范围内");
			}
			break;
		case OPEN_CLOSE:
			if(intValue<=min || intValue>max){
				msg.setResult(Boolean.FALSE);
				msg.getMsg().append(fieldName+"属性值未在指定属性值范围内");
			}
			break;
		case CLOSE_CLOSE:
			if(intValue<min || intValue>max){
				msg.setResult(Boolean.FALSE);
				msg.getMsg().append(fieldName+"属性值未在指定属性值范围内");
			}
			break;
		default:
			if(intValue<min || intValue>=max){
				msg.setResult(Boolean.FALSE);
				msg.getMsg().append(fieldName+"属性值未在指定属性值范围内");
			}
			break;
		}
		return msg;
	}

}
