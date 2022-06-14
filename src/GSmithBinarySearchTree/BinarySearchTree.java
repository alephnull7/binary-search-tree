// Programmer: Gregory Smith
// Date: 06/13/2022
// Program: Binary Search Tree
// References: https://www.geeksforgeeks.org/generics-in-java/,
// https://docs.oracle.com/javase/8/docs/api/java/lang/Comparable.html,
// https://www.delftstack.com/howto/java/override-compareto-method-in-java/,
// https://www.educba.com/comparable-in-java-example/,
// https://docs.oracle.com/javase/8/docs/api/java/lang/Integer.html,
// Building Java Programs, 5th Edition: Chapters 1-17
//
// Purpose: Implement a binary search tree data structure
// IDE: IntelliJ

package GSmithBinarySearchTree;

// we assume that the objects of type E have Comparable implemented
public class BinarySearchTree<E extends Comparable<E>> {
    private TreeNode<E> root;

    // create new tree by taking input object and setting
    // root as TreeNode of object's type
    public BinarySearchTree(E root) {
        this.root = new TreeNode<>(root);

    } // end of default constructor

    // create new tree with root as null
    public BinarySearchTree() {
        this(null);

    } // end of root constructor

    public void add(E obj) {
        TreeNode<E> currentNode = this.root;
        TreeNode<E> objNode = new TreeNode<>(obj);

        if (currentNode.data == null) {
            // we add the node to the tree at root
            this.root = objNode;
            return;

        } // end of if

        int currentLength = 0;
        while (true) {
            // if obj is "greater than" currentNode check right
            if (obj.compareTo(currentNode.data) > 0) {
                currentLength += 1;

                if (currentNode.right != null) {
                    currentNode = currentNode.right;

                } else {
                    // we add the node to the tree
                    currentNode.right = objNode;
                    return;

                } // end of "right" if/else

            // if obj is "less than" currentNode check left
            } else if (obj.compareTo(currentNode.data) < 0) {
                currentLength += 1;

                if (currentNode.left != null) {
                    currentNode = currentNode.left;

                } else {
                    // we add the node to the tree
                    currentNode.left = objNode;
                    return;

                } // end of "left" if/else

            // node already exists in tree
            } else {
                return;

            } // end of outer if/else

        } // end of while

    } // end of add

    public boolean contains(E obj) {
        TreeNode<E> node = get(obj);
        return node != null;

    } // end of contains

    public TreeNode<E> get(E obj) {
        TreeNode<E> currentNode = this.root;

        if (currentNode.data == null) {
            return null;

        } // end of if

        while (true) {
            // if obj is "greater than" currentNode check right
            if (obj.compareTo(currentNode.data) > 0) {

                if (currentNode.right != null) {
                    currentNode = currentNode.right;

                } else {
                    // the tree does not contain obj
                    return null;

                } // end of "right" if/else

                // if obj is "less than" currentNode check left
            } else if (obj.compareTo(currentNode.data) < 0) {

                if (currentNode.left != null) {
                    currentNode = currentNode.left;

                } else {
                    // the tree does not contain obj
                    return null;

                } // end of "left" if/else

                // node exists in tree
            } else {
                return currentNode;

            } // end of outer if/else

        } // end of while

    } // end of get

    public void remove(E obj) {
        TreeNode<E> currentNode = this.root;

        if (currentNode.data == null) {
            return;

        } // end of if

        TreeNode<E> currentNodeParent = currentNode;
        boolean currentNodeDirectionBool = false;
        while (true) {
            // if obj is "greater than" currentNode check right
            if (obj.compareTo(currentNode.data) > 0) {

                if (currentNode.right != null) {
                    currentNodeParent = currentNode;
                    currentNodeDirectionBool = true;
                    currentNode = currentNode.right;

                } else {
                    // the tree does not contain obj
                    return;

                } // end of "right" if/else

            // if obj is "less than" currentNode check left
            } else if (obj.compareTo(currentNode.data) < 0) {

                if (currentNode.left != null) {
                    currentNodeParent = currentNode;
                    currentNodeDirectionBool = false;
                    currentNode = currentNode.left;

                } else {
                    // the tree does not contain obj
                    return;

                } // end of "left" if/else

            // node already exists in tree
            } else {
                break;

            } // end of outer if/else

        } // end of while

        // we reach here if we found the node
        removeCases(currentNode, currentNodeParent, currentNodeDirectionBool);

    } // end of remove

    private void removeCases(TreeNode<E> currentNode, TreeNode<E> currentNodeParent, boolean currentNodeDirectionBool) {
        // if the node is a leaf
        if (currentNode.left == null && currentNode.right == null) {
            if (currentNodeDirectionBool) {
                currentNodeParent.right = null;

            } else {
                currentNodeParent.left = null;

            } // end of inner if/else

        // if the node has a left child
        } else if (currentNode.right == null) {
            if (currentNodeDirectionBool) {
                currentNodeParent.right = currentNode.left;

            } else {
                currentNodeParent.left = currentNode.left;

            } // end of inner if/else

        // if the node has a right child
        } else if (currentNode.left == null) {
            if (currentNodeDirectionBool) {
                currentNodeParent.right = currentNode.right;

            } else {
                currentNodeParent.left = currentNode.right;

            } // end of inner if/else

        // if the node has both children
        } else {
            // we get the node to replace currentNode
            TreeNode<E> minNode = getMin(currentNode.right);

            // we try to find minNode's parent
            TreeNode<E> minNodeParent = getMinParent(currentNode.right);

            currentNode.data = minNode.data;

            // when minNode is the child of currentNode
            if (minNodeParent == null) {
                currentNode.right = null;

            // otherwise we remove minNode as child of minNodeParent
            } else {
                minNodeParent.left = null;

            } // end of inner if/else

        } // of outer if/else

    } // end of removeCases

    // since we are using a basic binary tree, true in-place
    // changes to nodes can not normally be done
    public void replace(E oldObj, E newObj) {
        remove(oldObj);
        add(newObj);

    } // end of replace

    public TreeNode<E> getMin() {
        return getMin(this.root);

    } // end of getMin from root

    private TreeNode<E> getMin(TreeNode<E> root) {
        TreeNode<E> currentNode = root;

        while (currentNode.left != null) {
            currentNode = currentNode.left;

        }
        return currentNode;

    } // end of getMin from any TreeNode

    private TreeNode<E> getMinParent(TreeNode<E> root) {
        TreeNode<E> currentNode = root;

        // we are at min node
        if (currentNode.left == null) {
            return null;

        } // end of if

        while (currentNode.left.left != null) {
            currentNode = currentNode.left;

        } // end of while
        return currentNode;

    } // end of getMinParent

    public void printSideways() {
        printSideways(this.root, "");

    } // end of printSideways from root

    // as this method uses recursion to print out a tree or subtree,
    // it is recommended to call this method on a reasonably small structure
    private void printSideways(TreeNode<E> root, String indent) {
        if (root != null) {
            printSideways(root.right, indent + "    ");
            System.out.println(indent + root.data);
            printSideways(root.left, indent + "    ");
        }

    } // end of printSideways from any TreeNode

    // the node class used for the binary search tree
    private static class TreeNode<E> {
        protected E data;
        protected TreeNode<E> left;
        protected TreeNode<E> right;

        public TreeNode(E obj) {
            this.data = obj;
            this.left = null;
            this.right = null;

        } // end of constructor

    } // end of TreeNode class

} // end of BinarySearchTree class
