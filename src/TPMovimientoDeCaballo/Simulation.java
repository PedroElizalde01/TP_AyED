package TPMovimientoDeCaballo;

import PilasyColas.IsEmptyException;
import PilasyColas.StackNode;

import java.util.Scanner;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 11/04/2021
 **************************************/

public class Simulation {
    private StackNode<Slot> stack1stMove = new StackNode<>();
    private StackNode<Slot> stack2ndMove = new StackNode<>();
    private StackNode<Slot> stack3rthMove = new StackNode<>();
    private StackNode<Slot> stack4thMove = new StackNode<>();
    private Slot startingSlot;


    public void startSimulation(Knight knight) throws IsEmptyException {
        startingSlot = knight.getSlot();
        int jump = 1;
        Scanner scanner = new Scanner(System.in);
        while (jump <= 4) {
            printMenu();
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    makeJump(jump, knight);
                    jump++;
                    break;
                case 2:
                    try {
                        printStackNodes(stack1stMove, stack2ndMove, stack3rthMove, stack4thMove);
                    } catch (IsEmptyException e) {
                        System.out.println("The StackNode is empty");
                    }
                    break;
                case 3:
                    printPossibleRoutes(knight);
                    System.exit(0);
            }
        }
        printPossibleRoutes(knight);
    }


    private void printMenu() {
        System.out.println("Choose an option: \n");
        System.out.println("1. The knight make a jump");
        System.out.println("2. Show stack's content");
        System.out.println("3. Exit");
    }

    private void makeJump(int jump, Knight knight) throws IsEmptyException {
        if (jump == 1) {
            stack1stMove = knight.possibleSlotsStack();
            Slot nuevoSlot = stack1stMove.peek();
            knight.moveKnight(nuevoSlot);
        }
        if (jump == 2) {
            stack2ndMove = knight.possibleSlotsStack();
            Slot nuevoSlot = stack2ndMove.peek();
            knight.moveKnight(nuevoSlot);
        }
        if (jump == 3) {
            stack3rthMove = knight.possibleSlotsStack();
            Slot nuevoSlot = stack3rthMove.peek();
            knight.moveKnight(nuevoSlot);
        }
        if (jump == 4) {
            stack4thMove = knight.possibleSlotsStack();
            Slot nuevoSlot = stack4thMove.peek();
            knight.moveKnight(nuevoSlot);
        }
    }

    private void printPossibleRoutes(Knight knight) throws IsEmptyException {
        //This method prints all the possible routes a knight could make in 4 moves
        while (!stack4thMove.isEmpty()) {
            System.out.println(startingSlot.print() + "- " + stack1stMove.peek().print() + "- " + stack2ndMove.peek().print() + "- " + stack3rthMove.peek().print() + "- " + stack4thMove.peek().print());
            stack4thMove.pop();
        }
        System.out.println("");
        if (!stack3rthMove.isEmpty()) stack3rthMove.pop();
            if (!stack3rthMove.isEmpty()) {
                knight.moveKnight(stack3rthMove.peek());
                stack4thMove = knight.possibleSlotsStack();
                while (!stack3rthMove.isEmpty()) {
                    printPossibleRoutes(knight);
                }
            }
        if(!stack2ndMove.isEmpty()) stack2ndMove.pop();
        if (!stack2ndMove.isEmpty()) {
            knight.moveKnight(stack2ndMove.peek());
            stack3rthMove = knight.possibleSlotsStack();
            while (!stack2ndMove.isEmpty()) {
                printPossibleRoutes(knight);
            }
        }
        if(!stack1stMove.isEmpty()) stack1stMove.pop();
            if (!stack1stMove.isEmpty()){
                knight.moveKnight(stack1stMove.peek());
                stack2ndMove = knight.possibleSlotsStack();
                while (!stack1stMove.isEmpty()) {
                    printPossibleRoutes(knight);
            }
        }
    }

    private void printStackNodes(StackNode<Slot> stack1,StackNode<Slot> stack2,StackNode<Slot> stack3,StackNode<Slot> stack4) throws IsEmptyException {
        printStackNodes(stack1);
        System.out.println();
        printStackNodes(stack2);
        System.out.println();
        printStackNodes(stack3);
        System.out.println();
        printStackNodes(stack4);
        System.out.println();
}

    private void printStackNodes(StackNode<Slot> stack) throws IsEmptyException {
        if(stack.isEmpty()){
            return;
        }
        Slot slot = stack.peek();
        System.out.print(slot.print());
        stack.pop();
        printStackNodes(stack);
        stack.stack(slot);

    }
}

