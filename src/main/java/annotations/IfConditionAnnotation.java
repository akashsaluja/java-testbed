package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by akash on 8/25/17.
 */

@Retention(RetentionPolicy.RUNTIME) //This annotation will be there in class file, and then be retained in JVM also
@Target(ElementType.METHOD) //can use in method only.
public @interface IfConditionAnnotation {
    boolean enabled() default true;
}
