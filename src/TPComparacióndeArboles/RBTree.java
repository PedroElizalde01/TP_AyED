package TPComparacióndeArboles;

public class RBTree<T extends Comparable<T>> {
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;
    private static RedBlackNode nullNode;
    /* static initializer for nullNode */
    static {
        nullNode = new RedBlackNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }
    /* Black - 1  RED - 0 */
    static final int BLACK = 1;
    static final int RED   = 0;
    /* Constructor */
    public RBTree(T negInf)
    {
        header = new RedBlackNode(negInf);
        header.left = nullNode;
        header.right = nullNode;
    }
    /* Function to check if tree is empty */
    public boolean isEmpty()
    {
        return header.right == nullNode;
    }
    /* Make the tree logically empty */
    public void makeEmpty()
    {
        header.right = nullNode;
    }
    /* Function to insert item */
    public void insert(T item ) {
        current = parent = grand = header;
        nullNode.element = item;
        while (current.element.compareTo(item) != 0) {
            great = grand;
            grand = parent;
            parent = current;
            current = item.compareTo((T) current.element)<0 ? current.left : current.right;
            // Check if two red children and fix if so
            if (current.left.color == RED && current.right.color == RED)
                handleReorient( item );
        }
        // Insertion fails if already present
        if (current != nullNode)
            return;
        current = new RedBlackNode(item, nullNode, nullNode);
        // Attach to parent
        if (item.compareTo((T)parent.element) < 0)
            parent.left = current;
        else
            parent.right = current;
        handleReorient( item );
    }
    private void handleReorient(T item) {
        // Do the color flip
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;
        if (parent.color == RED) {
            // Have to rotate
            grand.color = RED;
            if (item.compareTo((T) grand.element) < 0 != item.compareTo((T) parent.element) < 0)
                parent = rotate( item, grand );  // Start dbl rotate
            current = rotate(item, great );
            current.color = BLACK;
        }
        // Make root black
        header.right.color = BLACK;
    }
    private RedBlackNode rotate(T item, RedBlackNode parent) {
        if(item.compareTo((T) parent.element) < 0)
            return parent.left = item.compareTo((T) parent.left.element) < 0 ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left) ;
        else
            return parent.right = item.compareTo((T) parent.right.element) < 0 ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
    }
    /* Rotate binary tree node with left child */
    private RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    /* Rotate binary tree node with right child */
    private RedBlackNode rotateWithRightChild(RedBlackNode k1) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }
    /* Functions to count number of nodes */
    public int countNodes()
    {
        return countNodes(header.right);
    }
    private int countNodes(RedBlackNode r) {
        if (r == nullNode)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }
    /* Functions to search for an element */
    public boolean search(T val)
    {
        return search(header.right, val);
    }
    private boolean search(RedBlackNode r, T val) {
        boolean found = false;
        while ((r != nullNode) && !found)
        {
            T rval = (T)r.element;
            if (val.compareTo(rval) < 0){
                r = r.left;
            } else if (val.compareTo(rval) > 0){
                r = r.right;
            }
            else
            {
                found = true;
                break;
            }
            found = search(r, val);
        }
        return found;
    }


    public RedBlackNode getRoot() {
        return header;
    }

    public int height(){
        return height(header);
    }

    public int height(RedBlackNode<T> t) {
        if (t!=nullNode) {
            int heigthLeft = height(t.left);
            int heightRight = height(t.right);
            return 1 + Math.max(heigthLeft, heightRight);
        } else {
            return -1;
        }
    }
    public int amountOfTries(T val) {
        int tries = 0;
        return amountOfTries(header.right, val,tries);
    }
    private int amountOfTries(RedBlackNode r, T val,int tries) {
        boolean found = false;
        while ((r != nullNode) && !found) {
            T rval = (T)r.element;
            if (val.compareTo(rval) < 0){
                r = r.left;
            } else if (val.compareTo(rval) > 0){
                 r = r.right;
            } else {
                found = true;
                break;
            }
            tries++;
        }
        return tries;
    }



}
