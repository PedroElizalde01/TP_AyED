package TPMovimientoDeCaballo;

import PilasyColas.IsEmptyException;
import PilasyColas.StackNode;

import java.util.Scanner;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 11/04/2021
 **************************************/

public class Simulation {
    private StackNode<Slot> cola1erMovimiento = new StackNode();
    private StackNode<Slot> cola2ndoMovimiento = new StackNode();
    private StackNode<Slot> cola3erMovimiento = new StackNode();
    private StackNode<Slot> cola4toMovimiento = new StackNode();


    public void startSimulation(Board board, Knight knight) throws IsEmptyException {
        int salto = 1;
        Scanner scanner = new Scanner(System.in);
        while (salto <= 4) {
            printMenu();
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    realizarSalto(salto, knight, board);
                    salto++;
                    break;
                case 2:
                    try {
                        printStacks(cola1erMovimiento, cola2ndoMovimiento, cola3erMovimiento, cola4toMovimiento);
                    } catch (IsEmptyException e) {
                        System.out.println("The Stack is empty");
                    }
                    break;
                case 3:
                    System.exit(0);
            }
        }
        try {
            printStacks(cola1erMovimiento, cola2ndoMovimiento, cola3erMovimiento, cola4toMovimiento);
        } catch (IsEmptyException e) {
            System.out.println("The Stack is empty");
        }
    }


    private void printMenu() {
        System.out.println("Elegir una opcion: \n");
        System.out.println("1. El caballo realiza un salto");
        System.out.println("2. Mostrar contenido en las pilas");
        System.out.println("3. Salir");
    }

    private void realizarSalto(int salto, Knight knight, Board board) throws IsEmptyException {
        if (salto == 1) {
            cola1erMovimiento = knight.possibleSlotsStack();
            Slot nuevoSlot = cola1erMovimiento.peek();
            knight.moveKnight(nuevoSlot);
        }
        if (salto == 2) {
            cola2ndoMovimiento = knight.possibleSlotsStack();
            Slot nuevoSlot = cola2ndoMovimiento.peek();
            knight.moveKnight(nuevoSlot);
        }
        if (salto == 3) {
            cola3erMovimiento = knight.possibleSlotsStack();
            Slot nuevoSlot = cola3erMovimiento.peek();
            knight.moveKnight(nuevoSlot);
        }
        if (salto == 4) {
            cola4toMovimiento = knight.possibleSlotsStack();
            Slot nuevoSlot = cola4toMovimiento.peek();
            knight.moveKnight(nuevoSlot);
        }
    }
/*
    private void printStacks(StackNode<Slot> stack1, StackNode<Slot> stack2, StackNode<Slot> stack3, StackNode<Slot> stack4) throws IsEmptyException {

        String possibleMoves= "";
        while (stack1.size()!=0) {
            possibleMoves= possibleMoves + stack1.peek().print();
            stack1.pop();
        }
        System.out.println(possibleMoves);

        possibleMoves= "";

        while (stack2.size()!=0) {
            possibleMoves= possibleMoves + stack2.peek().print();
            stack2.pop();
        }
        System.out.println(possibleMoves);

        possibleMoves= "";
        while (stack3.size()!=0) {
            possibleMoves= possibleMoves + stack3.peek().print();
            stack3.pop();
        }
        System.out.println(possibleMoves);

        possibleMoves= "";

        while (stack4.size()!=0) {
            possibleMoves= possibleMoves + stack4.peek().print();
            stack4.pop();
        }
        System.out.println(possibleMoves);
    }

 */
    private void printStacks(StackNode<Slot> stack1,StackNode<Slot> stack2,StackNode<Slot> stack3,StackNode<Slot> stack4) throws IsEmptyException {
        printStacks(stack1);
        System.out.println();
        printStacks(stack2);
        System.out.println();
        printStacks(stack3);
        System.out.println();
        printStacks(stack4);
        System.out.println();
}
    private void printStacks(StackNode<Slot> stack) throws IsEmptyException {
        if(stack.isEmpty()){
            return;
        }
        Slot slot = stack.peek();
        System.out.print(slot.print());
        stack.pop();
        printStacks(stack);
        stack.stack(slot);

    }
}

