package HomeWork5;

public class MyHashSet<K, V> {
    private class Node {
        public Node next;
        public K key;
        public V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public String toString() {
            return this.key + ": " + this.value;
        }
    }

    private Node head = null;
    private int lenght = 0;

    public int lenght() {
        return lenght;
    }

    private Node getLastNode() {
        Node node = head;
        while (node.next != null) {
            node = node.next;
        }
        return node;
    }

    public void add(K key, V value) {
        lenght++;
        if (head == null) {
            head = new Node(key, value);
        } else {
            Node node = getLastNode();
            node.next = new Node(key, value);
        }
    }

    public V get(K key) {
        Node node = searchNode(key);
        if (node == null) {
            return null;
        } else {
            return node.value;
        }
    }

    private Node searchNode(K key) {
        if (head != null) {
            Node node = head;
            while (true) {
                if (node.key.equals(key)) {
                    return node;
                } else if (node.next != null) {
                    node = node.next;
                } else {
                    break;
                }
            }
        }
        return null;
    }

    public V remove(K key) {
        Node node = head;
        if (head.key.equals(key)) {
            head = head.next;
            return node.value;
        }
        while (true) {
            if (node == null || node.next == null) {
                return null;
            } else if (node.next.key.equals(key)) {
                lenght--;
                V value = node.next.value;
                node.next = node.next.next;
                return value;
            } else {
                node = node.next;
            }
        }
    }

    public String toString() {
        Node node = head;
        String string = "";
        while (node != null) {
            string += node.toString() + " | ";
            node = node.next;
        }
        return string;
    }
}
