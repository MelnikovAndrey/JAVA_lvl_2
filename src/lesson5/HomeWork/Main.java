package lesson5.HomeWork;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int H = SIZE / 2;


    public static void main(String[] args) {
        float[] arr = new float[SIZE];

        method1(arr);
        method2(arr);

    }

    public static float[] method1(float[] array) {
        Arrays.fill(array, 1);
        long beforeNewValue = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float) (array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long timeAfterNewValue = System.currentTimeMillis() - beforeNewValue;
        System.out.println("TimeToNewValueFromOneThread = " + timeAfterNewValue);
        return array;
    }

    public static float[] method2(float[] array) {
        Arrays.fill(array, 1);
        float[] a1 = new float[H];
        float[] a2 = new float[H];
        long timeBefore = System.currentTimeMillis();
        System.arraycopy(array, 0, a1, 0, H);
        System.arraycopy(array, H, a2, 0, H);

        Thread t1= new Thread(()-> changeValueFirstHalf(a1));
        t1.start();
        Thread t2= new Thread(()-> changeValueSecondHalf(a2));
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.arraycopy(a1, 0, array, 0, H);
        System.arraycopy(a2, 0, array, H, H);
        long timeAfter = System.currentTimeMillis();
        long timeRange = timeAfter - timeBefore;
        System.out.println("TimeToNewValueFromTwoThread = " + timeRange);
        return array;
    }
    static void changeValueFirstHalf(float[] arr){
        for (int i = 0; i < H; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
    static void changeValueSecondHalf(float[] arr){
        for (int i = 0; i < H; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + (i+H) / 5) * Math.cos(0.2f + (i+H) / 5) * Math.cos(0.4f + (i+H) / 2));
        }
    }
}

