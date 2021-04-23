package TPMetrovias;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class People {
    private int timeCounter;
    private PaymentCounter paymentCounter;

    public People(Metrovias metrovias){
        this.timeCounter = 0;
        this.paymentCounter = choosePaymentCounter(metrovias);
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public void advanceThirtySeconds(){
        this.timeCounter+=30;
    }

    public PaymentCounter choosePaymentCounter(Metrovias metrovias){
        int n = new Random().getNumBetweenValues(metrovias.getPaymentCounters().length-1,0);
        metrovias.getPaymentCounters()[n].addPeopleToQueue(this);
        return metrovias.getPaymentCounters()[n];


    }
}
