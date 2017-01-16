package jsmart.interfaces;

import java.util.Map;
import jsmart.entity.ValidateMsg;

public interface ValidateField {
	ValidateMsg validate(String fieldName,Map<String,Object> values,ValidateMsg msg);
}
