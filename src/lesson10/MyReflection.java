package lesson10;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;


public abstract class MyReflection {

    public static void setPrivate(Object obj, Map<String, String> map) throws NoSuchFieldException, IllegalAccessException {
        Class clazz = obj.getClass();
        for(Map.Entry<String, String> entry : map.entrySet()) {
            Field field = clazz.getDeclaredField(entry.getKey());
            field.setAccessible(true);
            field.set(obj, entry.getValue());
        }
    }

    public static void initClassByConstructor(Class clazz, List<ParamType> list) throws Exception {
        for(ParamType pt : list){
            Constructor constructor = clazz.getConstructor(pt.getClazz());
            constructor.newInstance(pt.getObject());
        }
    }

    public static Object initClass(Class clazz, Map<String, String> map) throws Exception {
        Object object = clazz.newInstance();
        Class [] param = new Class []{String.class, int.class};
        for(Map.Entry<String, String> m : map.entrySet()){
            Method method = clazz.getMethod(m.getKey(), param);
            method.invoke(object, m.getValue(), 0);
        }
        return object;
    }

    public <T extends InfoService> T method(T obj){
        return obj;
    }

    public static void main(String[] args) throws Exception {
//        InfoService.printClassInfo(ForInstance.class);
//        InfoService.printMethods(ForInstance.class);
//        InfoService.printFields(ForInstance.class);

//        Map<String, String> map = new HashMap<>();
//        map.put("setName1", "name1");
//        map.put("setName2", "name2");
//        map.put("setName3", "name3");
//        //ForInstance forInstance = (ForInstance)initClass(ForInstance.class, map);
//
        List<ParamType> listParamType = new ArrayList<>();
        listParamType.add(new ParamType(new Class[]{String.class}, new Object[]{"STRING"}));
        listParamType.add(new ParamType(new Class[]{String.class, int.class}, new Object[]{"STRING", 5}));
        listParamType.add(new ParamType(new Class[]{String.class, double.class}, new Object[]{"STRING", 0.0}));
//
        initClassByConstructor(ForInstance.class, listParamType);
//
//        Map<String, String> mapSetPrivate = new HashMap<>();
//        mapSetPrivate.put("name1", "name1 - set private");
//        mapSetPrivate.put("name2", "name2 - set private");
//        mapSetPrivate.put("name3", "name3 - set private");
//
//        ForInstance fi = new ForInstance();
//        setPrivate(fi, mapSetPrivate);
//        System.out.printf("1)%s;\n2)%s;\n3)%s;\n", fi.getName1(), fi.getName2(), fi.getName3());
    }

    private static class ParamType {
        private Class [] clazz;
        private Object [] object;

        public ParamType(Class[] clazz, Object[] object){
            this.clazz = clazz;
            this.object = object;
        }

        public Class[] getClazz() {
            return clazz;
        }

        public Object[] getObject() {
            return object;
        }
    }
}
