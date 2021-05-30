package customSearchTrees;

import PilasyColas.IsEmptyException;
import TPComparacióndeArboles.BinarySearchTree;
import TPComparacióndeArboles.DuplicatedObjectException;

public class Main {
    public static void main(String[] args) throws TPComparacióndeArboles.DuplicatedObjectException, customSearchTrees.DuplicatedObjectException, IsEmptyException {
        AVL<Double> avlTree= new AVL<>();
        BlackAndRedTree<Double> rbTree= new BlackAndRedTree<>();
        BinarySearchTree<Double> binaryTree= new BinarySearchTree<Double>();
        double[] doubleArray = getDoubleArray();
        System.out.println("AVLTree time difference: "+ getAVLTime(avlTree, doubleArray)+ " nanoseconds" );
        System.out.println("BnRTree time difference: " + getBnRTime(rbTree,doubleArray) + " nanoseconds");
        System.out.println("BinaryTree time difference: " + getBinaryTreeTime(binaryTree,doubleArray) + " nanoseconds");

        System.out.println("AVL heigth: " + avlTree.height(avlTree.getRootOfTree()));
        System.out.println("BnRTree heigth: " + rbTree.height(rbTree.getRootOfTree()));
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

        double averageTotalTimeAVL = 0;
        double averageTotalTimeBnR = 0;
        double averageTotalTimeBinaryTree = 0;

        double averageTotalHeightAVL = 0;
        double averageTotalHeightBnR = 0;
        double averageTotalHeightBinaryTree = 0;

        double averageTriesAvl = 0;
        double averageTriesBnR = 0;
        double averageTriesBinaryTree = 0;

        //e)
        for (int j = 0; j < 10; j++) {
            AVL<Double> avlTree2= new AVL<>();
            BlackAndRedTree<Double> rbTree2= new BlackAndRedTree<>();
            BinarySearchTree<Double> binaryTree2= new BinarySearchTree<Double>();
            double[] array= getDoubleArray();
            averageTotalTimeAVL += getAVLTime(avlTree2, array);
            averageTotalTimeBnR += getBnRTime(rbTree2,array);
            averageTotalTimeBinaryTree += getBinaryTreeTime(binaryTree2,array);
            averageTotalHeightAVL += avlTree2.height(avlTree2.getRootOfTree());
            averageTotalHeightBnR += rbTree2.height(rbTree2.getRootOfTree());
           averageTotalHeightBinaryTree += binaryTree2.height(binaryTree2.getRootOfTree());

            Double doubles1= array[0];
            Double doubles2= array[10];
            Double doubles3= array[20];
            Double doubles4= array[30];
            Double doubles5= array[40];
            Double doubles6= array[50];
            Double doubles7= array[60];
            Double doubles8= array[70];
            Double doubles9= array[80];
            Double doubles10= array[90];
            Double[] arrayToSearch2= {doubles1,doubles2,doubles3,doubles4,doubles5,doubles6,doubles7,doubles8,doubles9,doubles10};

            for (int i = 0; i < arrayToSearch.length; i++) {
                averageTriesBinaryTree += binaryTree2.amountOfTries(binaryTree2.getRootOfTree(), arrayToSearch2[i],0);
                averageTriesAvl += avlTree2.amountOfTries(avlTree2.getRootOfTree(),arrayToSearch2[i],0);
                averageTriesBnR+= rbTree2.amountOfTries(rbTree2.getRootOfTree(), arrayToSearch2[i],0);
            }
        }
        System.out.println("Average Time to Build AVL: " + averageTotalTimeAVL/10 + " nanoseconds");
        System.out.println("Average Time to Build Black and Red tree: " +averageTotalTimeBnR/10+ " nanoseconds");
        System.out.println("Average Time to Build BinaryTree: " + averageTotalTimeBinaryTree/10 + " nanoseconds");

        System.out.println("Average Total Height AVL: " + averageTotalHeightAVL/10);
        System.out.println("Average Total Height Black and Red tree: " + averageTotalHeightBnR /10);
        System.out.println("Average Total Height BinaryTree: " + averageTotalHeightBinaryTree/10);

        System.out.println("Average tries AVL: " + averageTriesAvl/100);
        System.out.println("Average tries Black and Red tree: " +averageTriesBnR /100);
        System.out.println("Average tries BinaryTree: " +averageTriesBinaryTree/100);

    }

    private static void printTable(Double[] arrayToSearch,AVL<Double> avlTree, BlackAndRedTree<Double> rbTree, BinarySearchTree<Double> binaryTree){
        float totalBinaryTries = 0;
        float totalAvlTries = 0;
        float totalRBbTries = 0;
        System.out.println("_______________________________________________");
        System.out.println("|  Número a buscar  |   BST   |   AVL   |   RBT   |");
        for (int i = 0; i < arrayToSearch.length; i++) {
            float binaryTries = binaryTree.amountOfTries(binaryTree.getRootOfTree(), arrayToSearch[i],0);
            float avlTries = avlTree.amountOfTries(avlTree.getRootOfTree(),arrayToSearch[i],0);
            float rbTries = rbTree.amountOfTries(rbTree.getRootOfTree(), arrayToSearch[i],0);
            System.out.println("|   "+arrayToSearch[i]+"   |  " + binaryTries+ "  |  "+ avlTries+"  |  "+ rbTries+"  |");
            totalBinaryTries += binaryTries;
            totalAvlTries += avlTries;
            totalRBbTries += rbTries;
        }
        System.out.println("_______________________________________________");
        System.out.println("Promedio: |  " + totalBinaryTries/10 + "  |   " + totalAvlTries/10 + "  |  " + totalRBbTries/10+ "  |");
    }



    public static long getAVLTime(AVL<Double> avlTree, double[] doubleArray) throws customSearchTrees.DuplicatedObjectException {
        long inicialTimeAVl = System.nanoTime();
        for (int i= 0; i <100 ; i++) {
            avlTree.insert(doubleArray[i]);
        }
        long timeDifferenceAVL=System.nanoTime()- inicialTimeAVl;
        return timeDifferenceAVL;
    }
    public static long getBnRTime(BlackAndRedTree<Double> rbTree, double[] doubleArray) throws customSearchTrees.DuplicatedObjectException, IsEmptyException {
        long initialTimeBnR = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            rbTree.insert(doubleArray[i]);
        }

        return System.nanoTime() - initialTimeBnR;
    }
    public static long getBinaryTreeTime(BinarySearchTree<Double> binaryTree, double[] doubleArray){
        long initialTimeBinaryTree = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            try {
                binaryTree.insert(doubleArray[i]);
            } catch (DuplicatedObjectException e) {
                e.printStackTrace();
            }
        }
        return System.nanoTime()- initialTimeBinaryTree;
    }
    public static double[] getDoubleArray(){
        double[] doubleArray = new double[1000];
        for (int i = 0; i < 1000; i++) {
            double number = (Math.random() * (100000) + 1);
            doubleArray[i] = number;
        }
        return doubleArray;
    }
}