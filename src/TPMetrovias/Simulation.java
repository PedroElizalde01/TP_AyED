package TPMetrovias;

import PilasyColas.IsEmptyException;
import PilasyColas.QueueNode;
import PilasyColas.Stack;

import javax.management.Query;
import java.util.Scanner;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Simulation {
    private Metrovias metrovias;
    private Stack<Ticket> pila;
    public void startSimulation(int numOfCounters, Metrovias metrovias) throws IsEmptyException{
        this.metrovias=metrovias;
        this.pila = new Stack<>();
        int option=0;
        do{
            printMenu();
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            if (option != 1 && option != 2){
                System.out.println("\nEnter a valid number\n");
                startSimulation(numOfCounters, metrovias);
            }
            switch (option){
                case 1: advance30Seconds();
                    break;
                case 2: fillStack();
                    mostrarPila(pila);
                    System.out.println("Recaudado de cada Ventanilla");
                    for (int i = 0; i < metrovias.getPaymentCounters().length; i++) {
                        System.out.println(metrovias.getPaymentCounters()[i].getCollectedMoney());
                    }
                    System.out.println("Tiempo de espera de cada ticket");
                    for (int i = 0; i < metrovias.getPaymentCounters().length; i++) {
                        System.out.println(metrovias.getPaymentCounters()[i].getAverageTime());
                    }
                    System.exit(0);
                    break;
            }
        }while(option<2);
    }
    private void fillStack() throws IsEmptyException {
        for (int i =0;i<metrovias.getPaymentCounters().length;i++){
            for (int j = 0; j < metrovias.getPaymentCounters()[i].getTicketStack().size(); j++) {
                pila.stack(metrovias.getPaymentCounters()[i].getTicketStack().peek());
                metrovias.getPaymentCounters()[i].getTicketStack().pop();
            }
        }
    }
    private void printMenu(){
        System.out.println("1. move forward 30 seconds");
        System.out.println("2. Exit\n\n");
        System.out.println("Choose an option: ");
    }
    //No hace falta implementarlo
    private void mostrarPila(Stack<Ticket> pila){}

    private void advance30Seconds() throws IsEmptyException {
        for (int i = 0; i < 5; i++) {   //Primero llegan los 5 clientes y cada uno elije una ventanilla
            clientArrives();
        }
        for(PaymentCounter paymentCounter : metrovias.getPaymentCounters()){
            QueueNode<People> peopleQueue= paymentCounter.getPeopleQueue(); //Primero pasan 30 sec por persona para q desp lo atienda
            for (int i = 0; i < peopleQueue.size(); i++) {
                People people = peopleQueue.dequeue(); //Saco a la persona para
                people.advanceThirtySeconds();         //Sumarle 30 sec y desp
                peopleQueue.enqueue(people);           //La vuelvo a meter al Queue
            }       //Como es un for del tamaño del queue, va a dar la vuelta entera y no cambia la posicion de las personas
            paymentCounter.attendClient(); //El cliente tiene un 0.5 de probabilidad de q sea atendido
        }
    }
    private void clientArrives(){
        new People(metrovias);
    }

}
