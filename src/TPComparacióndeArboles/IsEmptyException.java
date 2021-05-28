package TPComparacióndeArboles;

/**
 * Exception should be thrown when structure is
 * empty and it is asked to work with non existing elements
 */
public class IsEmptyException extends Exception {
    public IsEmptyException(){
        super("Your stack/queue is empty");
    }
}
