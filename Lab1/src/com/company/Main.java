package com.company;
import java.util.Random;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    private static final int bound = 9;
    private static final int r = 5;
    private static final int с = 5;

    public static void main(String[] args) {
        int[][] array = fillArray(r, с);
        printArray(array); // вывод массива
        printEvenNumber(array, n -> n % 2 == 0); // вывод строки "Парні числа побічної діагоналі:" и числа

        System.out.println(Arrays.toString(fillArray(0, 10, 2)));
    }
// Создание и наполнение массива рандомными цифрами
    private static int[][] fillArray(int r, int c){
        Random random = new Random();
        int[][] array = new int[r][c];

        for (int i = 0; i < r; i++){
            for (int j = 0; j < c; j++){
                array[i][j] = random.nextInt(bound);
            }
        }

        return array;
    }

    private static void printEvenNumber(int[][] array, Predicate<Integer> getCondition){
        System.out.print("Парні числа побічної діагоналі: ");
        for (int i = 0; i < array.length; i++){
            int number = array[i][array.length - i - 1];
            if (getCondition.test(number)) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    private static void printArray(int[][] array){
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[] fillArray(int begin, int end, int step){
        int[] array = new int[end];

        int temp = 0;
        for(int i = begin; i < array.length - 1; i++){
            array[i + 1] = temp += step;
        }

        return array;
    }
}