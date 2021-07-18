
package com.example.demo.homework;

/**
 * 用stop() 来停止线程,会导致线程运行一半突然停止，没有办法完成整个操作
 * 虽然可以停止线程，但是错误的一种方式
 */
public class Stop01 implements Runnable {


    @Override
    public void run() {
        // 模拟指挥军队：一共有5个连队，每个连队10人，以连队为单位，发放武器弹药，叫到号的士兵前去领取
        for (int i = 0; i < 5; i++) {
            System.out.println("连队" + i + "开始领取武器");
            for (int j = 0; j < 10; j++) {
                System.out.println(j);
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("连队"+i+"已经领取完毕");
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Stop01());
        thread.start();
        Thread.sleep(1000);
        thread.stop();
        System.out.println("主线程退出。。。");
    }
}
