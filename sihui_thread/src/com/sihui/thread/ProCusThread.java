package com.sihui.thread;

/**
 * @ProjectName: sihui_thread
 * @Package: com.sihui.thread
 * @ClassName: ProCusThread
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-06-27  14:38
 * @Version: 1.0
 */
public class ProCusThread {
    static User user = new User();

    static boolean flag = false;

    static class ProThread implements Runnable{

        @Override
        public void run() {
            int count = 0;
            while (true){
                synchronized (user){
                    //如果flag是false的时候，允许写 不允许读
                    try {
                        if (flag){
                            user.wait();
                        }
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    if (count == 0){
                        user.setName("李炫辰");
                        user.setAge(25);
                    }else {
                        user.setName("思慧");
                        user.setAge(26);
                    }
                    flag = true;
                    user.notify();
                    count = (count + 1) % 2;
                }
            }
        }
    }

    static class CusThread implements Runnable{

        @Override
        public void run() {
            while (true){
                synchronized (user){
                    if (!flag){
                        try {
                            user.wait();
                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                    if (user != null){
                        System.out.println(user.toString());
                    }
                    flag = false;
                    user.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new ProThread()).start();
        new Thread(new CusThread()).start();
    }
}

class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
