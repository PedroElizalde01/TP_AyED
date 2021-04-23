package TPMetrovias;

import PilasyColas.IsEmptyException;
import PilasyColas.QueueNode;
import PilasyColas.StackNode;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class PaymentCounter {
    private StackNode<Ticket> ticketStack;
    private QueueNode<People> peopleQueue;

    public PaymentCounter() {
        this.ticketStack = new StackNode<Ticket>();
        this.peopleQueue= new QueueNode<>();

    }
    public void addPeopleToQueue(People aPerson){
        peopleQueue.enqueue(aPerson);
    }

    public void attendClient() throws IsEmptyException {
        if(!peopleQueue.isEmpty()){
            double willAttend= Math.random()*100;
            if(willAttend>=50){
                People dequeuedPerson= peopleQueue.dequeue();
                generateTicket(dequeuedPerson.getTimeCounter());
            }else{
            }
        }
    }
    public void generateTicket(int time) throws IsEmptyException {
        if(ticketStack.isEmpty()){
            Ticket ticket= new Ticket(time, 10000);
            ticketStack.stack(ticket);
        }else{
            Ticket ticket= new Ticket(time, ticketStack.peek().getTicketID()+1);
            ticketStack.stack(ticket);
        }
    }

    public StackNode<Ticket> getTicketStack() {
        return ticketStack;
    }

    public QueueNode<People> getPeopleQueue() {
        return peopleQueue;
    }

    public double getCollectedMoney() throws IsEmptyException {
        int counter=0;
        for (int i = 0; i < ticketStack.size(); i++) {
            Ticket ticket =ticketStack.peek();
            counter += ticket.getPrice();
            ticketStack.pop();
            getCollectedMoney(counter);
            ticketStack.stack(ticket);
        }
        return counter;
    }

    private void getCollectedMoney(int counter) throws IsEmptyException {
        if (ticketStack.isEmpty()){
            return;
        }
        for (int i = 0; i < ticketStack.size(); i++) {
            Ticket currentTicket = ticketStack.peek();
            counter += currentTicket.getPrice();
            ticketStack.pop();
            getCollectedMoney(counter);
            ticketStack.stack(currentTicket);
        }
    }

    public double getAverageTime() throws IsEmptyException {
        int counter=0;
        int size= ticketStack.size();
        for (int i = 0; i < ticketStack.size(); i++) {
            Ticket currentTicket= ticketStack.peek();
            counter += currentTicket.getTimeInLine();
            ticketStack.pop();
            getAverageTime(counter);
            ticketStack.stack(currentTicket);
        }
        return counter/size;
    }
    private void getAverageTime(int counter) throws IsEmptyException{
        if(ticketStack.isEmpty()){
            return;
        }
        for (int i = 0; i < ticketStack.size(); i++) {
            Ticket currentTicket = ticketStack.peek();
            counter += currentTicket.getTimeInLine();
            ticketStack.pop();
            getAverageTime(counter);
            ticketStack.stack(currentTicket);
        }
    }
}
