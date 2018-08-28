package ru.hm;

public class HM2 {

    private static final int SIZE = 4;
    private static String[][] data = new String[][]{
            {"28", "36", "10", "6"},
            {"56", "16", "28", "1"},
            {"1", "44", "82", "4"},
            {"15", "10", "98", "6"}};

    public static void main(String[] args) {
        int value = calculateArraySum(data);

    }

    private static int calculateArraySum(String[][] data) {
        int result = 0;
        try {
            if (data.length != SIZE)
                throw new MyArraySizeException("Invalid array size");
            for (int i = 0; i < data.length; i++) {
                if (data.length != SIZE)
                    throw new MyArraySizeException("Invalid array size");

                for (int j = 0; j < data[i].length; j++) {
                    try {
                        result += Integer.parseInt(data[i][j]);
                    } catch (NumberFormatException e){
                        throw new MyDataArrayException("Invalid value = " + data[i][j], i, j, e);
                    }
                }
            }
        } catch (MyArrayException e){
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return result;
    }
}
