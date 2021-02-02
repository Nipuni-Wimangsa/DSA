public class Tree {
    private class Node {
        private int value;
        private Node leftChild, rightChild;

        public Node (int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node = " + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if(root == null) {
            root = node;
            return;
        }

        Node current = root;
        while (true) {
            if(value > current.value) {
                if(current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
            else {
                if(current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }
        }
    }

    public boolean find(int value) {
        Node current = root;

        while(current != null) {
            if(value == current.value)
                return true;

            if(value > current.value)
                current = current.rightChild;
            else
                current = current.leftChild;
        }

        return false;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if(root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if(root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if(root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    private boolean isLeaf(Node root) {
        return (root.rightChild == null && root.leftChild == null);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if(root == null)
            return -1;

        if(isLeaf(root))
            return 0;

        return 1 + Math.max(height(root.leftChild), height(root.rightChild));
    }

    public int min() {
        return min(root);
    }

    /* this is used for binary search trees
    time complexity = O(log n)
    because this only use half of the nodes to search */
    private int minimum(Node root) {
        if(root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;

        while (current != null) {
            last = current;
            current = current.leftChild;
        }

        return last.value;
    }

    /* this is used for binary trees
     time complexity = O(n) */
    private int min(Node root) {
        if(isLeaf(root)) return root.value;

        int left = min(root.leftChild);
        int right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree tree) {
        return equals(root, tree.root);
    }

    private boolean equals(Node first, Node second) {
        if(first == null && second == null) return true;

        if(first != null && second != null)
            return (first.value == second.value) && equals(first.leftChild, second.leftChild) && equals(first.rightChild, second.rightChild);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
       if(root == null) return true;
       if(root.value < min || root.value > max) return false;

       return isBinarySearchTree(root.leftChild, min, root.value - 1) && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public void printNodesAtDistance(int distance) {
        printNodesAtDistance(root, distance);
    }

    private void printNodesAtDistance(Node root, int distance) {
        if(root == null) return;

        if(distance == 0) {
            System.out.println(root.value);
            return;
        }

        printNodesAtDistance(root.leftChild, distance - 1);
        printNodesAtDistance(root.rightChild, distance - 1);
    }
}
