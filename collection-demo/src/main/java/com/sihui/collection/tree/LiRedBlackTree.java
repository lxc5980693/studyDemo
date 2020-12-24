package com.sihui.collection.tree;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.tree
 * @ClassName: RedBlackTree
 * @Author: lixuanchen
 * @Description: 红黑树
 * @Date: 2020-03-10  22:31
 * @Version: 1.0
 */
public class LiRedBlackTree {

    /**
     * 记录当前的根节点
     */
    private Node root;

    /**
     * 添加节点
     *
     * @param value
     */
    public void insert(int value) {
        if (root == null) {
            //说明当前没有根节点，创建根节点
            Node node = new Node();
            //父节点为空
            node.parent = null;
            //根节点颜色为黑色
            node.color = NodeColor.BLACK;
            node.value = value;
            root = node;
        } else {
            //如果存在根节点的话
            Node node = insertValue(value);
            //当前节点处理成功之后，开始对当前节点进行变色或者旋转 修复
            repaireTree(node);
        }
    }

    /**
     * 修复节点
     * @param newNode   插入的当前节点
     */
    private void repaireTree(Node newNode){
        /**
         * 判断是否需要变颜色，变颜色的规则是
         * 父亲节点是红色节点、且叔叔节点也是红色节点
         * 操作是：
         * 将父亲节点和叔叔节点都设置为黑色
         * 将祖父节点设置为红色
         * 把指针定义到祖父节点设为当前操作
         */
        if (NodeColor.RED.equals(newNode.parent.color)){
            //爷爷节点
            Node g = newNode.parent.parent;
            //父亲节点
            Node p = newNode.parent;
            //获取叔叔节点
            Node u;
            if (g.left == p){
                u = g.right;
            }else{
                u = g.left;
            }
            /**
             * 场景一：当父亲节点为红色，叔叔节点为黑色或者是null，且当前节点为右子节点的情况下，开始左旋
             */
            if (u == null || NodeColor.BLACK.equals(u.color)){
                if (p.right == newNode){
                    //左旋
                    leftRetate(g);
                    //修复颜色的问题
                    p.color = NodeColor.BLACK;
                    g.color = NodeColor.RED;
                    return;
                }
            }
            /**
             * 场景二：当父亲节点为红色，且叔叔节点为也为红色，则进行变色操作
             * 操作：将父亲节点变为黑色、将叔叔节点变为黑色、将爷爷节点变为红色、并且把指针指向爷爷节点
             */
            if (u != null && NodeColor.RED.equals(u.color)){
                p.color = NodeColor.BLACK;
                u.color = NodeColor.BLACK;
                if (g != root){
                    g.color = NodeColor.RED;
                }
            }
        }
    }

    /**
     * 规则：左旋：（当前节点为插入的值）当父亲节点为红色情况，叔叔的节点为黑色的情况，且当前的节点是右子树，
     *      操作：左旋转以当前节点的父节点节点（当前节点为相连的两红节点中的父节点）作为左旋；当前节点上移，
     *           父亲节点往左下移动，然后父亲节点的右子节点为当前节点的左节点。
     * @param x  当前节点在父节点上（当前节点为相连的两红节点中的父节点）
     */
    private void leftRetate(Node x){
        /**
         * 两红相连，指针处于在父节点上
         */
        //当前两红节点的父节点
        Node y = x.right;
        Node c = y.left;
        x.right = c;
        //如果左旋成功之后，c节点的父亲节点变为当前旋转的节点
        if (c != null){
            c.parent = x;
        }

        //如果x的父节点不存在的话，表示x为根节点，如果x节点左旋的话，y节点要上位，所以要判断
        if (x.parent == null){
            root = y;
        }else{
            if (x.parent.left == x){
                //确定x为左子树
                x.parent.left = y;
            }else {
                //确认x为右子树
                x.parent.right = y;
            }
            y.parent = x.parent;
        }
        //x父节点为y
        x.parent = y;

        //y的左节点为x
        y.left = x;

    }

    /**
     * 插入并且返回节点
     * @param value
     * @return
     */
    private Node insertValue(int value) {
        return getPosition(root, value);
    }

    /**
     * 插入并返回当前节点的位置
     *
     * @param node
     * @param value
     * @return
     */
    private Node getPosition(Node node, int value) {
        if (value < node.value) {
            //存放左子树
            if (node.left == null) {
                //存放在右节点
                Node node1 = new Node();
                //父节点为空
                node1.parent = node;
                //节点默认颜色为红色
                node1.color = NodeColor.RED;
                node1.value = value;
                //设置父亲节点的右节点为当前节点
                node.left = node1;
                return node1;
            } else {
                return getPosition(node.left, value);
            }
        } else {
            //存放右子树
            if (node.right == null) {
                //存放在右节点
                Node node1 = new Node();
                //父节点为空
                node1.parent = node;
                //节点默认颜色为红色
                node1.color = NodeColor.RED;
                node1.value = value;
                //设置父亲节点的右节点为当前节点
                node.right = node1;
                return node1;
            } else {
                return getPosition(node.right, value);
            }
        }
    }

    private int getMaxValue(Node root){
        if (root.right != null){
            return getMaxValue(root.right);
        }else {
            return root.value;
        }
    }

    public static void main(String[] args) {
        LiRedBlackTree liRedBlackTree = new LiRedBlackTree();
        liRedBlackTree.insert(1);
        liRedBlackTree.insert(2);
        liRedBlackTree.insert(3);
        liRedBlackTree.insert(4);
        liRedBlackTree.insert(5);
        System.out.println(liRedBlackTree.getMaxValue(liRedBlackTree.root));
    }

    class Node {
        /**
         * 存的值
         */
        private int value;
        /**
         * 左子树
         */
        private Node left;
        /**
         * 右子树
         */
        private Node right;
        /**
         * 节点颜色
         */
        private NodeColor color;
        /**
         * 记录当前节点的父节点，如果没有父节点的情况下一定是根节点
         */
        private Node parent;
    }

}
