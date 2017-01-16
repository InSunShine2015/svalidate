package jsmart.interfaces.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import jsmart.entity.ValidateMsg;
import jsmart.interfaces.ValidateField;

public class InPointsHandler implements ValidateField{

	public ValidateMsg validate(String fieldName, Map<String, Object> values, ValidateMsg msg) {
		String value = (String) values.get("value");
		if(value == null || "null".equals(value)){
			msg.setResult(Boolean.FALSE);
			msg.getMsg().append(fieldName+"获取的属性值不能为null;");
			return msg;
		}
		String[] points = ((String) values.get("points")).split(",");
		List<String> plist = Arrays.asList(points);
		if(! plist.contains(value)){
			msg.setResult(Boolean.FALSE);
			msg.getMsg().append(fieldName+"获取的属性值不在指定值内;");
		}
		return msg;
	}

}
