package com.sihui.collection.tree;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.tree
 * @ClassName: NodeColor
 * @Author: lixuanchen
 * @Description: 红黑树节点
 * @Date: 2020-03-10  22:36
 * @Version: 1.0
 */
public enum NodeColor {
    RED("红色"),
    BLACK("黑色");

    private String desc;

    NodeColor(String desc){
        this.desc = desc;
    }
}
