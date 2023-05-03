package javabasic.generic;

public class Box<T> {
    private T item; // command + n!!!!!! 게럴세럴~~~~~

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
