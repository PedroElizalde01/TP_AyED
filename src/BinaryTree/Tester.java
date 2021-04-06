package BinaryTree;

public class Tester {
    public static void main(String[] args) {
        BinaryTreeAPI api = new BinaryTreeAPI();
        BinaryTree<Integer> A = new BinaryTree<Integer>(1);
        BinaryTree<Integer> B = new BinaryTree<Integer>(2);
        BinaryTree<Integer> F = new BinaryTree<Integer>(53);
        BinaryTree<Integer> G = new BinaryTree<Integer>(15);
        BinaryTree<Integer> C = new BinaryTree<Integer>(3,A,F);
        BinaryTree<Integer> D = new BinaryTree<Integer>(4,G,B);
        BinaryTree<Integer> E = new BinaryTree<Integer>(5,D,C);

        System.out.println(api.lleno(E));


    }
}