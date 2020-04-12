package com.sihui.dubbo.server.marshalling;


import io.netty.handler.codec.marshalling.DefaultMarshallerProvider;
import io.netty.handler.codec.marshalling.DefaultUnmarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallerProvider;
import io.netty.handler.codec.marshalling.MarshallingDecoder;
import io.netty.handler.codec.marshalling.MarshallingEncoder;
import io.netty.handler.codec.marshalling.UnmarshallerProvider;
import org.jboss.marshalling.MarshallerFactory;
import org.jboss.marshalling.Marshalling;
import org.jboss.marshalling.MarshallingConfiguration;

/**
 * @ProjectName: netty-dubbo
 * @Package: com.sihui.dubbo.server.marshalling
 * @ClassName: Marshalling
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-04-12  17:41
 * @Version: 1.0
 */
public final class MarshallingCodeCFactory {

    public static MarshallingDecoder buildMarshallingDecoder(){
        //首先通过Marshalling的静态方法获取MarshallerFactory实例，参数serial表示的是创建的是java序列化工厂对象
        final MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        //创建MarshallingConfiguration实例
        final MarshallingConfiguration marshallingConfiguration = new MarshallingConfiguration();
        //将版本号设置为5
        marshallingConfiguration.setVersion(5);
        //根据marshallingConfiguration和marshallerFactory创建UnmarshallerProvider实例
        UnmarshallerProvider unmarshallerProvider = new DefaultUnmarshallerProvider(marshallerFactory, marshallingConfiguration);
        //通过构造函数创建一个实例对象
        MarshallingDecoder marshallingDecoder = new MarshallingDecoder(unmarshallerProvider, 1024);
        return marshallingDecoder;
    }

    public static MarshallingEncoder buildMarshallingEncoder(){
        MarshallerFactory marshallerFactory = Marshalling.getProvidedMarshallerFactory("serial");
        MarshallingConfiguration marshallingConfiguration = new MarshallingConfiguration();
        marshallingConfiguration.setVersion(5);
        MarshallerProvider marshallerProvider = new DefaultMarshallerProvider(marshallerFactory, marshallingConfiguration);
        MarshallingEncoder marshallingEncoder = new MarshallingEncoder(marshallerProvider);
        return marshallingEncoder;
    }
}
