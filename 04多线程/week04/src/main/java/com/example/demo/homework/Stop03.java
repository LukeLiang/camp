
package com.example.demo.homework;

/**
 * run 方法内没有sleep或wait时, 停止线程
 */
public class Stop03 implements Runnable {

    @Override
    public void run() {
        int num = 0;
        while(!Thread.currentThread().isInterrupted()
                && num <= Integer.MAX_VALUE / 2) {
            if (num % 10000 == 0) {
                System.out.println(num + "是10000的倍数");
            }
            num++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Stop03());
        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
