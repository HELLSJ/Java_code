import sun.reflect.generics.tree.Tree;

import java.util.*;

public class BinaryTree {
    static class TreeNode{
        public char val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(char val) {
            this.val = val;
        }
    }

    public TreeNode root;
    //创建一棵二叉树，创建成功后返回根结点
    public TreeNode createTree(){
        TreeNode A = new TreeNode('A');
        TreeNode B = new TreeNode('B');
        TreeNode C = new TreeNode('C');
        TreeNode D = new TreeNode('D');
        TreeNode E = new TreeNode('E');
        TreeNode F = new TreeNode('F');
        TreeNode G = new TreeNode('G');
        TreeNode H = new TreeNode('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        E.right = H;

        return A;
    }

    // 前序遍历
    void preOrder(TreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    
    //把前序遍历的结果存储到List当中

//    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> list = new ArrayList<>();
//        if(root == null){
//            return list;
//        }
//        list.add(root.val);
//        List<Integer> leftTree = preorderTraversal(root.left);
//        list.addAll(leftTree);
//
//        List<Integer> rightTree = preorderTraversal(root.right);
//        list.addAll(rightTree);
//        return list;
//    }
    // 中序遍历
    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.val + " ");
        inOrder(root.right);
    }
    void inOrderNor(TreeNode root){
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //这里得先弹出元素再打印
            TreeNode top = stack.pop();
            System.out.print(top.val + " ");
            cur = top.right;
        }
    }
    // 后序遍历
    void postOrder(TreeNode root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.val + " ");
    }
    void postOrderNor(TreeNode root){
        if(root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        TreeNode prev = null;
        while(cur != null || !stack.isEmpty()){
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            TreeNode top = stack.peek();
            if(top.right == null || top.right == prev){
                System.out.println(top.val + " ");
                stack.pop();
                prev = top;
            }else{
                cur = top.right;
            }
        }
    }

    public int nodeSize = 0;
    int size(TreeNode root){
        if(root == null){
            return 0;
        }
        nodeSize++;
        size(root.left);
        size(root.right);
        return nodeSize;
    }

    int size2(TreeNode root){
        if(root == null){
            return 0;
        }
        return size2(root.left) + size2(root.right) + 1;
    }
    // 获取叶子节点的个数
    //遍历思路
    public int leafNode = 0;
    int getLeafNodeCount(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            leafNode++;
        }
        getLeafNodeCount(root.left);
        getLeafNodeCount(root.right);
        return leafNode;
    }
    //子树相加思路
    int getLeafNodeCount2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLeafNodeCount2(root.left) + getLeafNodeCount2(root.right);
    }

    // 获取第K层节点的个数
    public int nodeCount = 0;
    int getKLevelNodeCount(TreeNode root,int k){
        if(root == null){
            return 0;
        }
        if(k == 1){
            return 1;
        }
        return getKLevelNodeCount(root.left,k-1) + getKLevelNodeCount(root.right,k-1);
    }

    int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        return leftHeight > rightHeight ? leftHeight + 1 : rightHeight + 1;
    }

    int getHeight2(TreeNode root){
        if(root == null){
            return 0;
        }

        return getHeight2(root.left) > getHeight2(root.right)
                ? getHeight2(root.left) + 1 : getHeight2(root.right) + 1;
    }

    TreeNode find(TreeNode root, int val){
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode ret = find(root.left, val);
        if(ret != null){
            return ret;//这样就不用去右边了
        }
        TreeNode ret2 = find(root.right,val);
        if(ret2 != null){
            return ret2;
        }
        return null;
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return isSymmetricChild(root.left,root.right);
    }


    private boolean isSymmetricChild(TreeNode leftTree, TreeNode rightTree){
        if((leftTree != null && rightTree == null) || (leftTree == null && rightTree != null)){
            return false;
        }
        if(leftTree == null && rightTree == null){
            return true;
        }
        if(leftTree.val != rightTree.val){
            return false;
        }
        return isSymmetricChild(leftTree.left,rightTree.right)
                && isSymmetricChild(leftTree.right,rightTree.left);
    }
    //层序遍历
    void levelOrder(TreeNode root){
        if(root == null){
            return ;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            System.out.println(cur.val + " ");

            if(cur.left != null){
                queue.offer(cur.left);
            }
            if(cur.right!= null){
                queue.offer(cur.right);
            }
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if(root == null){
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while(size != 0){
                TreeNode cur = queue.poll();
                tmp.add(cur.val);
                size--;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right!= null){
                    queue.offer(cur.right);
                }
            }
            ret.add(tmp);
        }
        return ret;
    }
    // 判断一棵树是不是完全二叉树
    boolean isCompleteTree(TreeNode root){
        if(root == null){
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur!=null){
                queue.offer(cur.left);
                queue.offer(cur.right);
            }else{
                break;//结束循环
            }
        }
        //代码走到这是把元素都入队了，包括null
        //需要判断队列中是否有空的元素
        while(!queue.isEmpty()){
            //一个元素一个元素出队来判断是不是空
            //把null弹出，如果遇到不是null的元素就返回错误
            TreeNode tmp = queue.peek();
            if(tmp == null){
                queue.poll();
            }else{
                return false;
            }
        }
        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        if(root == p || root == q){
            return root;
        }
        TreeNode leftTree = lowestCommonAncestor(root.left,p,q);
        TreeNode rightTree = lowestCommonAncestor(root.right,p,q);

        if(leftTree != null && rightTree != null){
            return root;
        }else if(leftTree != null){
            return leftTree;
        }else{
            return rightTree;
        }
    }

}
