package jsmart;

import java.lang.reflect.InvocationTargetException;

import jsmart.api.EntityFiledValidate;
import jsmart.entity.ValidateMsg;

public class Test {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		TestEntity entity = new TestEntity();
		entity.setId("aa");
		entity.setAge("15");
		entity.setSex("male");
		entity.setTelephone("15233445566");
		ValidateMsg msg = EntityFiledValidate.validateField(entity);
		System.out.println(msg.isResult());
		System.out.println(msg.getMsg().toString());
	}
}
