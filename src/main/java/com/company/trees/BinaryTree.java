package com.company.trees;

import java.util.*;

/**
 * https://chatgpt.com/share/66f23048-7f50-8011-b07a-dc522980e977
 *
 * @param <T>
 */
public class BinaryTree<T> {
    private BinaryTreeNode<T> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    public void preOrder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        System.out.print(root.data + " ");
        preOrder(root.leftChild);
        preOrder(root.rightChild);

    }

    public List<T> iterativePreOrder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> current = stack.pop();
            result.add(current.data);
            /**
             * Going by Pre order traversal, where left subtree is processed before right-subtree
             * Going by stack LIFO principle, last element to be inserted, is processed first
             * Then insert left subtree last to be processed first
             */
            if (Objects.nonNull(current.rightChild)) {
                stack.push(current.rightChild);
            }
            if (Objects.nonNull(current.leftChild)) {
                stack.push(current.leftChild);
            }
        }
        return result;
    }

    public void inOrder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root)) {
            return;
        }
        inOrder(root.leftChild);
        System.out.print(root.data + " ");
        inOrder(root.rightChild);
    }

    /**
     * In Order Left -> Root -> Right
     * process left, process root then process right
     * <p>
     * start with pushing root
     * then as long as there is node to  process,
     * Go to the furthest left until current node is null
     * <p>
     * if current Node is null, check if stack is empty, means everything is processed
     * otherwise process the stack
     * then proceed to the current node right child
     */

    public List<T> iterativeInorder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        BinaryTreeNode<T> current = root;
        boolean done = false;
        while (!done) {
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.leftChild;
            } else {
                if (stack.isEmpty()) {
                    done = true;
                } else {
                    current = stack.pop();
                    result.add(current.data);
                    current = current.rightChild;
                }
            }
        }
        return result;
    }

 /*   public List<T> iterativeInOrder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        BinaryTreeNode<T> current = root;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (Objects.nonNull(current) || !stack.isEmpty()) {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
         *//*   if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.leftChild;
            } else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                current = stack.pop();
                result.add(current.data);
                current = current.rightChild;
            }*//*
            while (Objects.nonNull(current)) {
                stack.push(current);
                current = current.leftChild;
            }
            current = stack.pop();
            result.add(current.data);
            current = current.rightChild;
        }
        return result;
    }*/

    public void postOrder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root)) {
            return;
        }
        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.print(root.data + " ");
    }

    public List<T> iterativePostOrder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root))
            return result;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        Stack<T> outPutStack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> current = stack.pop();
            outPutStack.push(current.data);
            /**
             * Post order left-subtree -> root -> right-subtree
             * Process left subtree first which will make it to be inserted last in the output stack
             * This last insertion in the output stack, will make it to be processed first in the output stack.
             */
            if (Objects.nonNull(current.leftChild)) {
                stack.push(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild)) {
                stack.push(current.rightChild);
            }
        }
        while (!outPutStack.isEmpty()) {
            result.add(outPutStack.pop());
        }
        return result;
    }

    public List<T> levelOrder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root))
            return result;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            result.add(current.data);
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            }
        }

        return result;
    }

    public int maxInBinary(BinaryTreeNode<T> root) {
        int maxValue = Integer.MIN_VALUE;
        if (Objects.nonNull(root)) {
            maxValue = (Integer) root.data;
            int maxLeft = maxInBinary(root.leftChild);
            int maxRight = maxInBinary(root.rightChild);
            maxValue = Math.max(Math.max(maxLeft, maxRight), maxValue);
            return maxValue;
        }
        return maxValue;

    }

    public int maximumValueLevelOrder(BinaryTreeNode<T> root) {
        int maxValue = Integer.MIN_VALUE;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            maxValue = Math.max((Integer) current.data, maxValue);
            if (current.leftChild != null) {
                queue.offer(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.offer(current.rightChild);
            }
        }
        return maxValue;
    }

    public boolean findInBinaryTree(BinaryTreeNode<T> root, T value) {
        if (Objects.isNull(root))
            return false;
        if (root.data.equals(value)) {
            return true;
        }
        boolean inLeft = findInBinaryTree(root.leftChild, value);
        boolean inRight = findInBinaryTree(root.rightChild, value);
        return inLeft || inRight;
    }

    public boolean findInBinaryTreeLevelOrder(BinaryTreeNode<T> root, T value) {
        if (Objects.isNull(root))
            return false;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (current.data.equals(value)) {
                return true;
            }
            if (current.leftChild != null) {
                queue.offer(current.leftChild);
            }
            if (current.rightChild != null) {
                queue.offer(current.rightChild);
            }
        }
        return false;
    }

    public BinaryTreeNode<T> insertNode(BinaryTreeNode<T> root, T data) {
        if (Objects.isNull(root))
            return null;
        BinaryTreeNode<T> node = new BinaryTreeNode<>(data);
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            } else {
                current.leftChild = node;
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            } else {
                current.rightChild = node;
            }
        }
        return root;
    }

    public int binarySizeRecursive(BinaryTreeNode<T> root) {
        int left = Objects.isNull(root.leftChild) ? 0 : binarySizeRecursive(root.leftChild);
        int right = Objects.isNull(root.rightChild) ? 0 : binarySizeRecursive(root.rightChild);
        return left + right + 1;
    }

    public int binaryTreeSize(BinaryTreeNode<T> root) {
        int size = 0;
        if (Objects.isNull(root)) {
            return size;
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            size++;
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            }
        }
        return size;
    }

    public void levelOrderReversal(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            stack.push(current);
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            }
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop().data + ", ");
        }
    }

    /**
     * The last node to be processed is the deepest node in a binary tree using level order traversal
     */

    public BinaryTreeNode<T> deepestNode(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> tmp = null;
        if (Objects.isNull(root)) {
            return null;
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            tmp = queue.poll();
            if (Objects.nonNull(tmp.leftChild)) {
                queue.offer(tmp.leftChild);
            }
            if (Objects.nonNull(tmp.rightChild)) {
                queue.offer(tmp.rightChild);
            }
        }
        return tmp;
    }

    public int numberOfLeaves(BinaryTreeNode<T> root) {
        int count = 0;
        if (Objects.isNull(root)) {
            return count;
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.isNull(current.leftChild) || Objects.isNull(current.rightChild)) {
                count++;
            }
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            }
        }
        return count;
    }

    /**
     * Full node is a node with both left and right children
     */
    public int numberOfFullNodes(BinaryTreeNode<T> root) {
        int count = 0;
        if (Objects.isNull(root)) {
            return count;
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.nonNull(current.leftChild) && Objects.nonNull(current.rightChild)) {
                count++;
            }
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            }
        }
        return count;
    }

    private boolean halfNode(BinaryTreeNode<T> node) {
        return (Objects.nonNull(node.leftChild) && Objects.isNull(node.rightChild))
                || (Objects.nonNull(node.rightChild) && Objects.isNull(node.leftChild));
    }

    /**
     * Half node is a node having either left or right child but not both
     */

    public int numberOfHalfNodes(BinaryTreeNode<T> root) {
        int count = 0;
        if (Objects.isNull(root)) {
            return count;
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (halfNode(current)) {
                count++;
            }
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            }
        }
        return count;
    }

    //BST Binary search tree

    /**
     * while node is not null
     * if current node is less than target value, go left, BST constraint
     * otherwise go right, BST constraint
     */
    public BinaryTreeNode<Integer> findNode(BinaryTreeNode<Integer> root, int value) {
        if (Objects.isNull(root)) {
            return null;
        }
        while (Objects.nonNull(root)) {
            if (root.data.equals(value)) {
                return root;
            } else if (value < root.data) {
                root = root.leftChild;
            } else {
                root = root.rightChild;
            }
        }
        return null;

    }

    public BinaryTreeNode<T> findMinimumElement(BinaryTreeNode<T> root) {
        if (Objects.isNull(root)) {
            return null;
        } else {
            if (Objects.isNull(root.leftChild)) {
                return root;
            } else {
                return findMinimumElement(root.leftChild);
            }
        }
    }

    public BinaryTreeNode<T> findMinimumNonRecursive(BinaryTreeNode<T> root) {
        if (Objects.isNull(root)) {
            return null;
        }
        while (Objects.nonNull(root.leftChild)) {
            root = root.leftChild;
        }
        return root;
    }

    public BinaryTreeNode<T> findMaximumElement(BinaryTreeNode<T> root) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (Objects.isNull(root.rightChild)) {
            return root;
        } else {
            return findMaximumElement(root.rightChild);
        }

    }

    public BinaryTreeNode<T> findMaximumNonRecursive(BinaryTreeNode<T> root) {
        if (Objects.isNull(root)) {
            return null;
        }
        while (Objects.nonNull(root.rightChild)) {
            root = root.rightChild;
        }
        return root;
    }

    @SuppressWarnings("unchecked")
    public BinaryTreeNode<Integer> insertBstNode(BinaryTreeNode<Integer> root, Integer data) {
        BinaryTreeNode<Integer> node = new BinaryTreeNode<>(data);
        if (Objects.isNull(root)) {
            root = node;
        } else {
            if (data < root.data) {
                root.leftChild = (BinaryTreeNode<Integer>) insertNode((BinaryTreeNode<T>) root.leftChild, (T) data);
            } else {
                root.rightChild = insertBstNode(root.rightChild, data);
            }
        }
        return root;
    }

    /**
     * LCA: Least Common Ancestor: (LCA) of two nodes in a tree is the deepest (lowest) node that is an ancestor to both of the given nodes.
     * Ancestor: A node is considered an ancestor of another node if there is a path from the ancestor to that node in the tree.
     * Lowest Common Ancestor: Among all the common ancestors of two nodes, the LCA is the one that is the farthest from the root (the lowest in the tree).
     * If both nodes are smaller than the root, the LCA must be in the left subtree.
     * If both nodes are larger than the root, the LCA must be in the right subtree.
     * If one node is smaller and the other is larger (or if one is equal to the root), then the root is the LCA.
     */
    public BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node1, BinaryTreeNode<Integer> node2) {

        if (Objects.isNull(root)) {
            return null;
        }
        if (Objects.equals(root.data, node1.data) || Objects.equals(root.data, node2.data)) {
            return root;
        }
        if (Math.max(node1.data, node2.data) < root.data) {
            return findLCA(root.leftChild, node1, node2);
        } else if (Math.min(node1.data, node2.data) > root.data) {
            return findLCA(root.rightChild, node1, node2);
        } else {
            return root;
        }
    }

    /**
     * From BST left subtree < root < right subtree
     */
    public boolean isBst(BinaryTreeNode<Integer> root) {
        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
        BinaryTreeNode<Integer> current = root;
        BinaryTreeNode<Integer> prev = null;
        // Traverse the tree using a stack (simulating inorder traversal)
        while (Objects.nonNull(current) || !stack.isEmpty()) {
            // Traverse to the leftmost node
            while (Objects.nonNull(current)) {
                stack.push(current);
                current = current.leftChild;
            }
            // Pop the node from the stack
            current = stack.pop();
            // Check if the current node's value is greater than the previous node's value
            if (Objects.nonNull(prev) && current.data < prev.data) {
                return false; // Not a BST if the current value is not greater than the previous one
            }
            // Update the previous node to the current one
            prev = current;
            // Move to the right subtree
            current = current.rightChild;
        }
        // If we never found an invalid case, the tree is a valid BST
        return true;

    }
}
