package TPMovimientoDeCaballo;

/**************************************
 Author/s: Timoteo Sanchez Varsallona, Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 11/04/2021
 **************************************/

public class Board {
    Slot[][] board;

    public Board(){
        this.board = new Slot[8][8];
        fillSlots();
    }
    private void fillSlots(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char jChar = numToString(j+1);
                board[i][j] = new Slot(jChar,i+1);
            }
        }
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
    private char charToNum(char coordinate){
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
    public Slot stringToSlot(String slotString){
        slotString.toUpperCase();
        Integer number= Character.getNumericValue(slotString.charAt(1));
        Slot slot= new Slot(slotString.charAt(0), number);
        return slot;
    }
}
