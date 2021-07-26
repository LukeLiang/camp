package com.example.week05.simpleframework.util;


import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

/**
 * 山寨版 Spring 框架的 Class 工具类
 */
public class ClassUtil {

    /** 文件Protocol的标识 */
    private final static String FILE_MARK = "file";

    public static Set<Class<?>> getClass(String packageName) {
        ClassLoader classLoader = getClassLoader();
        // 路径名称中的.需要替换成/ getResource() 方法的注解上面有说明
        URL resource = classLoader.getResource(packageName.replace(".", "/"));
        if (resource == null) {
            return new HashSet<>();
        }
        String protocol = resource.getProtocol();
        String path = resource.getPath();
        Set<Class<?>> neededClass = new HashSet<>();
        if(protocol.equalsIgnoreCase(FILE_MARK)) {
            // 递归提取里面的类
            File file = new File(path);
            retrievePackageClass(neededClass, file, packageName);
        }
        System.out.println(neededClass);
        return neededClass;
    }

    /**
     * 获取包下面的所有.class文件
     * @param neededClass classSet 集合
     * @param file 文件夹和文件
     * @param packageName 扫描的包路径
     */
    private static void retrievePackageClass(Set<Class<?>> neededClass, File file,
                                            String packageName) {
        // 停止循环的条件
        if (!file.isDirectory()) { // 如果是文件时停止操作
            return;
        }
        // 遍历当前包下面的文件夹或者文件(也就是类)
        File[] files = file.listFiles();
        if (files.length > 0 && null != files) {
            for (File value : files) {
                if (!value.isDirectory()) {
                    addCLassToSet(neededClass, value.getAbsolutePath(), packageName);
                }
                else {
                    retrievePackageClass(neededClass, value, packageName);
                }
            }
        }
    }

    /**
     * 将被扫描到的类放到Set集合中
     * @param neededClass classSet 集合
     * @param absolutePath 当前.class文件的 绝对路径
     * @param packageName 被扫描包的路径
     */
    private static void addCLassToSet(Set<Class<?>> neededClass, String absolutePath, String packageName) {
        //1.从class文件的绝对值路径里提取出包含了package的类名
        //如/Users/baidu/imooc/springframework/sampleframework/target/classes/com/imooc/entity/dto/MainPageInfoDTO.class
        //需要弄成com.imooc.entity.dto.MainPageInfoDTO
        absolutePath = absolutePath.replace(File.separator, ".");
        String className = absolutePath.substring(absolutePath.indexOf(packageName));
        className = className.substring(0, className.lastIndexOf("."));
        Class<?> newClass = loadClass(className);
        neededClass.add(newClass);
    }

    /**
     * 利用反射创建类的实例
     * @param className 类的全路径名
     * @return Class<?>
     */
    public static Class<?> loadClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取类加载器
     * @return ClassLoader
     */
    public static ClassLoader getClassLoader() {
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 创建类的实例
     * @param clz 需要创建的类
     * @param accessible 是否允许访问私有构造器
     * @param <T> 返回类型，泛型
     * @return 创建好的实例
     */
    public static <T> T newInstance(Class clz, boolean accessible) {
        try {
            Constructor constructor = clz.getDeclaredConstructor(clz);
            constructor.setAccessible(accessible);
            return (T) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


    public static void main(String[] args) {
        getClass("com.liang.inaki");
    }

}
