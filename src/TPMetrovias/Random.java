package TPMetrovias;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 22/04/2021
 **************************************/

public class Random { // Hice esta clase porque no encontraba un metodo random piola -Pedro

    public double normalRandom(){
        return Math.random();
    }

    public int getNumBetweenValues(int max, int min){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
