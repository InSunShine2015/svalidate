package jsmart;

import jsmart.annotation.VInPoints;
import jsmart.annotation.VInScope;
import jsmart.annotation.VNotNull;
import jsmart.annotation.VReg;

public class TestEntity {
	@VNotNull
	private String id;
	
	@VReg(reg="0?(13|14|15|18)[0-9]{9}")
	private String telephone;
	
	@VInPoints(values="male,female")
	private String sex;
	@VInScope(min=10,max=20)
	private String age;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
	
}
