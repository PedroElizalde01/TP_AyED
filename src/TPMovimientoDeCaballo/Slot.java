package TPMovimientoDeCaballo;

/**************************************
 Author/s: Timoteo Sanchez Varsallona ,Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 11/04/2021
 **************************************/

public class Slot {
    private char letter;
    private int number;

    public Slot(char letter, int number){
        this.letter = letter;
        this.number = number;
    }
    public char getLetter() {
        return letter;
    }

    public int getNumber() {
        return number;
    }

    public String print(){
        return ""+letter + number+ " ";
    }

    private char numToString(int n){
        switch (n){
            case 1:
                return 'A';
            case 2:
                return 'B';
            case 3:
                return 'C';
            case 4:
                return 'D';
            case 5:
                return 'E';
            case 6:
                return 'F';
            case 7:
                return 'G';
            case 8:
                return 'H';
            default:
                throw new IllegalArgumentException("This letter is not a coordinate of the board");
        }
    }

    public char charToNum(char coordinate){
        switch (coordinate){
            case 'A':
                return 1;
            case 'B':
                return 2;
            case 'C':
                return 3;
            case 'D':
                return 4;
            case 'E':
                return 5;
            case 'F':
                return 6;
            case 'G':
                return 7;
            case 'H':
                return 8;
            default:
                throw new IllegalArgumentException("This letter is not a coordinate of the board");
        }
    }
}
