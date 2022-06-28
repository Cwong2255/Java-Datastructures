import java.util.ArrayDeque;
import java.util.Queue;

public class BinarySearchTree {
    public static void main(String[] args) {
        MyBinarySearchTree bst = new MyBinarySearchTree();
        bst.levelOrderTraversal();
        System.out.println(bst.search(6));
    }

    static class Node {
        private Node left, right;
        private int val;

        Node() {

        }

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    static class MyBinarySearchTree {
        private Node root;

        MyBinarySearchTree() {

        }

        MyBinarySearchTree(int rootVal) {
            root = new Node(rootVal);
        }

        void levelOrderTraversal() {
            if (root == null) {
                return;
            }
            Queue<Node> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node current = q.poll();
                    System.out.print(current.val + " ");
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
                }
                System.out.println();
            }
        }

        void add(int insertVal) {
            Node tempNode = new Node(insertVal);
            if (root == null) {
                root = tempNode;
                return;
            } else {
                Node parent = null, current = root;
                while (current != null) {
                    parent = current;
                    if (insertVal >= current.val) {
                        current = current.right;
                    } else {
                        current = current.left;
                    }
                }
                if (insertVal >= parent.val) {
                    parent.right = tempNode;
                } else {
                    parent.left = tempNode;
                }
            }
        }

        boolean search(int searchVal) {
            if (root == null) {
                return false;
            } else {
                while (root != null) {
                    if (searchVal == root.val) {
                        return true;
                    } else if (searchVal < root.val) {
                        root = root.left;
                    } else {
                        root = root.right;
                    }
                }
                return false;
            }
        }

        void deleteTree() {
            root = null;
        }

        void deleteNode(int deleteVal) {

        }
    }
}