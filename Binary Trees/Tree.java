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
}
