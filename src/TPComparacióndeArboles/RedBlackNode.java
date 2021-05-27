package TPComparacióndeArboles;

import java.util.Scanner;

/* Class Node */
class RedBlackNode<T extends Comparable<T>>
{
    RedBlackNode left, right;
    T element;
    int color;

    /* Constructor */
    public RedBlackNode(T theElement)
    {
        this( theElement, null, null );
    }
    /* Constructor */
    public RedBlackNode(T theElement, RedBlackNode lt, RedBlackNode rt)
    {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
    }
}