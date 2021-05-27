package TPComparacióndeArboles;

import BinarySearchTree.BinarySearchTree;
import PilasyColas.IsEmptyException;
import BinarySearchTree.DuplicatedObjectException;

public class Main {
    public static void main(String[] args) throws IsEmptyException, DuplicatedObjectException, EmptyException {
        AVLTree<Double> avlTree= new AVLTree<>();
        RBTree<Double> rbTree= new RBTree<>(Math.random() * (100000) + 1);
        BinarySearchTree<Double> binaryTree= new BinarySearchTree<Double>();
        double[] doubleArray = new double[1000];
        for (int i = 0; i < 1000; i++) {
            double number = (Math.random() * (100000) + 1);
            doubleArray[i] = number;
        }
        System.out.println("AVL time difference: "+ getAVLTime(avlTree, doubleArray) );
        System.out.println("BnR time difference: " + getBnRTime(rbTree,doubleArray));
        System.out.println("binary tree time difference: " + getBinaryTreeTime(binaryTree,doubleArray));

        System.out.println("AVL heigth: " + avlTree.height());
        System.out.println("BnRTree heigth: " + rbTree.height());
        System.out.println("BinaryTree heigth: " + binaryTree.height(binaryTree.getRootOfTree()));

        //d)
        Double double1= doubleArray[0];
        Double double2= doubleArray[10];
        Double double3= doubleArray[20];
        Double double4= doubleArray[30];
        Double double5= doubleArray[40];
        Double double6= doubleArray[50];
        Double double7= doubleArray[60];
        Double double8= doubleArray[70];
        Double double9= doubleArray[80];
        Double double10= doubleArray[90];
        Double[] arrayToSearch= {double1,double2,double3,double4,double5,double6,double7,double8,double9,double10};
        printTable(arrayToSearch,avlTree,rbTree,binaryTree);

        long averageTotalTimeAVL = 0;
        long averageTotalTimeBnR = 0;
        long averageTotalTimeBinaryTree = 0;

        long avergaeTotalHeightAVL = 0;
        long avergaeTotalHeightBnR = 0;
        long avergaeTotalHeightBinaryTree = 0;

        long avergaeTriesAvl = 0;
        long avergaeTriesBnR = 0;
        long avergaeTriesBinaryTree = 0;

        for (int i = 0; i < 10; i++) {

        }
    }

    private static void printTable(Double[] arrayToSearch,AVLTree<Double> avlTree, RBTree<Double> rbTree, BinarySearchTree<Double> binaryTree){
        float binaryTries = 0;
        float avlTries = 0;
        float rbTries = 0;
        System.out.println("_______________________________________________");
        System.out.println("|  Número a buscar  |   BST   |   AVL   |   RBT   |");
        for (int i = 0; i < arrayToSearch.length; i++) {
            float btries = binaryTree.amountOfTries(binaryTree.getRootOfTree(), arrayToSearch[i],0);
            float atries = avlTree.amountOfTries(avlTree.getRoot(),arrayToSearch[i],0);
            float brTries = rbTree.amountOfTries(rbTree.getRoot(), arrayToSearch[i],0);
            System.out.println("| "+arrayToSearch[i]+" |" + btries+ "|"+ atries+"|"+ btries+"|");
            binaryTries += btries;
            avlTries += atries;
            rbTries += brTries;
        }
        System.out.println("_______________________________________________");
        System.out.println("Promedio: |" + binaryTries/10 + " |" + avlTries/10 + " |" + rbTries/10+ "|");
    }



    public static long getAVLTime(AVLTree<Double> avlTree, double[] doubleArray){
        long inicialTimeAVl = System.currentTimeMillis();
        for (int i= 0; i <100 ; i++) {
            avlTree.insert(doubleArray[i]);
        }
        long timeDifferenceAVL=System.currentTimeMillis()- inicialTimeAVl;
        return timeDifferenceAVL;
    }
    public static long getBnRTime(RBTree<Double> rbTree, double[] doubleArray){
        long initialTimeBnR = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            rbTree.insert(doubleArray[i]);
        }

        return System.currentTimeMillis() - initialTimeBnR;
    }
    public static long getBinaryTreeTime(BinarySearchTree<Double> binaryTree, double[] doubleArray){
        long initialTimeBinaryTree = System.currentTimeMillis();
        for (int i = 0; i < 100; i++) {
            try {
                binaryTree.insert(doubleArray[i]);
            } catch (DuplicatedObjectException e) {
                e.printStackTrace();
            }
        }
        return System.currentTimeMillis()- initialTimeBinaryTree;
    }
}
