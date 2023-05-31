package HomeWork3;

public class MyBinaryTree<E> {
    private class Node {
        public E element;
        public Node left;
        public Node right;

        public Node(E element) {
            this.element = element;
            left = null;
            right = null;
        }
    }

    private int size = 0;
    private Node root = null;

    public int lenght() {
        return size;
    }

    private Node findNode(Object element) {
        Node curNode = root;
        Comparable<E> cElement = (Comparable<E>) element;
        while (curNode != null) {
            int cmp = cElement.compareTo(curNode.element);
            if (cmp < 0) {
                curNode = curNode.left;
            } else if (cmp > 0) {
                curNode = curNode.right;
            } else if (cmp == 0) {
                return curNode;
            }
        }
        return null;
    }

    private Node findParent(Object element) {
        Comparable<E> cElement = (Comparable<E>) element;
        Node child = root;
        Node parent = root;
        while (child != null) {
            int cmp = cElement.compareTo(child.element);
            if (cmp < 0) {
                parent = child;
                child = child.left;
            } else if (cmp > 0) {
                parent = child;
                child = child.right;
            } else if (cmp == 0) {
                return parent;
            }
        }
        return null;
    }

    public boolean contains(Object element) {
        Node curNode = findNode(element);
        if (curNode == null) {
            return false;
        } else {
            return true;
        }
    }

    public void add(E element) {
        if (root == null) {
            root = new Node(element);
            size++;
        } else {
            addHelper(element, root);
        }
    }

    private void addHelper(E element, Node node) {
        Comparable<E> cElement = (Comparable<E>) element;
        int cmp = cElement.compareTo(node.element);
        if (cmp <= 0) {
            if (node.left == null) {
                node.left = new Node(element);
                size++;
            } else {
                addHelper(element, node.left);
            }
        } else if (cmp > 0) {
            if (node.right == null) {
                size++;
                node.right = new Node(element);
            } else {
                addHelper(element, node.right);
            }
        }
    }

    public E remove(Object element) {
        Node child = findNode(element);
        if (child == null) {
            return null;
        } else if (size == 1) {
            root = null;
            size--;
            return child.element;
        } else {
            Node parent = findParent(element);
            if (child.left != null && child.right != null) {
                Node preemnik = findPreemnik(child.right);
                Node preParent = findParent(preemnik.element);
                removeHelper(preemnik, preParent);
                E oldElement = child.element;
                child.element = preemnik.element;
                return oldElement;
            } else if (child == root) {
                if (child.left != null)
                    root = child.left;
                if (child.right != null)
                    root = child.right;
                size--;
                return child.element;
            } else {
                return removeHelper(child, parent);
            }
        }
    }

    private E removeHelper(Node child, Node parent) {
        if (child.left == null && child.right == null) {
            if (parent.left == child)
                parent.left = null;
            if (parent.right == child)
                parent.right = null;
            size--;
            return child.element;
        } else if (child.left == null) {
            if (parent.left == child)
                parent.left = child.right;
            if (parent.right == child)
                parent.right = child.right;
            size--;
            return child.element;
        } else if (child.right == null) {
            if (parent.left == child)
                parent.left = child.left;
            if (parent.right == child)
                parent.right = child.left;
            size--;
            return child.element;
        }
        return null;
    }

    private Node findPreemnik(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty!");
        } else {
            System.out.println("Root is value " + root.element);
            LER(root);
        }
    }

    private void LER(Node node) {
        if (node.left != null)
            LER(node.left);
        System.out.println(node.element);
        if (node.right != null)
            LER(node.right);
    }
}
