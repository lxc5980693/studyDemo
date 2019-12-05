package com.example.demo.util.collections;

import java.util.AbstractList;

/**
 * @ProjectName: auction-core
 * @Package: com.example.demo.util.collections
 * @ClassName: AllenLinkedList
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-08-12  14:31
 * @Version: 1.0
 */
public class AllenLinkedList<E> extends AbstractList<E> implements AllenList<E> {

    transient int size;

    transient Node<E> first;

    transient Node<E> last;

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E e) {
        return super.add(e);
    }

    private static class Node<E>{
        Node<E> prev;
        E item;
        Node<E> next;
    }
}
