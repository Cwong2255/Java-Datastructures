public class CircularlyDoublyLinkedList {
    public static void main(String[] args) {
        MyCircularlyDoublyLinkedList newList = new MyCircularlyDoublyLinkedList();
        newList.add(1);
        newList.add(2);
        newList.add(2);
        newList.add(3);
        
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

    static class MyCircularlyDoublyLinkedList {
        private Node head, tail;
        private int size;

        MyCircularlyDoublyLinkedList() {
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

        void reversePrintList() {
            if (size != 0) {
                Node tempNode = head;
                while (true) {
                    if (tempNode == tail) {
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
                head = tail = tempNode;
                head.prev = head.next = head;
                size++;
            } else {
                head.next = tempNode;
                tempNode.prev = head;
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
            } else {
                Node tempNode = new Node(val);
                tempNode.next = tail;
                tail.prev = tempNode;
                tail = tempNode;
                tail.prev = head;
                size++;
            }
        }

        int removeFirst() {
            if (size != 0) {
                int tempVal = head.val;
                head = head.prev;
                head.next = tail;
                tail.prev = head;
                size--;
                return tempVal;
            } else {
                return -1;
            }
        }

        // Debug this method
        int removeFirstOccurence(int val) {
            if (size != 0) {
                Node tempNode = tail;
                while (true) {
                    if (tempNode.next.val == val) {
                        tempNode.next = tempNode.next.next;
                        tempNode.next.next.prev = tempNode;
                        size--;
                        return val;
                    } else if (tempNode == head) {
                        break;
                    }
                    tempNode = tempNode.next;
                }
                return -1;
            } else {
                return -1;
            }
        }

        int removeLast() {
            if (size != 0) {
                int tempVal = tail.val;
                tail = tail.next;
                tail.prev = head;
                head.next = tail;
                size--;
                return tempVal;
            } else {
                return -1;
            }
        }

        // Add a remove last occurence method

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
            tail = null;
            head = null;
            size = 0;
        }

        void peek() {
            System.out.println(head.val);
        }

        void peekFirst() {
            peek();
        }

        void peekFirstPrev() {
            System.out.println(head.prev.val);
        }

        void peekLast() {
            System.out.println(tail.val);
        }

        void peekLastNext() {
            System.out.println(tail.next.val);
        }

    }
}
