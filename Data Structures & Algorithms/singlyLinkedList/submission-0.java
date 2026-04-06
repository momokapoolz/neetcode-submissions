class LinkedList {
    class Node {
        int value;
        Node next;

        Node(int value) {
           this.value = value;
           this.next = null;
        }
    }

    Node head;
    Node tail;
    int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
    if (index < 0 || index >= size) {
        return -1;
    }

    Node current = head;
    for (int i = 0; i < index; i++) {
        current = current.next;
    }
    return current.value;
}

    public void insertHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode; 
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void insertTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size) {
            return false;
        }

        if (index == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return true;
        }

        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        prev.next = prev.next.next;
        if (index == size - 1) {
            tail = prev;
        }
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        Node current = head;
        ArrayList<Integer> arr = new ArrayList<>();

        while (current != null) {
            arr.add(current.value);
            current = current.next;
        }

        return arr;
    }
}
