package lesson10;
import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;
import edu.umd.cs.findbugs.annotations.NonNull;

import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rabota on 23.08.15.
 */
public class InfoService {

    public static void printFields(Class clazz){
        Field[] fields = clazz.getDeclaredFields();
        for(Field f : fields){
            Class fielsType = f.getType();
            String strModifiers = getModifiers(f.getModifiers());
            System.out.printf("%-15s %-10s %s\n", strModifiers, fielsType.getSimpleName(), f.getName());
        }
    }

    public static void printMethods(@Nonnull Class clazz){
        Method[] methods = clazz.getMethods();
        System.out.println("Class has public methods:");
        for(Method m : methods){
            System.out.print(getModifiers(m.getModifiers()));
            System.out.print(m.getReturnType().getSimpleName());
            System.out.print(" " + m.getName() + " (");
            Class [] parametrs = m.getParameterTypes();
            for(Class c : parametrs){
                System.out.print(c.getSimpleName() + " ");
            }
            System.out.println(");");
        }
    }

    public static void printClassInfo(Class clazz){
        int mods = clazz.getModifiers();
        String strModifiers = getModifiers(mods);
        System.out.println("Name class: " + clazz.getName());
        System.out.println("Simple name: " + clazz.getSimpleName());
        System.out.println("Has modifiers: " + strModifiers + ";");
        List<String> listSuperClass = new ArrayList<>();
        getSuperClass(clazz, listSuperClass);
        System.out.println("SuperClass: ");
        if (listSuperClass.size() == 0){
            System.out.println("none");
        } else {
            for(String s : listSuperClass){
                System.out.println(s);
            }
        }
        System.out.println("Interfaces: ");
        Class [] arrInterfaces = clazz.getInterfaces();
        for(Class c : arrInterfaces){
            System.out.println(c.getSimpleName());
        }
    }

    private static void getSuperClass(Class clazz, List<String> list){
        Class supeClazz = clazz.getSuperclass();
        if (supeClazz != null){
            list.add(supeClazz.getSimpleName());
            getSuperClass(supeClazz, list);
        }
    }

    private static String getModifiers(int mods){
        String strModifiers = new String();

        if (Modifier.isPublic(mods)){
            strModifiers += "public ";
        }

        if (Modifier.isPrivate(mods)){
            strModifiers = "private ";
        }

        if (Modifier.isTransient(mods)){
            strModifiers = "transient ";
        }

        if (Modifier.isProtected(mods)){
            strModifiers += "protected ";
        }

        if (Modifier.isFinal(mods)){
            strModifiers += "final ";
        }

        if (Modifier.isAbstract(mods)){
            strModifiers = "absract ";
        }

        return strModifiers;
    }

}
