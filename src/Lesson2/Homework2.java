package Lesson2;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Homework2 {
    public static void main(String[] args) {
        invertArray();
        fillArray();
        changeArray();
        fillDiagonal();
        maxMinArray(10);
        int[] array = {1, 2, 8, 4, 9, 3, 6};
        System.out.println("Задание 6: " + checkBalance(array));
        shiftOfNumbers(array,-8);
    }

    // Homework part.1
    public static void invertArray() {
        int[] arr = { 1, 0, 1, 0, 0, 1 };
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
        }
        System.out.println("Задание 1: " + Arrays.toString(arr));
    }
    // Homework part.2
    public static void fillArray() {
        int[] arr = new int[8];
        arr[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 3;
        }
        System.out.println("Задание 2: " + Arrays.toString(arr));
    }
    // Homework part.3
    public static void changeArray() {
        int[] w = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        for (int i = 0; i < w.length; i++) {
            if (w[i] < 6) {
                w[i] *= 2;
            }
        }
        System.out.println("Задание 3: " + Arrays.toString(w));
    }
    // Homework part.4
    public static void fillDiagonal() {
        int[][] arr = new int[4][4];
        System.out.print("Задание 4:");
        for (int i = 0; i < 4; i++) {
            System.out.println();
            for (int j = 0; j < 4; j++) {
                if((i == j) || (i + j == 3)){
                    arr[i][j] = 1;
                }
                System.out.print(arr[i][j]);
            }
        }
        System.out.println();
    }
    // Homework part.5
    public static void maxMinArray(int n) {
        int [] arr;
        int max;
        int min;
        arr = new int[n];

        for (int i = 0; i < arr.length; i++){
            arr[i] = (int) ( Math.random() * 100);
        }

        max = arr[0];
        min = arr[0];

        for (int j = 0; j < arr.length; j++){
            if(arr[j] > max){
                max = arr[j];
            }
            if(arr[j] < min){
                min = arr[j];
            }
        }
        System.out.println("Задание 5: " + Arrays.toString(arr));
        System.out.println("Максимальный элемент массива: " + max);
        System.out.println("Минимальный элемент массива: " + min);
    }
    // Homework part.6
    public static boolean checkBalance(int[] arr){
        int sum1, sum2;

        for (int i = 0; i < arr.length ; i++) {
            sum1 = 0;
            sum2 = 0;

            for (int j = 0; j < i ; j++) {
                sum1 += arr[j];
            }
            for (int k = i; k < arr.length; k++) {
                sum2 += arr[k];
            }
            if(sum1 == sum2)
                return true;

        }
        return false;
    }
    // Homework part.7
    public static void shiftOfNumbers(int[] arr, int n) {
        if(n > arr.length){
            n = n % arr.length;
        }
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                int buffer = arr[0];
                arr[0] = arr[arr.length - 1];
                for (int j = 1; j < arr.length - 1; j++) {
                    arr[arr.length - j] = arr[arr.length - j - 1];
                }
                arr[1] = buffer;
            }
            System.out.println("Задание 7: " + Arrays.toString(arr));
        }
        else if(n < 0){
            for (int i = 0; i > n; i--) {
                int buffer = arr[arr.length - 1];
                arr[arr.length - 1] = arr[0];
                for (int j = 1; j < arr.length - 1; j++) {
                    arr[j - 1] = arr[j];
                }
                arr[arr.length - 2] = buffer;
            }
            System.out.println("Задание 7: " + Arrays.toString(arr));
        }
    }
}
