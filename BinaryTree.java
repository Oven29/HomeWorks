package HomeWork4;

public class BinaryTree {
    private Node root = null;

    public void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    public void delete(int value) {
        if (root.value == value) {
            root = null;
        }
        Node found = getParentNode(value);
        if (found != null) {
            if (found.left != null && found.left.value == value) {
                found.left = null;
            }
            if (found.right != null && found.right.value == value) {
                found.right = null;
            }
        }
    }

    private Node getParentNodeRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if ((current.left != null && current.left.value == value) ||
                (current.right != null && current.right.value == value)) {
            return current;
        }
        return value < current.value
                ? getParentNodeRecursive(current.left, value)
                : getParentNodeRecursive(current.right, value);
    }

    public Node getParentNode(int value) {
        return getParentNodeRecursive(root, value);
    }

    public void display() {
        Node node = root;
        recPrintTree(node);
    }

    private void recPrintTree(Node node) {
        System.out.println(node.value);
        if (node.left != null) {
            recPrintTree(node.left);
        }
        if (node.right != null) {
            recPrintTree(node.right);
        }
    }

    public class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }
}
