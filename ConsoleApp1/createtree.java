import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

public class createtree {
    static class Node{
        int value;
        Node left;
        Node right;
        Node(int key){
            value = key;
            left = right = null;
        }
    }
    static class BinaryTree{
        static int index = -1;
        public static Node buildTree(int[] nodes){
            index++;
            if(nodes[index] == -1){
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }
    }

    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.value + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.value + " ");
        inOrder(root.right);
    }
    public static void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.value + " ");
    }

    public static void levelOrder(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }
                else {
                    q.add(null);
                }
            }
            else {
                System.out.print(currNode.value + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if (currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countOfNodes(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countOfNodes(root.left);
        int rightNodes = countOfNodes(root.right);
        return leftNodes+rightNodes+1;
    }
    public static int sumOfNodes(Node root){
        if (root == null){
            return 0;
        }
        int leftSum = sumOfNodes(root.left);
        int rightSum = sumOfNodes(root.right);

        return leftSum+rightSum+root.value;
    }
    public static int heigth(Node root){
        if(root == null){
            return 0;
        }
        int leftHeigth = heigth(root.left);
        int rightHeight = heigth(root.right);
        int myHeight = Math.max(rightHeight,rightHeight) + 1;
        return myHeight;
    }
    public static int diameter(Node root){
        if (root == null){
            return 0;
        }
        int diam1 = diameter(root.left);
        int diam2 = diameter(root.right);
        int diam3 = heigth(root.left) + heigth(root.right) + 1;

        return Math.max(diam3, Math.max(diam1,diam2));
    }
    public static void main(String args[]){
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.value);
        preOrder(root);
        System.out.println("");
        inOrder(root);
        System.out.println("");
        postOrder(root);
        System.out.println();
        levelOrder(root);
        System.out.println("Count of nodes : " + countOfNodes(root));    //Time complexity - O(n)
        System.out.println("Sum of nodes : " + sumOfNodes(root));    //Time complexity - O(n)
        System.out.println("Height of the tree : " + heigth(root));
        //Diameter of a tree -- Number of nodes in the longest path between any 2 nodes
        System.out.println("Diameter of the tree : " + diameter(root));

    }
}
