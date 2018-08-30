package ru.hm;

public class MyArrayException extends Exception {
    public MyArrayException(String s){
        super(s);
    }

    public MyArrayException(String s, NumberFormatException e) {
        super(s, e);
    }
}
