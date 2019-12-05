package com.example.demo.util.collections;

import java.util.AbstractList;
import java.util.Arrays;

/**
 * @ProjectName: auction-core
 * @Package: com.example.demo.util.collections
 * @ClassName: AllenArrayList
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2019-08-09  14:56
 * @Version: 1.0
 */
public class AllenArrayList<E> extends AbstractList<E> implements AllenList<E> {

    /**
     * 默认容量为0的元数组
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 集合元素临时存的数组对象
     */
    transient Object[] elementData;

    /**
     * 集合中的元素个数
     */
    private int size;

    /**
     * 集合无参构造函数
     */
    public AllenArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 添加元素
     *
     * @param e
     * @return
     */
    @Override
    public boolean add(E e) {
        //1、确认需要的容量
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 确认需要的容量
     *
     * @param needSize
     */
    private void ensureCapacityInternal(int needSize) {
        int minCapacity = calculateCapacity(elementData, needSize);
        //如果当前length小于size
        int oldCapacity = elementData.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (minCapacity > newCapacity) {
                //需要扩容
                newCapacity = minCapacity;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
    }

    private int calculateCapacity(Object[] elementData, int needSize) {
        return elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA ? Math.max(DEFAULT_CAPACITY, needSize) : needSize;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    @Override
    public E get(int index) {
        rangeCheck(index);
        return (E) elementData[index];
    }

    /**
     * 删除元素
     *
     * @param index
     * @return
     */
    @Override
    public E remove(int index) {
        //1、检查下标
        rangeCheck(index);
        //2、获取该元素
        E oldValue = (E) elementData[index];
        //3、获取需要修改的元素长度
        int eleLength = size - index - 1;
        if (eleLength > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, eleLength);
        }
        //修改最后一个元素为null
        elementData[--size] = null;
        return oldValue;
    }

    /**
     * 获取元素个数
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 校验集合下标是否越界
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("下标越界");
        }
    }
}
