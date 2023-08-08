package com.company.tree;

import java.util.*;

/**
 * Binary Search Tree(BST) type of three with
 * 1) Each node with 0,1,2 child(ren)
 * 2)Left subtree of each node is equal/less that node, right subtree is greater than that node
 * *************************Operations********************************************************
 * Insertion
 * Deletion (Cases): Node to be deleted;
 *      1)Has no child: Delete the node straight away
 *      2)Has 1 child: Link node to be deleted  parent with its child i.e replace the node by its child
 *          . go ahead and delete the node.
 *      3)Has 2 children, replace the node to be deleted with its
 *          * Inorder predecessor(Largest element from left subtree of the node to be deleted)
 *          * Inorder successor(Smallest element from right subtree of the node to be deleted)
 *          *NB: Inorder in BST gives elements in sorted order, meaning if you sort the elements in a list,
 *          the one on rigt of node to be deleted will be Inorder predecessor and the one in the right will be
 *          Inorder successor
 * AVL trees
 *  ***is BST(Binary search Tree) and self balances Left subtree - right sub tree has to be either -1,0 or 1
 *  if not, balancing has to be done majorly consider BST property and check middle element(should be the root of that section) within the unbalanced section
 *  Every insertion and deletion of an element, balancing has to be done
 *
 *
 *  Red Black trees, majorly select a data structure based on the most frequent operation either insertion/deletion/search
 *
 *  Red Black tree is a self balancing BST
 *
 *  Searching is faster in AVL tree  because it is strictly height balanced tree.
 *  Insertion and deletion is faster in Red Black trees since few rotations are required as opposed to AVL
 */

public class BinaryTree<T> {
    BinaryTreeNode<T> root;

    public BinaryTree(BinaryTreeNode<T> root) {
        this.root = root;
    }

    private BinaryTreeNode<T> findPredecessor(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> node = root.leftChild;
        //To find predecessor keep going right till node is not null or right node is not current.
        while (!Objects.equals(node.rightChild, root) && Objects.nonNull(node.rightChild)) {
            node = node.rightChild;
        }
        return node;
    }

    public void morrisInOrder(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> current = root;
        while (Objects.nonNull(current)) {
            //left is null then print the node and go to right
            if (Objects.isNull(current.leftChild)) {
                System.out.println(current.data + ", ");
                current = current.rightChild;
            } else {
                //find the predecessor.
                BinaryTreeNode<T> predecessor = findPredecessor(current);
                //if right node is null then go left after establishing link from predecessor to current.
                if (Objects.isNull(predecessor.rightChild)) {
                    predecessor.rightChild = current;
                    current = current.leftChild;
                } else {
                    //left is already visited. Go right after visiting current.
                    predecessor.rightChild = null;
                    System.out.println(current.data + ", ");
                    current = current.rightChild;

                }

            }
        }
    }

    public void morrisPreOrder(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> current = root;
        while (Objects.nonNull(current)) {
            if (Objects.isNull(current.leftChild)) {
                System.out.println(current.data + ", ");
                current = current.rightChild;
            } else {
                BinaryTreeNode<T> predecessor = findPredecessor(current);
                if (Objects.isNull(predecessor.rightChild)) {
                    predecessor.rightChild = current;
                    System.out.println(current.data + ", ");
                    current = current.leftChild;
                } else {
                    predecessor.rightChild = null;
                    current = current.rightChild;
                }
            }
        }
    }

    public void zigzagLevelTraversal(BinaryTreeNode<T> root) {
        boolean leftToRight = false;
        Deque<BinaryTreeNode<T>> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                size = -1;
                if (leftToRight) {
                    BinaryTreeNode<T> current = deque.pollFirst();
                    System.out.println(current.data);
                    if (Objects.nonNull(current.leftChild))
                        deque.addLast(current.leftChild);
                    if (Objects.nonNull(current.rightChild))
                        deque.addLast(current.rightChild);
                } else {
                    BinaryTreeNode<T> current = deque.pollLast();
                    System.out.println(current.data);
                    if (Objects.nonNull(current.rightChild))
                        deque.addFirst(current.rightChild);
                    if (Objects.nonNull(current.leftChild))
                        deque.addFirst(current.leftChild);
                }
            }
            leftToRight = !leftToRight;
        }
    }

    public List<List<T>> zigzagLevelOrder(BinaryTreeNode<T> root) {
        List<List<T>> result = new ArrayList<>();
        if (Objects.isNull(root))
            return result;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = false;
        while (!queue.isEmpty()) {
            List<T> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTreeNode<T> current = queue.poll();
                if (leftToRight) {
                    level.add(0, current.data);
                } else {
                    level.add(current.data);
                }
                if (Objects.nonNull(current.leftChild))
                    queue.add(current.leftChild);
                if (Objects.nonNull(current.rightChild))
                    queue.add(current.rightChild);
            }
            result.add(level);
            leftToRight = !leftToRight;
        }
        return result;

    }

    public int maxDepthRecursive(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return -1;
        int leftDepth = maxDepthRecursive(root.leftChild);
        int rightDepth = maxDepthRecursive(root.rightChild);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public BinaryTreeNode<T> deepestNode(BinaryTreeNode<T> root) {
        BinaryTreeNode<T> current = null;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            current = queue.poll();
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);

        }
        return current;
    }

    public void levelOrderReverseTraversal(BinaryTreeNode<T> root) {
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        if (Objects.isNull(root))
            return;
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);
            stack.push(current);
        }
        while (!stack.isEmpty())
            System.out.println(stack.pop() + ", ");
    }

    //Recursive tree traversals
    public void preorder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        System.out.print(root.data + ", ");
        preorder(root.leftChild);
        preorder(root.rightChild);
    }

    public void inorder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        inorder(root.leftChild);
        System.out.print(root.data + ", ");
        inorder(root.rightChild);
    }

    public void postorder(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return;
        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.print(root.data + ", ");
    }

    // Iterative tree traversals

    /**
     * However, even though each node is processed before the
     * subtrees, it still requires that some information must be maintained while moving down the tree.
     */
    public List<T> iterativePreorder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root))
            return result;
        /**
         * a stack is required as we need to remember the current node so that after
         * completing the left subtree we can go to the right subtree
         */
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> currentNode = stack.pop();
            result.add(currentNode.data);// represents processing

            // Push right child first , since stack is LIFO hence
            // left child is pushed last to be processed first.

            if (Objects.nonNull(currentNode.rightChild))
                stack.push(currentNode.rightChild);
            if (Objects.nonNull(currentNode.leftChild))
                stack.push(currentNode.leftChild);
        }
        return result;
    }

    public List<T> iterativeInorder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root))
            return result;
        BinaryTreeNode<T> current = root;
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        while (Objects.nonNull(current) || !stack.isEmpty()) {
            // if the current node exists, push it into the stack (defer it)
            // and move to its left child
            if (Objects.nonNull(current)) {
                stack.push(current);
                current = current.leftChild;
            } else {
                // otherwise, if the current node is null, pop an element from
                // the stack, print it, and finally set the current node to its
                // right child
                current = stack.pop();
                result.add(current.data);
                current = current.rightChild;
            }
        }
        return result;

    }
    public List<T> iterativePostorder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        if (Objects.isNull(root)) {
            return result;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        Stack<T> output = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode<T> currentNode = stack.pop();
            output.push(currentNode.data);
            if (Objects.nonNull(currentNode.leftChild)) {
                stack.push(currentNode.leftChild);
            }
            if (Objects.nonNull(currentNode.rightChild)) {
                stack.push(currentNode.rightChild);
            }

        }
        while (!output.isEmpty()) {
            result.add(output.pop());
        }
        return result;
    }

    public void deleteNode(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
        BinaryTreeNode<T> lastNode = null;
        BinaryTreeNode<T> nodeToDelete = null;
        if (Objects.isNull(root))
            return;
        if (Objects.equals(root.data, node.data)) {
            nodeToDelete = root;
        }
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.equals(current.data, node.data))
                nodeToDelete = current;
            if (Objects.nonNull(lastNode.leftChild))
                queue.offer(lastNode.leftChild);
            if (Objects.nonNull(lastNode.rightChild))
                queue.offer(lastNode.rightChild);
            lastNode = current;
            BinaryTreeNode<T> temp = nodeToDelete;
            nodeToDelete = lastNode;
            // lastNode = temp;
            lastNode = null;
        }
    }

    public int numberOfLeaves(BinaryTreeNode<T> root) {
        int count = 0;
        if (Objects.isNull(root))
            return count;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.isNull(current.leftChild) && Objects.isNull(current.rightChild))
                count += 1;
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);
        }
        return count;
    }

    public int findNumberOfFullNodes(BinaryTreeNode<T> root) {
        int count = 0;
        if (Objects.isNull(root))
            return count;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.nonNull(current.leftChild) && Objects.nonNull(current.rightChild))
                count += 1;
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);
        }
        return count;
    }

    public int findNumberOfHalfNodes(BinaryTreeNode<T> root) {
        int count = 0;
        if (Objects.isNull(root))
            return count;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if ((Objects.isNull(current.leftChild) && Objects.nonNull(current.rightChild)) ||
                    (Objects.isNull(current.rightChild) && Objects.nonNull(current.leftChild)))
                count += 1;
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);
        }
        return count;
    }



    public List<T> levelOrder(BinaryTreeNode<T> root) {
        List<T> result = new ArrayList<>();
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            //poll() removes the present head.
            BinaryTreeNode<T> currentNode = queue.poll();
            result.add(currentNode.data);
            /*Enqueue left child */
            if (Objects.nonNull(currentNode.leftChild)) {
                queue.add(currentNode.leftChild);
            }
            /*Enqueue right child */
            if (Objects.nonNull(currentNode.rightChild)) {
                queue.add(currentNode.rightChild);
            }
        }
        return result;
    }

    public int maxInBinaryTree(BinaryTreeNode<Integer> root) {
        int maxValue = Integer.MIN_VALUE;
        if (Objects.nonNull(root)) {
            int leftMax = maxInBinaryTree(root.leftChild);
            int maxRight = maxInBinaryTree(root.rightChild);
            //maxValue = Math.max(leftMax,maxRight);
            maxValue = Math.max(leftMax, maxRight);
            maxValue = Math.max(maxValue, root.data);
        }
        return maxValue;
    }

    public int maxInBinaryTreeLevelOrder(BinaryTreeNode<Integer> root) {
        if (Objects.isNull(root))
            return Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            maxValue = Math.max(maxValue, current.data);
            if (Objects.nonNull(current.leftChild)) {
                queue.offer(current.leftChild);
            }
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);
        }
        return maxValue;
    }

    public boolean structurallySameTrees(BinaryTreeNode<T> rootOne, BinaryTreeNode<T> rootTwo) {
        if (Objects.isNull(rootOne) && Objects.isNull(rootTwo))
            return true;
        if (Objects.isNull(rootOne) || Objects.isNull(rootTwo))
            return false;
        return (structurallySameTrees(rootOne.leftChild, rootOne.rightChild) &&
                structurallySameTrees(rootTwo.leftChild, rootTwo.rightChild));
    }

    public boolean findInBinaryTree(BinaryTreeNode<Integer> root, int data) {
        if (Objects.isNull(root))
            return false;
        if (Objects.equals(root.data, data))
            return true;
        return findInBinaryTree(root.leftChild, data) || findInBinaryTree(root.rightChild, data);

    }

    public boolean findInBinaryTreeLevelOrder(BinaryTreeNode<Integer> root, int data) {
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        if (Objects.isNull(root))
            return false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            if (Objects.equals(current.data, data))
                return true;
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);
        }
        return false;
    }

    public BinaryTreeNode<T> insertIntoBinaryTree(BinaryTreeNode<T> root, T data) {
        if (Objects.isNull(root))
            return null;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            if (Objects.nonNull(current)) {
                if (Objects.nonNull(current.leftChild)) {
                    queue.offer(current.leftChild);
                } else {
                    current.leftChild = new BinaryTreeNode<>(data);
                    return root;
                }
            }
            if (Objects.nonNull(current.rightChild)) {
                queue.offer(current.rightChild);
            } else {
                current.rightChild = new BinaryTreeNode<>(data);
                return root;
            }

        }
        return root;
    }

    public int size(BinaryTreeNode<T> root) {
        int leftCount = Objects.isNull(root.leftChild) ? 0 : size(root.leftChild);
        int rightCount = Objects.isNull(root.rightChild) ? 0 : size(root.rightChild);
        return 1 + leftCount + rightCount;
    }

    public int sizeNonRecursive(BinaryTreeNode<T> root) {
        int count = 0;
        if (Objects.isNull(root))
            return 0;
        Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<T> current = queue.poll();
            count += 1;
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);
        }
        return count;
    }

    public int maxElementInBinaryTree(BinaryTreeNode<Integer> root) {
        int maximum = Integer.MAX_VALUE;
        if (Objects.isNull(root))
            return Integer.MIN_VALUE;
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> current = queue.poll();
            maximum = Math.max(current.data, maximum);
            if (Objects.nonNull(current.leftChild))
                queue.offer(current.leftChild);
            if (Objects.nonNull(current.rightChild))
                queue.offer(current.rightChild);


        }
        return maximum;

    }

    public boolean findInBst(BinaryTreeNode<T> root, BinaryTreeNode<T> node) {
        if (Objects.isNull(root))
            return false;
        if (Objects.equals(root.data, node.data))
            return true;
        return findInBst(root.leftChild, node) || findInBst(root.rightChild, node);
    }

    public BinaryTreeNode<T> findMinRecursive(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return null;
        else if (Objects.isNull(root.leftChild))
            return root;
        else
            return findMinRecursive(root.leftChild);
    }

    public BinaryTreeNode<T> findMinIterative(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return null;
        while (Objects.nonNull(root.leftChild))
            root = root.leftChild;
        return root;
    }

    public BinaryTreeNode<Integer> findMaxRecursive(BinaryTreeNode<Integer> root) {
        if (Objects.isNull(root))
            return null;
        else if (Objects.isNull(root.rightChild))
            return root;
        else
            return findMaxRecursive(root.rightChild);
    }

    public BinaryTreeNode<T> findMaxIterative(BinaryTreeNode<T> root) {
        if (Objects.isNull(root))
            return null;
        while (Objects.nonNull(root.rightChild))
            root = root.rightChild;
        return root;
    }

    public BinaryTreeNode<Integer> insert(BinaryTreeNode<Integer> root, int data) {
        if (Objects.isNull(root)) {
            root = new BinaryTreeNode<>(data);
            root.leftChild = null;
            root.rightChild = null;
        } else {
            if (data < root.data) {
                root.leftChild = insert(root.leftChild, data);
            } else if (data > root.data) {
                root.rightChild = insert(root.rightChild, data);
            }
        }
        return root;
    }

    public BinaryTreeNode<Integer> deleteNode(BinaryTreeNode<Integer> root, int data) {
        BinaryTreeNode<Integer> temp;
        if (Objects.isNull(root))
            return null;
        else if (data < root.data) {
            root.leftChild = deleteNode(root.leftChild, data);
        } else if (data > root.data) {
            root.rightChild = deleteNode(root.rightChild, data);
        } else {
            //found element
            //Replace with largest in left subtree
            if (Objects.nonNull(root.leftChild) && Objects.nonNull(root.rightChild)) {
                temp = findMaxRecursive(root.leftChild);
                root.data = temp.data;
                root.leftChild = deleteNode(root.leftChild, data);
            } else {
                //one child
                temp = root;
                if (Objects.isNull(root.leftChild))
                    root = root.rightChild;
                if (Objects.isNull(root.rightChild))
                    root = root.leftChild;
            }
        }
        return root;
    }

    public BinaryTreeNode<Integer> findLCA(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> a, BinaryTreeNode<Integer> b) {
        if (Objects.isNull(root))
            return null;
        if (Objects.equals(root.data, a.data) || root.data == b.data) {
            return root;
        }
        if (Math.max(a.data, b.data) < root.data) //a.data < root.data && b.data < root.data
            return findLCA(root.leftChild, a, b);
        else if (Math.min(a.data, b.data) > root.data) //a.data > root.data && b.data > root.data
            return findLCA(root.rightChild, a, b);
        else
            return root;
    }

    public boolean isBST(BinaryTreeNode<Integer> root) {
        if (Objects.isNull(root))
            return true;
        //false if left > than root
        if (Objects.nonNull(root.leftChild) && root.leftChild.data > root.data)
            return false;
        //false if right is < root
        if (Objects.nonNull(root.rightChild) && root.rightChild.data < root.data)
            return false;
        //false if recursively, the left or right is not BST
        if (!isBST(root.leftChild) || !isBST(root.rightChild))
            return false;
        //passing all that, it is BST
        return true;
    }


}
