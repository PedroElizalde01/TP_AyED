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
        double counter = 0;
        if(ticketStack.isEmpty()){
            return 0;
        }
        Ticket ticket =ticketStack.peek();
        counter += ticket.getPrice();
        ticketStack.pop();
        counter = getCollectedMoney(counter);
        ticketStack.stack(ticket);
        return counter;
    }

    private double getCollectedMoney(double counter) throws IsEmptyException {
        if(ticketStack.isEmpty()){
            return counter;
        }else{
            Ticket currentTicket = ticketStack.peek();
            double ticketPrice = currentTicket.getPrice();
            counter += ticketPrice;
            ticketStack.pop();
            counter = getCollectedMoney(counter);
            ticketStack.stack(currentTicket);
        }
        return counter;
    }

    public double getAverageTime() throws IsEmptyException {
        double counter = 0;
        int size = ticketStack.size();
        Ticket currentTicket= ticketStack.peek();
        counter += currentTicket.getTimeInLine();
        ticketStack.pop();
        counter = getAverageTime(counter);
        ticketStack.stack(currentTicket);
        return counter/size;
    }
    private double getAverageTime(double counter) throws IsEmptyException{
        if(ticketStack.isEmpty()){
            return counter;
        }else{
            Ticket currentTicket = ticketStack.peek();
            double timeInLine = currentTicket.getTimeInLine();
            counter += timeInLine;
            ticketStack.pop();
            counter = getAverageTime(counter);
            ticketStack.stack(currentTicket);
        }
        return counter;
    }
}
