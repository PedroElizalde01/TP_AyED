package TPMovimientoDeCaballo;

import PilasyColas.IsEmptyException;

import java.util.Scanner;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 11/04/2021
 **************************************/

public class Main {
    public static void main(String[] args) throws IsEmptyException {
        Board board= new Board();
        Scanner scanner= new Scanner(System.in);
        System.out.println("Where should the knight be placed?");
        Slot initialSlot= board.stringToSlot(scanner.nextLine());
        Knight knight= new Knight(initialSlot,board);
        Simulation simulation = new Simulation();
        simulation.startSimulation(board,knight);
    }
}
