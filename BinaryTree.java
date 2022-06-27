import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        MyBinaryTree mTree = new MyBinaryTree(4);
        mTree.add(5);
        mTree.add(6);
        mTree.levelOrderTraversal();
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

    static class MyBinaryTree {
        private Node root;

        MyBinaryTree() {
        }

        MyBinaryTree(int rootVal) {
            Node tempNode = new Node(rootVal);
            this.root = tempNode;

        }

        void levelOrderTraversal() {
            if (root == null) {
                // System.out.println("Empty Tree");
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
                Queue<Node> q = new ArrayDeque<>();
                q.offer(root);
                while (!q.isEmpty()) {
                    Node current = q.poll();
                    if (current.left == null) {
                        current.left = tempNode;
                        return;
                    } else if (current.left != null && current.right == null) {
                        current.right = tempNode;
                        return;
                    } else {
                        q.offer(current.left);
                        q.offer(current.right);
                    }
                }

            }
        }

        boolean search(int searchVal) {
            if (root == null) {
                return false;
            }
            Queue<Node> q = new ArrayDeque<>();
            q.offer(root);
            while (!q.isEmpty()) {
                Node current = q.poll();
                if (current.val == searchVal) {
                    return true;
                } else {
                    if (current.left != null) {
                        q.offer(current.left);
                    }
                    if (current.right != null) {
                        q.offer(current.right);
                    }
                }
            }
            return false;
        }

        void deleteTree() {
            root = null;
        }

    }

}