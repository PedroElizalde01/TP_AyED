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
        System.out.println("Cantidad de Ventanillas");
        Scanner input = new Scanner(System.in);
        int numOfCounters = input.nextInt();
        Metrovias metrovias= new Metrovias(numOfCounters);
        try {
            simulation.startSimulation(metrovias);
        } catch (IsEmptyException e) {
            e.printStackTrace();
        }
    }
}
