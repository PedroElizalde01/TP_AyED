package TP_Hash;

public interface GeneralListInterface<T> {
    void remove();
    void goNext() throws WindowLimitReachException;
    void goPrev() throws WindowLimitReachException;
    void goTo(int i) throws WindowLimitReachException;
    T getActual();
    int getActualPosition();
    int size();
    boolean isEmpty();
    boolean endList();

}
