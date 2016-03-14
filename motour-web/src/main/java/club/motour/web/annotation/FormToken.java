package club.motour.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FormToken {

	/**
	 * 產生UUID
	 * @return
	 */
	boolean save() default false;
	/**
	 * 驗證表單，移除UUID
	 * @return
	 */
	boolean remove() default false ;
}
