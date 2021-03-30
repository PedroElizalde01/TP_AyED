package BinaryTree;

/*******************************
 Auhor/s: Timoteo Sánchez Varsallona
 Date: 30/3/2021/03/2021
 *********************************/
public class DoubleNode<T> {
    T dato;
    DoubleNode<T> left;
    DoubleNode<T> right;

    public DoubleNode(T dato, DoubleNode<T> left, DoubleNode<T> right) {
        this.dato = dato;
        this.left = left;
        this.right = right;
    }

    public DoubleNode(T dato) {
        this.dato = dato;
    }
}
