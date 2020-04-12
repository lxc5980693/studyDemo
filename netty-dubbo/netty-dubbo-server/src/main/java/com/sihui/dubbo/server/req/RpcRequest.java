package com.sihui.dubbo.server.req;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.req
 * @ClassName: RpcRequest
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-06  17:37
 * @Version: 1.0
 */
public class RpcRequest implements Serializable {
    private static final long SerialVersionUID = 1L;

    /**
     * 类的名称
     */
    private String className;

    /**
     * 方法名称
     */
    private String methodName;

    /**
     * 参数类型
     */
    private Class<?> parameterTypes[];

    /**
     * 参数值
     */
    private Object paramsValue[];

    public RpcRequest(String className, String methodName, Class<?>[] parameterTypes, Object[] paramsValue) {
        this.className = className;
        this.methodName = methodName;
        this.parameterTypes = parameterTypes;
        this.paramsValue = paramsValue;
    }

    public static long getSerialVersionUID() {
        return SerialVersionUID;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public Object[] getParamsValue() {
        return paramsValue;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", paramsValue=" + Arrays.toString(paramsValue) +
                '}';
    }
}
