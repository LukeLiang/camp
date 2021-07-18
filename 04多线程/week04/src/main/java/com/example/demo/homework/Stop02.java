
package com.example.demo.homework;

/**
 * 使用抛异常的方式中止线程
 * run无法抛出checked Exception，只能用try/catch
 */
public class Stop02 {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
