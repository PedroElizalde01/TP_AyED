package TP_Hash;

public class WindowLimitReachException extends Exception {
    public WindowLimitReachException(){
        super("The window can't move there");
    }
}
