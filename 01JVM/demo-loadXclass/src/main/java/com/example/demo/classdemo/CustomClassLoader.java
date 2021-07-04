
package com.example.demo.classdemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomClassLoader extends ClassLoader {
    /** 加载文件的路径，SpringBoot 的 getResourceAsStream会把resources作为根路径 */
    private static final String FILE_LOCATION = "Hello.xlass";

    /** 解析后的 class 类名 */
    private static final String DEFINED_CLASS_NAME = "Hello";

    /** 解析后的类中的方法名 */
    private static final String DEFINED_CLASS_METHOD_NAME = "hello";

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        CustomClassLoader loader = new CustomClassLoader();
        Class<?> helloClass = loader.loadClass(DEFINED_CLASS_NAME);
        Constructor<?> declaredConstructor = helloClass.getDeclaredConstructor();
        // 使用无参构造器创建Hello类的实例
        Object targetClass = declaredConstructor.newInstance();
        Method method = helloClass.getMethod(DEFINED_CLASS_METHOD_NAME);
        // 调用hello方法
        method.invoke(targetClass);
        //Class class1 = loader.loadClass("Hello");

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(FILE_LOCATION);
        try {
            int size = inputStream.available();
            byte[] bytes = new byte[size];
            inputStream.read(bytes);
            byte[] classCode = this.decode(bytes);
            // 使用 defineClass，加载类
            return defineClass("Hello", classCode, 0, classCode.length);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public byte[] decode(byte[] fileBytes) {
        byte[] newSize = new byte[fileBytes.length];
        for (int i = 0; i < newSize.length; i++) {
            newSize[i] = (byte) (255 - fileBytes[i]);
        }
        return newSize;
    }
}
