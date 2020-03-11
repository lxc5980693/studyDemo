package com.sihui.collection.tree;

/**
 * @ProjectName: collection-demo
 * @Package: com.sihui.collection.tree
 * @ClassName: BinaryTree
 * @Author: lixuanchen
 * @Description: 二叉搜索树的代码
 * @Date: 2020-03-10  20:46
 * @Version: 1.0
 */
public class LiBinarySearchTree {

    //节点数据
    int data;

    //左子树
    private LiBinarySearchTree left;
    //右子树
    private LiBinarySearchTree right;

    public LiBinarySearchTree(int data) {
        this.data = data;
    }

    /**
     * 添加操作
     *
     * @param root
     */
    public static void insert(LiBinarySearchTree root, int data) {
        //如果插入的数据比root值要大的话 则取右节点
        if (data > root.data) {
            //如果当前跟节点的右子树为null，第一次添加右子树
            if (root.right == null) {
                root.right = new LiBinarySearchTree(data);
            } else {
                //如果右子树有值，则使用递归添加
                insert(root.right, data);
            }
        } else {
            //如果添加的节点小于跟节点，则放入左边
            if (root.left == null) {
                root.left = new LiBinarySearchTree(data);
            } else {
                //如果存在左子树，则将当前左子树作为root节点继续递归插入
                insert(root.left, data);
            }
        }
    }

    public static void search(LiBinarySearchTree root) {
        if (root != null) {
            search(root.left);
            System.out.println(root.data);
            search(root.right);
        }
    }

    public static void main(String[] args) {
        int[] dataArr = {3, 6, 5, 2, 1, 4};
        LiBinarySearchTree root = new LiBinarySearchTree(dataArr[0]);
        for (int i = 1; i < dataArr.length; i++) {
            insert(root,dataArr[i]);
        }
        search(root);
    }

}
