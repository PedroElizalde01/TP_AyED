package TPMetrovias;

import PilasyColas.IsEmptyException;
import PilasyColas.QueueNode;
import PilasyColas.StackNode;

import java.util.Scanner;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Simulation {
    private Metrovias metrovias;
    private StackNode<Ticket> stack;
    public void startSimulation(Metrovias metrovias) throws IsEmptyException{
        this.metrovias=metrovias;
        this.stack = new StackNode<>();
        int option;
        do{
            printMenu();
            Scanner input = new Scanner(System.in);
            option = input.nextInt();
            if (option != 1 && option != 2){
                System.out.println("\nIngrese un numero valido\n");
                startSimulation(metrovias);
            }
            switch (option){
                case 1: advance30Seconds();
                    break;
                case 2:
                    System.out.println("Recaudado de cada Ventanilla");
                    for (int i = 0; i < metrovias.getPaymentCounters().length; i++) {
                        System.out.println("$"+metrovias.getPaymentCounters()[i].getCollectedMoney());
                    }
                    System.out.println("Tiempo de espera promedio de cada Ventanilla");
                    for (int i = 0; i < metrovias.getPaymentCounters().length; i++) {
                        System.out.println(metrovias.getPaymentCounters()[i].getAverageTime()+" seconds");
                    }
                    fillStack();
                    showStack(stack);
                    System.exit(0);
                    break;
            }
        }while(option<2);
    }
    private void fillStack() throws IsEmptyException {
        for (int i =0;i<metrovias.getPaymentCounters().length;i++){
            StackNode<Ticket> stackPaymentCounter = metrovias.getPaymentCounters()[i].getTicketStack();
            int ticketStackSize = metrovias.getPaymentCounters()[i].getTicketStack().size();
            for (int j = 0; j < ticketStackSize; j++) {
                stack.stack(stackPaymentCounter.peek());
                stackPaymentCounter.pop();
            }
        }
    }
    private void printMenu(){
        System.out.println("1. Avance 30 segundos");
        System.out.println("2. Salir\n\n");
        System.out.println("Elija una opcion: ");
    }

    //No need to implement
    private void showStack(StackNode<Ticket> stack){}

    private void advance30Seconds() throws IsEmptyException {
        for (int i = 0; i < 5; i++) {   //First, 5 people arrive and choose a counter
            clientArrives();
        }
        for(PaymentCounter paymentCounter : metrovias.getPaymentCounters()){
            QueueNode<People> peopleQueue= paymentCounter.getPeopleQueue(); //After 30 seconds counter has a chance to attend the first client
            for (int i = 0; i < peopleQueue.size(); i++) {
                People people = peopleQueue.dequeue(); // Pick first person in queue
                people.advanceThirtySeconds();         // Add 30 seconds to his timer
                peopleQueue.enqueue(people);           // Enqueue the client again at the end
            }
            paymentCounter.attendClient(); // The client has a 50% chance to be attended
        }
    }
    private void clientArrives(){
        new People(metrovias);
    }

}
