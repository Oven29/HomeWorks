package HomeWork2;

public class MyLinkedList<E> {
    private class Node {
        public Node next;
        public E element;

        public Node(E element) {
            this.element = element;
            next = null;
        }

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }

        public String toString() {
            return this.element.toString() + ", ";
        }
    }

    private int lenght;
    private Node head;

    public MyLinkedList() {
        lenght = 0;
        head = null;
    }

    private Node getNode(int index) {
        if (index < 0 || index > lenght) {
            throw new IndexOutOfBoundsException();
        } else {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }
    }

    public int lenght() {
        return lenght;
    }

    public E get(int index) {
        return getNode(index).element;
    }

    public int indexof(Object obj) {
        Node node = head;
        for (int i = 0; i < lenght; i++) {
            if (obj.equals(node.element)) {
                return i;
            } else {
                node = node.next;
            }
        }
        return -1;
    }

    public void add(E element) {
        if (lenght == 0) {
            head = new Node(element);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(element);
        }
        lenght++;
    }

    public void add(E element, int index) {
        if (index < 0 || index > lenght) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            head = new Node(element, head);
        } else {
            Node node = getNode(index - 1);
            node.next = new Node(element, node.next);
        }
        lenght++;
    }

    public E remove(int index) {
        Node node;
        if (index < 0 || index >= lenght) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            node = head;
            head = head.next;
        } else if (index == lenght - 1) {
            node = getNode(lenght - 1);
            node.next = null;
        } else {
            Node curNode = getNode(index - 1);
            node = curNode.next;
            curNode.next = curNode.next.next;
        }
        lenght--;
        return node.element;
    }

    public boolean removeByElement(Object obj) {
        int index = indexof(obj);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public String toString() {
        if (lenght == 0) {
            return "[]";
        } else {
            String string = "[";
            Node node = head;
            for (int i = 0; i < lenght - 1; i++) {
                string += node.toString();
                node = node.next;
            }
            string += node.element.toString() + "]";
            return string;
        }
    }
}
