package binarysearchtree;

import sun.reflect.generics.tree.Tree;

public class BinarySearchTree {
    static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }
    public TreeNode root;
    public boolean search(int key){
        TreeNode cur = root;
        while(cur != null){
            if(cur.val < key){
                cur = cur.right;
            } else if (cur.val>key) {
                cur = cur.left;
            }else{
                return true;
            }
        }
        return false;
    }
    public boolean insert(int val){
        if(root == null){
            root = new TreeNode(val);
            return true;
        }
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur!=null){
            if(cur.val < val){
                parent = cur;
                cur = cur.right;
            }else if(cur.val > val){
                parent = cur;
                cur = cur.left;
            }else{
                return false;
            }
        }
        TreeNode node = new TreeNode(val);
        if(parent.val>val){
            parent.left = node;
        }else{
            parent.right = node;
        }
        return true;
    }
    public void remove(int val){
        TreeNode cur = root;
        TreeNode parent = null;
        while(cur!=null){
            if(cur.val < val){
                parent = cur;
                cur = cur.right;
            }else if(cur.val > val){
                parent = cur;
                cur = cur.left;
            }else{
                //开始删除
                removeNode(cur,parent);
                }
            }
        }

    private void removeNode(TreeNode cur, TreeNode parent) {
        if(cur.left == null){
            if(cur == root){
                root = parent.right;
            }else if(cur == parent.left){
                parent.right = cur.left;
            }else{
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            if(cur == root){
                root = parent.left;
            }else if(cur == parent.left){
                parent.left = cur.left;
            }else{
                parent.right = cur.left;
            }
        }else{
            //找到合适的值（从右子树找最小值）
            //target负责找到合适值，targetParent负责记录target的双亲结点
            TreeNode targetParent = cur;
            TreeNode target = cur;
            while(target.left != null){
                targetParent = target;
                target = target.left;
            }
            cur.val = target.val;

            //删除target，因为已经到最左边了，所以直接让parent的左边 = target的右边
            //就算右边为空也没关系
            if(targetParent.left == target){
                targetParent.left = target.right;
            }else{
                targetParent.right = target.right;
            }
        }
    }
}

