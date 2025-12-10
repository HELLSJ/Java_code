public class Test {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        BinaryTree.TreeNode root = binaryTree.createTree();

        System.out.println("===");

        System.out.println("节点个数:" +binaryTree.size(root));
        System.out.println("叶结点个数："+binaryTree.getLeafNodeCount(root));
        System.out.println("叶结点个数："+binaryTree.getLeafNodeCount2(root));
    }
}
