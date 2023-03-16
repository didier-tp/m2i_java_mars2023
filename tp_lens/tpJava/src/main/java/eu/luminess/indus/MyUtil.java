package eu.luminess.indus;

import java.lang.reflect.Field;

public class MyUtil {

   public static void  decrire(Object object){
       Class<?> c = object.getClass();
       Field[] fields = c.getDeclaredFields();
       for(Field f : fields){
           System.out.println(f.getName() + " " + f.getType().getSimpleName());
       }
   }
}
