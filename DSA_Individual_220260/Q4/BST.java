import java.util.ArrayList;

public class BST {
    /*
     * Skewed binary treee are bad for time complex
     * Balancing is good to make maximum use of bst
     * 
     * So AVL which is BST (Self balancing)
     * -Balancce Factor={-1,0,1}
     * -Balance Factor=height of left - height of right subtree
     */
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    ArrayList<Integer> inorderList = new ArrayList<>();

    Node createBST(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = createBST(root.left, data);
        } else if (data > root.data) {
            root.right = createBST(root.right, data);
        }
        return root;
    }

    void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        inorderList.add(root.data);
        inOrder(root.right);
    }

    Node deleteNode(Node root, int data) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = deleteNode(root.left, data);
        } else if (data > root.data) {
            root.right = deleteNode(root.right, data);
        } else {
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            int minVal = findMin(root.right); // min i.e. successor
            root.data = minVal; // add breakpoint here i dont undersand
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }

    int findMin(Node node) {
        if (node == null) {
            return -1;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    Node findNode(int element, Node root) {
        if (element == root.data) {
            return root;
        }
        if (element > root.data) {
            root = findNode(element, root.right);
        } else {
            root = findNode(element, root.left);
        }
        return root;
    }

    public static void main(String[] args) {
        BST t = new BST();
        Node root = t.createBST(null, 40);
        root = t.createBST(root, 20);
        root = t.createBST(root, 60);
        root = t.createBST(root, 30);
        t.inOrder(root);
        // BST inorder is sorted ascending
        System.out.println(t.findNode(20, root).data);

    }
}
