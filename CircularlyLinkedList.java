
public class CircularlyLinkedList {
    public static void main(String[] args) {
        MyCircularlyLinkedList newList = new MyCircularlyLinkedList();
        newList.add(1);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(5);
        newList.printList();
    }

    static class Node {
        private Node next;
        private int val;

        Node() {
        };

        Node(int val) {
            this.val = val;
            this.next = null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    static class MyCircularlyLinkedList {
        private Node head, tail;
        private int size;

        MyCircularlyLinkedList() {
            head = null;
            tail = null;
            size = 0;
        }

        void printList() {
            if (size != 0) {
                Node tempNode = tail;
                while (true) {
                    if (tempNode == head) {
                        System.out.print(tempNode.val);
                        break;
                    }
                    System.out.print(tempNode.val + " -> ");
                    tempNode = tempNode.next;
                }
            }
        }

        void add(int val) {
            Node tempNode = new Node(val);
            if (size == 0) {
                head = tempNode;
                tail = tempNode;
                size++;
            } else {
                head.next = tempNode;
                head = tempNode;
                head.next = tail;
                size++;
            }
        }

        void addFirst(int val) {
            add(val);
        }

        void addLast(int val) {
            if (size == 0) {
                add(val);
                size++;
            } else {
                Node tempNode = new Node(val);
                tempNode.next = tail;
                tail = tempNode;
                head.next = tail;
                size++;
            }
        }

        int removeFirst() {
            if (size != 0) {
                Node tempNode = tail;
                int tempVal;
                while (true) {
                    if (tempNode.next.next == tail) {
                        tempVal = tempNode.next.val;
                        head = tempNode;
                        head.next = tail;
                        size--;
                        break;
                    }
                    tempNode = tempNode.next;
                }
                return tempVal;
            } else {
                return -1;
            }
        }

        int removeLast() {
            if (size != 0) {
                int tempVal = tail.val;
                tail = tail.next;
                head.next = tail;
                size--;
                return tempVal;
            } else {
                return -1;
            }
        }

        boolean contains(int val) {
            if (size != 0) {
                Node tempNode = tail;
                while (true) {
                    if (tempNode.val == val) {
                        return true;
                    } else if (tempNode == head) {
                        break;
                    }
                    tempNode = tempNode.next;
                }
                return false;
            } else {
                return false;
            }
        }

        void clear() {
            head = null;
            tail = null;
            size = 0;
        }

        void peek() {
            System.out.println(head.val);
        }

        void peekFirst() {
            System.out.println(head.val);
        }

        void peekLast() {
            System.out.println(tail.val);
        }

    }

}
