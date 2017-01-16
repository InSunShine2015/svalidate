package jsmart.interfaces;

import java.util.Map;
import jsmart.entity.ValidateMsg;
/**
 * 验证实体类的字段
 * @author sUN
 *
 */
public interface ValidateField {
	/**
	 * 
	 * @param fieldName 属性名称
	 * @param values 验证需要的值
	 * @param msg 验证结果
	 * @return
	 */
	ValidateMsg validate(String fieldName,Map<String,Object> values,ValidateMsg msg);
}
