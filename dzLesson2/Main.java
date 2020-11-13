package dzLesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[][] arr;
        int sum = 0;
        try {
            arr = initArray(4,4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
            return;
        }
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    sum += (int) arr[i][j];
                } catch (RuntimeException e) {
                    throw new MyArrayDataException("тип не int" );
                }
            }
        System.out.println("сумма массива = " + sum);
    }

    public static Object[][] initArray(int row, int col) throws MyArraySizeException {
        if (row != 4 | col != 4) {
            throw new MyArraySizeException("массив не 4x4");
        }
        return new Object[][]{{1,2,3,4},{4,5,4,5}, {1,2,3,4}, {1,2,3,4}};
    }
}
