package TP_Hash.Util;

import TP_Hash.Util.GeneralListInterface;

public interface ListInterface<T> extends GeneralListInterface {
    void insertNext(T obj);
    void insertBefore(T obj);
}
