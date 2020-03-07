package com.sihui.design.patterns.proxy.myJdk.proxy;

import com.sihui.design.patterns.proxy.classLoad.JavaClassLoader;
import com.sihui.design.patterns.proxy.myJdk.MyExtJdkInvocationHandler;
import com.sihui.design.patterns.proxy.myJdk.service.UserService;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.myJdk.proxy
 * @ClassName: MyProxy
 * @Author: lixuanchen
 * @Description: 生成代理类
 * @Date: 2020-03-06  14:47
 * @Version: 1.0
 */
public class MyProxy {

    private static String A = "\r\t";

    public static Object newProxyInstance(ClassLoader loader,
                                          Class<?> classInterface,
                                          MyExtJdkInvocationHandler h)
            throws IllegalArgumentException, IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //第一步：拼接源代码
        Method[] methods = classInterface.getMethods();
        String proxyClass = "package com.sun.proxy;" + A
                + "import java.lang.reflect.Method;" + A
                + "import com.sihui.design.patterns.proxy.myJdk.MyExtJdkInvocationHandler;" + A
                + "public class $Proxy0 implements " + classInterface.getName() + "{" + A
                + "private MyExtJdkInvocationHandler h;" + A
                + "public $Proxy0(MyExtJdkInvocationHandler h) " + "{" + A
                + "this.h = h;" + A
                + "}" + A
                + getMethodString(methods,classInterface) + A + "}";
        //第二步：生成java文件
        String fileName = "/Users/lixuanchen/Desktop/code/$Proxy0.java";
        File file = new File(fileName);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(proxyClass);
        fileWriter.flush();
        fileWriter.close();

        //第三步：编译java文件
        JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager standardFileManager = javaCompiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> javaFileObjects = standardFileManager.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task = javaCompiler.getTask(null, standardFileManager, null, null, null, javaFileObjects);
        task.call();
        standardFileManager.close();

        //使用classLoader技术加载到内存中
        Class<?> $Proxy0 = new JavaClassLoader().findClass("$Proxy0");
        Constructor<?> constructor = $Proxy0.getConstructor(MyExtJdkInvocationHandler.class);
        Object o = constructor.newInstance(h);
        return o;
    }

    private static String getMethodString(Method[] methods, Class<?> classInterface) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Method method : methods){
            stringBuilder.append("public void ").append(method.getName())
                    .append("() throws Throwable").append("{").append(A)
                    .append("Method method = ").append(classInterface.getName()).append(".class.getMethod(\"")
                    .append(method.getName()).append("\",new Class[]{});").append(A)
                    .append("this.h.invoke(this,method,null);").append(A).append("}").append(A);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        newProxyInstance(null, UserService.class, null);
    }
}
