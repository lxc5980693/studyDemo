package com.sihui.thread;

/**
 * @ProjectName: sihui_thread
 * @Package: com.sihui.thread
 * @ClassName: TicketThread
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-06-27  11:38
 * @Version: 1.0
 */
public class TicketThread implements Runnable {
    //票数
    private Integer totalNum = 100;

    @Override
    public void run() {
        while (totalNum > 0) {
                System.out.println(Thread.currentThread().getName() + "正在出票第：" + (100 - totalNum + 1));
                totalNum--;
        }
    }

    public static void main(String[] args) {
        TicketThread ticketThread = new TicketThread();
        new Thread(ticketThread,"窗口1").start();
        new Thread(ticketThread,"窗口2").start();
    }
}
