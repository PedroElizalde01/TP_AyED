package TPMetrovias;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Metrovias {
    private PaymentCounter[] paymentCounters;

    public Metrovias(int numOfCounters) {
        this.paymentCounters = new PaymentCounter[numOfCounters];
        fillPaymentCounter();
    }

    public PaymentCounter[] getPaymentCounters() {
        return paymentCounters;
    }

    private void fillPaymentCounter(){
        for (int i = 0; i < paymentCounters.length; i++) {
            PaymentCounter paymentCounter= new PaymentCounter();
            paymentCounters[i]= paymentCounter;
        }
    }
}
