package TPMetrovias;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class People {
    private int timeCounter;

    public People(Metrovias metrovias){
        this.timeCounter = 0;
        choosePaymentCounter(metrovias);
    }

    public int getTimeCounter() {
        return timeCounter;
    }

    public void advanceThirtySeconds(){
        this.timeCounter+=30;
    }

    public void choosePaymentCounter(Metrovias metrovias){
        int n = (int) ((Math.random() * (metrovias.getPaymentCounters().length)));
        metrovias.getPaymentCounters()[n].addPeopleToQueue(this);
    }
}
