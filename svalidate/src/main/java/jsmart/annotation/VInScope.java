package jsmart.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VInScope {
	int min();
	int max();
	ScopeType type() default ScopeType.CLOSE_OPEN;
	public enum ScopeType{
		OPEN_OPEN,//左开右开
		OPEN_CLOSE,//左开右闭
		CLOSE_OPEN,//左闭右开
		CLOSE_CLOSE//左闭右闭
	}
}


