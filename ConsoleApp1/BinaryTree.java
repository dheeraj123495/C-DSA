public class BinaryTree {
    TreeNode root;
    public BinaryTree() {
        root = null;
    }
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public void insert(int data) {
        root = insertRec(root, data);
    }

    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }

        return root;
    }
    public void inorder() {
        inorderRec(root);
    }
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
    public void preOrder(){
        preOrderRec(root);
    }
    private void preOrderRec(TreeNode root){
        if (root != null){
            System.out.print(root.data + " ");
            preOrderRec(root.left);
            preOrderRec(root.right);
        }
    }
    public void postOrder(){
        postOrderRec(root);
    }
    private void postOrderRec(TreeNode root){
        if (root != null){
            preOrderRec(root.left);
            preOrderRec(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.inorder();  // Output: 20 30 40 50 60 70 80
        System.out.println("");
        tree.preOrder();
        System.out.println("");
        tree.postOrder();
    }
}
