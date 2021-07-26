package com.example.week05.simpleframework.context;

import com.example.week05.simpleframework.core.annotation.*;
import com.example.week05.simpleframework.util.ClassUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用 枚举 模式的 BeanContainer 可以抵御 反射和序列化的攻击
 */
@Slf4j
public class BeanContainer {

    /** 存放所有被配置标记的目标对象的Map */
    private final Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    /** 标记类被标记了哪种注解的 需要被加载进 beanMap */
    private static final List<Class<? extends Annotation>> BEAN_ANNOTATION
            = Arrays.asList(Component.class, Service.class, Repository.class, Controller.class, Configuration.class);

    private enum ContextHolder {
        HOLDER;

        private BeanContainer instance;

        ContextHolder() {
            instance = new BeanContainer();
        }
    }

    private boolean loaded = false;

    /**
     * beanMap 是否已经加载过
     * @return boolean
     */
    public boolean isLoaded() {
        return loaded;
    }

    /**
     * 获取BeanContainer的实例
     * @return BeanContainer
     */
    public static BeanContainer getBeanContainer() {
        return ContextHolder.HOLDER.instance;
    }

    /**
     * 加载被标记的Bean
     * @param packageName 相对路径包名
     */
    private void loadBean(String packageName) {
        if (isLoaded()) {
            log.warn("BeanContainer has been loaded");
            return;
        }
        Set<Class<?>> clazz = ClassUtil.getClass(packageName);
        // TODO 判断clazz 是否为空
        for (Class clz : clazz) {
            for (Class<? extends Annotation> anno : BEAN_ANNOTATION) {
                if (clz.isAnnotationPresent(anno)) {
                    beanMap.put(clz, ClassUtil.newInstance(clz, true));
                }
            }
        }
        loaded = true;
    }

    /**
     * 获取所有的 Class
     * @return Set<Class<?>>
     */
    public Set<Class<?>> getClasses() {
        return beanMap.keySet();
    }

    /**
     * 获取该类下的所有子类
     * @param interfaceOrClass 超类
     * @return 所有超类的子类，不包含本身
     */
    public Set<Class<?>> getClassesBySuper(Class<?> interfaceOrClass) {
        Set<Class<?>> classes = getClasses();
        Set<Class<?>> classSet = new HashSet<>();
        for (Class<?> clz : classes) {
            // 剔除掉本身
            if (clz.isAssignableFrom(interfaceOrClass) && !clz.equals(interfaceOrClass)) {
                classSet.add(clz);
            }
        }
        return classSet.size() > 0 ? classSet : null;
    }


}
