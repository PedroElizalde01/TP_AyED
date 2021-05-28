package TPComparacióndeArboles;

import java.util.Scanner;

/* Class AVLNode */
public class AVLNode<T extends Comparable<T>>
{
    AVLNode left, right;
    T data;
    int height;

    /* Constructor */
    public AVLNode() {
        left = null;
        right = null;
        data = null;
        height = 0;
    }
    /* Constructor */
    public AVLNode(T n) {
        left = null;
        right = null;
        data = n;
        height = 0;
    }
}