public class SinglyLinkedList {

    public static void main(String[] args) {
        MySinglyLinkedList newList = new MySinglyLinkedList();
        newList.add(0);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(1, 1);
        newList.printList();

    }

    static class Node {
        private int val;
        private Node next;

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

    static class MySinglyLinkedList {
        private Node head, tail;
        private int size;

        MySinglyLinkedList() {
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

        void add(int val) {
            Node tempNode = new Node(val, null);
            if (size == 0) {
                tail = tempNode;
                head = tempNode;
                size++;
            } else {
                head.next = tempNode;
                head = head.next;
                size++;
            }
        }

        void add(int val, int index) {
            if (index == 0) {
                addLast(val);
            } else if (index == size - 1) {
                addFirst(val);
            } else {
                // Debug this section, adding at a specific indexes don't work
                Node addNode = new Node(val);
                Node tempNode = tail;
                int currIndex = 0;
                while (tempNode != null) {
                    if (currIndex - 1 == index) {
                        addNode.next = tempNode.next;
                        tempNode.next = addNode;
                        size++;
                        break;
                    }
                    tempNode = tempNode.next;
                    currIndex++;
                }
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
                tail = tempNode;
                size++;
            }
        }

        int remove(int index) {
            if (index == 0) {
                return removeLast();
            } else if (index == size - 1) {
                return removeFirst();
            } else {
                // Debug this section, removing at a specific index does not work
                Node tempNode = tail;
                int currIndex = 0;
                while (tempNode != null) {
                    if (currIndex - 1 == index) {
                        int tempVal = tempNode.next.val;
                        tempNode.next = tempNode.next;
                        size--;
                        return tempVal;
                    }
                    tempNode = tempNode.next;
                    currIndex++;
                }
                return -1;
            }
        }

        int removeFirst() {
            if (size == 1) {
                int tempVal = head.val;
                head = new Node();
                tail = new Node();
                size--;
                return tempVal;
            } else if (size != 0) {
                Node tempNode = tail;
                int tempVal = 0;
                while (tempNode != null) {
                    if (tempNode.next.next == null) {
                        tempVal = tempNode.next.val;
                        head = tempNode;
                        head.next = null;
                        break;
                    }
                    tempNode = tempNode.next;
                }
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
            tail = new Node();
            head = new Node();
            size = 0;
        }

        void peek() {
            System.out.println(head.val);
        }

        int peekFirst() {
            return size == 0 ? head.val : null;
        }

        int peekLast() {
            return size == 0 ? tail.val : null;
        }

        int size() {
            return size;
        }

    }

}
