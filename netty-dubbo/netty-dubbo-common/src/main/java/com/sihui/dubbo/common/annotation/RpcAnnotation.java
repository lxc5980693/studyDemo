package com.sihui.dubbo.common.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.common.annotation
 * @ClassName: RpcAnnotation
 * @Author: lixuanchen
 * @Description: 手写dubbo自定义注解
 * @Date: 2020-03-02  21:39
 * @Version: 1.0
 */
@Documented
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcAnnotation {
    Class value();
}
