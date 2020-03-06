package com.sihui.design.patterns.proxy.classLoad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ProjectName: design-patterns
 * @Package: com.sihui.design.patterns.proxy.classLoad
 * @ClassName: JavaClassLoader
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-06  16:02
 * @Version: 1.0
 */
public class JavaClassLoader extends ClassLoader {
    private File classPathFile;

    public JavaClassLoader() {
        String classPath = "/Users/lixuanchen/Desktop/code/$Proxy0.java";
        this.classPathFile = new File(classPath);
    }

    public Class<?> findClass(String name) throws ClassNotFoundException {
        String className = JavaClassLoader.class.getName() + "." + name;
        if (classPathFile != null) {
            File file = new File(classPathFile, name.replace("\\.", "/") + ".class");
            if (file.exists()) {
                FileInputStream fileInputStream = null;
                ByteArrayOutputStream byteArrayOutputStream = null;
                try {
                    fileInputStream = new FileInputStream(file);
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    byte[] bytes = new byte[1024];
                    int len;
                    if ((len = fileInputStream.read()) != -1) {
                        byteArrayOutputStream.write(bytes);
                    }
                    return defineClass(className, byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (fileInputStream != null){
                        try {
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (byteArrayOutputStream != null){
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
