public class Stack {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.print("Stack : ");
        int stackSize = stack.size();
        for (int i = 0; i < stackSize; i++) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
        MyQueue queue = new MyQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        System.out.print("Queue : ");
        int queueSize = queue.size();
        for (int i = 0; i < queueSize; i++) {
            System.out.print(queue.remove() + " ");
        }

    }

    static class MyQueue {
        private DoublyLinkedList list;

        MyQueue() {
            list = new DoublyLinkedList();
        }

        void add(int val) {
            list.add(val);
        }

        int remove() {
            return list.removeLast();
        }

        void peek() {
            list.peekLast();
        }

        int size() {
            return list.size;
        }

    }

    static class MyStack {
        private DoublyLinkedList list;

        MyStack() {
            list = new DoublyLinkedList();
        }

        void push(int val) {
            list.add(val);
        }

        void peek() {
            list.peek();
        }

        int pop() {
            return list.removeFirst();
        }

        boolean isEmpty() {
            return list.size == 0;
        }

        boolean search(int val) {
            return list.contains(val);
        }

        int size() {
            return list.size;
        }

    }

    static class Node {
        private Node next, prev;
        private int val;

        Node() {
        };

        Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }

        Node(int val, Node prev, Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    static class DoublyLinkedList {
        private Node head, tail;
        private int size;

        DoublyLinkedList() {
            head = new Node();
            tail = new Node();
            size = 0;
        }

        void printList() {
            if (size != 0) {
                Node tempNode = tail;
                while (tempNode != null) {
                    if (tempNode.next == null) {
                        System.out.print(tempNode.val);
                        break;
                    }
                    System.out.print(tempNode.val + " -> ");
                    tempNode = tempNode.next;
                }
            }
        }

        void reversePrintList() {
            if (size != 0) {
                Node tempNode = head;
                while (tempNode != null) {
                    if (tempNode.prev == null) {
                        System.out.print(tempNode.val);
                        break;
                    }
                    System.out.print(tempNode.val + " -> ");
                    tempNode = tempNode.prev;
                }
            }
        }

        void add(int val) {
            Node tempNode = new Node(val, null, null);
            if (size == 0) {
                head = tempNode;
                tail = tempNode;
                size++;
            } else {
                tempNode.prev = head;
                head.next = tempNode;
                head = tempNode;
                size++;
            }
        }

        void addFirst(int val) {
            add(val);
        }

        void addLast(int val) {
            Node tempNode = new Node(val, null, null);
            if (size == 0) {
                add(val);
                size++;
            } else {
                tempNode.next = tail;
                tail.prev = tempNode;
                tail = tempNode;
                size++;
            }
        }

        int removeFirst() {
            int tempVal = head.val;
            if (size == 1) {
                head = new Node();
                tail = new Node();
                size--;
                return tempVal;
            } else if (size != 0) {
                head = head.prev;
                head.next = null;
                size--;
                return tempVal;
            } else {
                return -1;
            }
        }

        int removeLast() {
            if (size == 1) {
                return removeFirst();
            } else if (size != 0) {
                int tempVal = tail.val;
                tail = tail.next;
                tail.prev = null;
                size--;
                return tempVal;
            } else {
                return -1;
            }
        }

        boolean contains(int val) {
            if (size != 0) {
                Node tempNode = tail;
                while (tempNode != null) {
                    if (tempNode.val == val) {
                        return true;
                    }
                    tempNode = tempNode.next;
                }
                return false;
            } else {
                return false;
            }
        }

        void clear() {
            head = new Node();
            tail = new Node();
            size = 0;
        }

        void peek() {
            System.out.println(head.val);
        }

        void peekFirst() {
            peek();
        }

        void peekLast() {
            System.out.println(tail.val);
        }

    }

}
