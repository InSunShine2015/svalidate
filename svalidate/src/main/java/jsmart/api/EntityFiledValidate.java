package jsmart.api;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import jsmart.annotation.VInPoints;
import jsmart.annotation.VInScope;
import jsmart.annotation.VInScope.ScopeType;
import jsmart.annotation.VNotNull;
import jsmart.annotation.VReg;
import jsmart.entity.ValidateMsg;
import jsmart.interfaces.impl.InPointsHandler;
import jsmart.interfaces.impl.InScopeHandler;
import jsmart.interfaces.impl.NotNullHandler;
import jsmart.interfaces.impl.RegHandler;

public class EntityFiledValidate {
	
	public static <T> ValidateMsg validateField(T t) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		ValidateMsg msg = new ValidateMsg();
		Class tclass = t.getClass();
		Field[] fields = tclass.getDeclaredFields();
		for(Field field:fields){
			String fieldName = field.getName();
			Object fieldValue = getFieldValue(t, fieldName);
			Map<String,Object> values = new HashMap<String, Object>();
			
			if(field.isAnnotationPresent(VNotNull.class)){
				values.put("value",fieldValue);
				NotNullHandler handler = new NotNullHandler();
				msg = handler.validate(fieldName, values, msg);
			}
			if(field.isAnnotationPresent(VInScope.class)){
				VInScope scope = field.getAnnotation(VInScope.class);
				int min = scope.min();
				int max = scope.max();
				ScopeType type = scope.type();
				
				values.clear();
				values.put("min", min);
				values.put("max", max);
				values.put("type", type);
				values.put("value", fieldValue);
				
				InScopeHandler shandler = new InScopeHandler();
				msg = shandler.validate(fieldName, values, msg);
			}
			
			if(field.isAnnotationPresent(VInPoints.class)){
				VInPoints points = field.getAnnotation(VInPoints.class);
				String pvalues = points.values();
				
				values.clear();
				values.put("value", fieldValue);
				values.put("points", pvalues);
				
				InPointsHandler phandler = new InPointsHandler();
				msg = phandler.validate(fieldName, values, msg);
			}
			
			if(field.isAnnotationPresent(VReg.class)){
				VReg reg = field.getAnnotation(VReg.class);
				String regExpress = reg.reg();
				
				values.clear();
				values.put("value", fieldValue);
				values.put("reg", regExpress);
				
				RegHandler regHandler = new RegHandler();
				msg = regHandler.validate(fieldName, values, msg);
			}
		}
		
		return msg;
	}
	
	public static Object getFieldValue(Object c,String field) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		String firstLetter = field.substring(0, 1).toUpperCase();
		String getMethodName = "get" + firstLetter + field.substring(1);
		Method getMethod = c.getClass().getMethod(getMethodName);
		Object returnValue = getMethod.invoke(c);
		return returnValue;
	}
}
