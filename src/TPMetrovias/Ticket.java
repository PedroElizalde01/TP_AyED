package TPMetrovias;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Ticket {
    private int timeInLine;
    private int ticketID;
    private int price;

    public Ticket(int timeInLine, int ticketID) {
        this.timeInLine = timeInLine;
        this.ticketID = ticketID;
        price = 1;
    }

    public int getPrice(){
        return price;
    }
    public int getTimeInLine() {
        return timeInLine;
    }

    public int getTicketID() {
        return ticketID;
    }
}
