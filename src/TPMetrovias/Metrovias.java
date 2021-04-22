package TPMetrovias;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Metrovias {
    private PaymentCounter[] paymentCounters;

    public Metrovias(int numOfCounters) {
        this.paymentCounters = new PaymentCounter[numOfCounters];
        fill();
    }

    public PaymentCounter[] getPaymentCounters() {
        return paymentCounters;
    }
    private void fill(){
        for (int i = 0; i < paymentCounters.length; i++) {
            PaymentCounter paymentCounter= new PaymentCounter();
            paymentCounters[i]= paymentCounter;
        }
    }
}
