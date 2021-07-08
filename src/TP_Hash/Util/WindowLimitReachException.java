package TP_Hash.Util;

public class WindowLimitReachException extends Exception {
    public WindowLimitReachException(){
        super("The window can't move there");
    }
}
