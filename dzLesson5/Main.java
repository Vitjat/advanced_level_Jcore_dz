package dzLesson5;

public class Main {
    private static final int SIZE = 10000000;
    private static final int HALF = SIZE / 2;
    private static final int HALF_SIZE = 1;

    public static void main(String[] args) {
        Main o = new Main();
        o.runOneThread();
        o.runTwoThreads();
    }

    private static float[] calculate(float[] arr) {
        for (int i = 0; i < arr.length; i++)
            arr[i] = (float) (arr[i] * Math.sin(0.2f + arr[i] / 5) * Math.cos(0.2f + arr[i] / 5) * Math.cos(0.4f + arr[i] / 2));
        return arr;
    }

    public void runOneThread() {
        float[] arr = new float[SIZE];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f;
        long a = System.currentTimeMillis();
        calculate(arr);
        System.out.println("One method: " + (System.currentTimeMillis() - a));
    }

    public void runTwoThreads() {
        float[] arr = new float[SIZE];
        float[] arr1 = new float[HALF];
        float[] arr2 = new float[HALF];
        for (int i = 0; i < arr.length; i++)
            arr[i] = 1.0f;

        long time = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, HALF);
        System.arraycopy(arr, HALF, arr2, 0, HALF);

        new Thread(() -> {
            float[] time1 = calculate(arr1);
            System.arraycopy(time1, 0, arr1, 0, time1.length);
        }).start();

        new Thread(() -> {
            float[] time2 = calculate(arr2);
            System.arraycopy(time2, 0, arr2, 0, time2.length);
        }).start();

        System.arraycopy(arr1, 0, arr, 0, HALF);
        System.arraycopy(arr2, 0, arr, HALF, HALF);
        System.out.println("Two method: " + (System.currentTimeMillis() - time));
    }


}
