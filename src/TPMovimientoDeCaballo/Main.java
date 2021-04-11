package TPMovimientoDeCaballo;

import java.util.Scanner;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 11/04/2021
 **************************************/

public class Main {
    public static void main(String[] args) {
        Board board= new Board();
        Slot a1= new Slot('A',1);
        Knight knight= new Knight(a1,board);
        Simulation simulation= new Simulation();
        simulation.startSimulation(board, knight);
    }
}
