package TPMovimientoDeCaballo;

import PilasyColas.StackNode;

/**************************************
 Author/s: Timoteo Sanchez Varsallona ,Juan Pablo Senmartin, Pedro Elizalde Acevedo
 Date: 11/04/2021
 **************************************/

public class Knight extends Piece {
    private Slot slot;
    private Board board;

    public Knight(Slot slot, Board board) {
        this.slot = slot;
        this.board = board;
    }

    public StackNode possibleSlotsStack() {
        StackNode slotsStack = new StackNode();
        for (int i = 0; i < board.board.length; i++) {
            for (int j = 0; j < board.board[i].length; j++) {
                if(possibleSlot(i,j)){
                    slotsStack.stack(board.board[i][j]);
                }
            }
        }
        return slotsStack;
    }

    private boolean possibleSlot(int row, int column){
        int newRow= Math.abs(row+1-slot.charToNum(slot.getLetter()));
        int newColumn=Math.abs(column+1-slot.getNumber());
        if((newRow==2 && newColumn == 1) || (newRow == 1 && newColumn ==2)) {
            return true;
            }
        return false;
    }
    public void moveKnight(Slot slot){
        this.slot = slot;
    }
    public Slot getSlot(){
        return slot;
    }

}

