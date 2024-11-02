import java.util.LinkedList;
import java.util.Queue;

public class practise {
    static class Node{
        int value;
        Node leftNode;
        Node rightNode;

        Node(int key){
            value = key;
            leftNode = rightNode = null;
        }
    }
    static class BinaryTree{
        static int index = -1;
        public static Node createNode(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.leftNode = createNode(nodes);
            newNode.rightNode = createNode(nodes);
            return newNode;
        }
    }
    public static void preOrder(Node root){
        if (root == null){
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.leftNode);
        preOrder(root.rightNode);
    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        preOrder(root.leftNode);
        preOrder(root.rightNode);
        System.out.print(root.value + " ");
    }
    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.leftNode);
        System.out.print(root.value + " ");
        inOrder(root.rightNode);
    }
    public static void levelOrder(Node root){
        if(root == null)
            return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()){
            Node curNode = q.remove();
            if(curNode == null){
                System.out.println();
                if (q.isEmpty()){
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                System.out.print(curNode.value + " ");
                if(curNode.leftNode != null){
                    q.add(curNode.leftNode);
                }
                if (curNode.rightNode != null){
                    q.add(curNode.rightNode);
                }
            }
        }
    }
    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = countOfNodes(root.leftNode);
        int rightCount = countOfNodes(root.rightNode);
        return leftCount+rightCount+1;
    }
    public static int sumOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftCount = sumOfNodes(root.leftNode);
        int rightCount = sumOfNodes(root.rightNode);
        return leftCount+rightCount+root.value;
    }
    public static int heigth(Node root){
        if(root == null){
            return 0;
        }
        int leftHeigth = heigth(root.leftNode);
        int rightHeight = heigth(root.rightNode);
        int totHeight = Math.max(leftHeigth,rightHeight) + 1;
        return totHeight;
    }
    public static int diameter(Node root){
        if(root == null){
            return 0;
        }
        int dia1 = diameter(root.leftNode);
        int dia2 = diameter(root.rightNode);
        int dia3 = heigth(root.leftNode) + heigth(root.rightNode) + 1;
        return Math.max(dia3,Math.max(dia1,dia2));
    }
    public static void main(String[] args){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root= tree.createNode(nodes);
        System.out.println(root.value);
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println("Count of nodes : " + countOfNodes(root));
        System.out.println("Sum of nodes : " + sumOfNodes(root));
        System.out.println("Height of tree : " + heigth(root));
        System.out.println("Diameter of tree : " + diameter(root));
    }
}
