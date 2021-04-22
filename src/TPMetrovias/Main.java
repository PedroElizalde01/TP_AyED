package TPMetrovias;

import PilasyColas.IsEmptyException;

import java.util.Scanner;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Main {
    public static void main(String[] args){
        Simulation simulation = new Simulation();
        Scanner input = new Scanner(System.in);
        int numOfCounters = input.nextInt();
        Metrovias metrovias= new Metrovias(numOfCounters);
        try {
            simulation.startSimulation(numOfCounters, metrovias);
        } catch (IsEmptyException e) {
            e.printStackTrace();
        }
    }
}
