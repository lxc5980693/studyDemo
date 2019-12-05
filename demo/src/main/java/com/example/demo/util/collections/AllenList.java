package com.example.demo.util.collections;

/**
 * @ProjectName: auction-core
 * @Package: com.example.demo.util.collections
 * @ClassName: AllenList
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-08-12  11:19
 * @Version: 1.0
 */
public interface AllenList<E> {
    int size();

    boolean add(E e);

    E get(int index);

    E remove(int index);
}
