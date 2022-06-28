import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args) {
        MyBinaryTree mTree = new MyBinaryTree(4);
        mTree.deleteNode(4);
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

        int height(Node root) {
            if (root == null) {
                return -1;
            }
            return Math.max(height(root.left), height(root.right)) + 1;
        }

        void deleteNode(int deleteVal) {
            if (root == null) {
                return;
            } else if (root.val == deleteVal && root.left == null && root.right == null) {
                root = null;
                return;
            } else {
                Node keyNode = null, lastNode = null, left = null, right = null;
                Queue<Node> q = new ArrayDeque<>();
                q.offer(root);
                while (!q.isEmpty()) {
                    lastNode = q.poll();
                    if (lastNode.val == deleteVal) {
                        keyNode = lastNode;
                    }
                    if (lastNode.left != null) {
                        q.offer(lastNode.left);
                        left = lastNode;
                        right = null;
                    }
                    if (lastNode.right != null) {
                        q.offer(lastNode.right);
                        right = lastNode;
                        left = null;
                    }

                }

                keyNode.val = lastNode.val;
                if (left != null) {
                    left.left = null;
                } else {
                    right.right = null;
                }
            }
        }

        void deleteTree() {
            root = null;
        }

    }

}