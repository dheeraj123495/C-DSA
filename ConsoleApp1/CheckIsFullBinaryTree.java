public class CheckIsFullBinaryTree {
    TreeNode root;
    class TreeNode{
        int data;
        TreeNode right;
        TreeNode left;
        TreeNode(int data){
            this.data = data;
            this.right = this.left = null;
        }
    }
    public void insert(int data){
        root = insertRec(root,data);
    }
    private TreeNode insertRec(TreeNode root,int data){
        if (root == null){
            root = new TreeNode(data);
            return root;
        }
            if (data < root.data){
                root.left = insertRec(root.left,data);
            } else if (data > root.data){
                root.right = insertRec(root.right,data);
            }
            return root;
    }
    public boolean isFullBinary(){
        boolean isBinary = isFullBinaryTreeRec(root);
        return isBinary;
    }
    public boolean isFullBinaryTreeRec(TreeNode root){
        if (root == null){
            return true;
        }
        if (root.left == null && root.right == null){
            return true;
        }
        if ((root.left!=null) && (root.right!=null)){
            return (isFullBinaryTreeRec(root.left) && isFullBinaryTreeRec(root.right));
        }
        return false;
    }
    public static void main(String[] args){
        CheckIsFullBinaryTree tree = new CheckIsFullBinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.insert(10);

        System.out.println(tree.isFullBinary());
    }
}
