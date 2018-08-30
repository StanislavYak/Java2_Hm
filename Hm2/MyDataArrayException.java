package ru.hm;

public class MyDataArrayException extends MyArrayException {
    private int row;
    private int column;

    public MyDataArrayException(String s, int i, int j) {
        super(s);
    }

    public MyDataArrayException(String s, int i, int j, NumberFormatException e) {
        super(s, e);
    }

    @Override
    public String toString(){
        return "Invalid array data at " +
                "row =" + row +
                ", column =" + column;
    }
}
