package com.sihui.collection.hashMap8;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.hashMap8
 * @ClassName: MyHashMapEight
 * @Author: lixuanchen
 * @Description: ${description}
 * @Date: 2020-03-12  20:41
 * @Version: 1.0
 */
public class SihuiHashMap<K, V> implements SihuiMap<K, V> {
    /**
     * 在构造函数中未指定时使用的负载系数
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static final int MAXIMUM_CAPACITY = 1 << 30;

    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4;

    /**
     * 转红黑树的阈值
     */
    static final int TREEIFY_THRESHOLD = 8;

    /**
     * 该表在首次使用时初始化，并调整为
     * 必填。 分配后，长度始终是2的幂。
     * （我们在某些操作中也允许长度为零，以允许当前不需要的引导机制。）
     * 存放的所有的链表
     */
    transient SihuiHashMap.Node<K, V>[] table;

    /**
     * 哈希表的负载因子
     */
    final float loadFactor;

    int threshold;

    public SihuiHashMap() {
        this.loadFactor = DEFAULT_LOAD_FACTOR;
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    /**
     * 计算key的hash值，如果key为null的话直接存在第一个链表 （数组[0]）
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
                   boolean evict) {
        //表示数组中存放的所有的链表
        Node<K, V>[] tab;
        //根据当前key计算的index值下的链表
        Node<K, V> p;
        //n为当前数组的长度，i为当前key的index值
        int n, i;
        //如果当前hashMap中数组table为空或者长度为0的话，进行扩容
        if ((tab = table) == null || (n = tab.length) == 0) {
            n = (tab = resize()).length;
        }
        //查询当前key的index下有没有对应的节点,(n - 1) & hash 计算出当前key的index值
        if ((p = tab[i = (n - 1) & hash]) == null) {
            //如果为空，直接创建节点，并且赋值
            tab[i] = newNode(hash, key, value, null);
        }else {
            //存在链表，则需要在该链表下添加节点

            //存放相同
            SihuiHashMap.Node<K,V> e;
            //存放产生index冲突的链表的头节点的key值
            K k;
            //判断当前key和已存在的节点的key值是否产生了hash冲突 且 当前key是否与链表存在的key相同
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))){
                //实现对当前value覆盖
                e = p;
            }else if (p instanceof TreeNode){
                //是否属于使用红黑树的节点,
//                e = ((SihuiHashMap.TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
            }else {
                //不属于红黑树节点，属于普通链表的节点

                //binCount继续进行循环
                for (int binCount = 0; ; ++binCount) {
                    if ((e = p.next) == null) {
                        //如果没有下一个节点，以当前key、val创建节点，放入的p的下一个节点上
                        p.next = newNode(hash, key, value, null);
                        if (binCount >= TREEIFY_THRESHOLD - 1){
                            treeifyBin(tab, hash);
                        }
                        break;
                    }
                    //判断下一个节点的key是否与当前节点的key相同，如果相同直接返回
                    if (e.hash == hash &&
                            ((k = e.key) == key || (key != null && key.equals(k)))){
                        break;
                    }
                    p = e;
                }
                if (e != null) { // existing mapping for key
                    V oldValue = e.value;
                    //如果原来的val为空的情况下
                    if (!onlyIfAbsent || oldValue == null){
                        e.value = value;
                    }
//                    afterNodeAccess(e);
                    return oldValue;
                }
            }
        }
        return null;
    }

    /**
     * 转红黑树存在
     * @param tab
     * @param hash
     */
    final void treeifyBin(Node<K,V>[] tab, int hash) {

    }

    /**
     * 对table进行扩容
     *
     * @return
     */
    final SihuiHashMap.Node<K, V>[] resize() {
        SihuiHashMap.Node<K,V>[] oldTab = table;
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        int oldThr = threshold;
        int newCap, newThr = 0;
        if (oldCap > 0) {
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY &&
                    oldCap >= DEFAULT_INITIAL_CAPACITY){
                newThr = oldThr << 1; // double threshold
            }
        }
        // initial capacity was placed in threshold
        else if (oldThr > 0) {
            newCap = oldThr;
        }
        else {               // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY;
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY);
        }
        if (newThr == 0) {
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        threshold = newThr;
        SihuiHashMap.Node<K,V>[] newTab = (SihuiHashMap.Node<K,V>[])new SihuiHashMap.Node[newCap];
        table = newTab;
        if (oldTab != null) {
            for (int j = 0; j < oldCap; ++j) {
                SihuiHashMap.Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null){
                        newTab[e.hash & (newCap - 1)] = e;
                    }
//                    else if (e instanceof SihuiHashMap.TreeNode)
//                        ((HashMap.TreeNode<K,V>)e).split(this, newTab, j, oldCap);
//                    else { // preserve order
//                        HashMap.Node<K,V> loHead = null, loTail = null;
//                        HashMap.Node<K,V> hiHead = null, hiTail = null;
//                        HashMap.Node<K,V> next;
//                        do {
//                            next = e.next;
//                            if ((e.hash & oldCap) == 0) {
//                                if (loTail == null)
//                                    loHead = e;
//                                else
//                                    loTail.next = e;
//                                loTail = e;
//                            }
//                            else {
//                                if (hiTail == null)
//                                    hiHead = e;
//                                else
//                                    hiTail.next = e;
//                                hiTail = e;
//                            }
//                        } while ((e = next) != null);
//                        if (loTail != null) {
//                            loTail.next = null;
//                            newTab[j] = loHead;
//                        }
//                        if (hiTail != null) {
//                            hiTail.next = null;
//                            newTab[j + oldCap] = hiHead;
//                        }
//                    }
                }
            }
        }
        return newTab;
    }

    SihuiHashMap.Node<K, V> newNode(int hash, K key, V value, SihuiHashMap.Node<K, V> next) {
        return new SihuiHashMap.Node<K, V>(hash, key, value, next);
    }


    static class Node<K, V> {
        final int hash;
        final K key;
        V value;
        SihuiHashMap.Node<K, V> next;

        Node(int hash, K key, V value, SihuiHashMap.Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final K getKey() {
            return key;
        }

        public final V getValue() {
            return value;
        }


        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }
    }

//    static final class TreeNode<K,V> extends LinkedHashMap.Entry<K,V> {
//        // red-black tree links
//        SihuiHashMap.TreeNode<K,V> parent;
//        SihuiHashMap.TreeNode<K,V> left;
//        SihuiHashMap.TreeNode<K,V> right;
//        // needed to unlink next upon deletion
//        SihuiHashMap.TreeNode<K,V> prev;
//        boolean red;
//        TreeNode(int hash, K key, V val, SihuiHashMap.Node<K,V> next) {
//            super(hash,key,val,next);
//        }
//
//        /**
//         * Returns root of tree containing this node.
//         */
//        final SihuiHashMap.TreeNode<K,V> root() {
//            for (SihuiHashMap.TreeNode<K,V> r = this, p;;) {
//                if ((p = r.parent) == null){
//                    return r;
//                }
//                r = p;
//            }
//        }
//    }
}
