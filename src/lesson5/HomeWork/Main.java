package lesson5.HomeWork;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10_000_000;
    static final int H = SIZE / 2;


    public static void main(String[] args) {
        float[] arr = new float[SIZE];
        float[] arr2 = new float[SIZE];
        method1(arr);
    }
    public static float[] method1(float[] array){
        Arrays.fill(array, 1);
        long a = System.currentTimeMillis();
        for (int i = 0; i < array.length; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        long timeX = System.currentTimeMillis() - a;
        System.out.println(Arrays.toString(array));
        System.out.println("TimeX = " + timeX);
        return array;
    }


}

