public class DoublyLinkedList {
    public static void main(String[] args) {
        MyDoublyLinkedList newList = new MyDoublyLinkedList();
        newList.add(0);
        newList.add(2);
        newList.add(3);
        newList.add(4);
        newList.add(5);
        newList.add(1, 1);
        System.out.println(newList.get(1));
        newList.printList();
        System.out.println();
        newList.reversePrintList();
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

    static class MyDoublyLinkedList {
        private Node head, tail;
        private int size;

        MyDoublyLinkedList() {
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

        int get(int index) {
            if (size != 0) {
                if (index == 0) {
                    return tail.val;
                } else if (index == size - 1) {
                    return head.val;
                } else {
                    Node tempNode = tail.next;
                    int currentIndex = 1;
                    while (tempNode != null) {
                        if (currentIndex == index) {
                            return tempNode.val;
                        }
                        tempNode = tempNode.next;
                        currentIndex++;
                    }
                    return -1;
                }
            } else {
                return -1;
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

        void add(int val, int index) {
            if (index == 0) {
                addLast(val);
            } else if (index == size) {
                add(val);
            } else {
                Node tempNode = tail.next;
                Node insertNode = new Node(val);
                int currentIndex = 1;
                while (tempNode != null) {
                    if (currentIndex == index) {
                        insertNode.prev = tempNode.prev;
                        tempNode.prev.next = insertNode;
                        tempNode.prev = insertNode;
                        insertNode.next = tempNode;
                        size++;
                        break;
                    }
                    tempNode = tempNode.next;
                    currentIndex++;
                }
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

        int remove(int index) {
            if (index == 0) {
                return removeLast();
            } else if (index == size - 1) {
                return removeFirst();
            } else {
                Node tempNode = tail.next;
                int currentIndex = 1;
                while (tempNode != null) {
                    if (currentIndex == index) {
                        int tempVal = tempNode.val;
                        tempNode.prev.next = tempNode.next;
                        tempNode.next.prev = tempNode.prev;
                        size--;
                        return tempVal;
                    }
                    tempNode = tempNode.next;
                    currentIndex++;
                }
                return -1;
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
            size--;
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
