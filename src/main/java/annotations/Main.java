package annotations;

import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by akash on 8/25/17.
 */
@Data
public class Main {

    @IfConditionAnnotation(enabled = true)
    public void willRun() {
        System.out.println("Ran-Expected");
    }

    @IfConditionAnnotation(enabled = false)
    public void willNotRun() {
        System.out.println("Unexpected ******");
    }

    public static void main(String[] args) {
        readAnnotations();
    }

    public static void readAnnotations() {
        Class<Main> obj = Main.class;
        for(Method method: obj.getDeclaredMethods()) {
            if(method.getAnnotation(IfConditionAnnotation.class)!=null &&
                    method.getAnnotation(IfConditionAnnotation.class).enabled()) {
                try {
                    method.invoke(obj.newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
