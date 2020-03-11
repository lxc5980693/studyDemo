package com.sihui.collection.hashMap;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.hashMap
 * @ClassName: InterruptDemo
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-09  21:15
 * @Version: 1.0
 */
public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {
        TestWait t = new TestWait("线程1");
        TestWait t1 = new TestWait("线程2");
        t.start();

        t1.start();
    }
}

class TestWait extends Thread {
    String name;

    public TestWait(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 5; i++) {
            if (i == 3) {
                try {
//                 等待之后立即释放当前锁，并且进入等待池中等待唤醒
//                 当等待池中的线程被唤醒后，再次执行此语句之后的语句
                this.wait();
                System.out.println(Thread.currentThread().getName() + ":我还没有被执行到！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (i == 4){
                this.notify();
            }
            System.out.println(Thread.currentThread().getName() + ":当前的值为--->" + i);
        }
    }
}
