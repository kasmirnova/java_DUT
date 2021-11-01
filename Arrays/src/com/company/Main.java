package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        System.out.println("Довжина: ");
        int size = sc.nextInt();
        int[] myArray = new int[size];
        System.out.println("Елементи: ");
        for(int i=0; i<size; i++) {
            myArray[i] = sc.nextInt();
        }
        System.out.println("Масив: "+ Arrays.toString(myArray));
        System.out.println("Цифри, які не повторювалися ");
        Set<Integer> singleSet = new HashSet<>();
        Set<Integer> repeatedSet = new HashSet<>();
        for (int e : myArray) {
            if (repeatedSet.contains(e)) {
                continue;
            }
            if (singleSet.contains(e)) {
                singleSet.remove(e);
                repeatedSet.add(e);
            } else {
                singleSet.add(e);
            }
        }
        for (int e : myArray) {
            if (singleSet.contains(e)) {
                System.out.println(e);
            }
        }
        System.out.println("Завдання 2\n");
        int temp;
        int array[] = {5, 3, 2, 8, 1, 4};
        int[] sortedArray = new int[array.length];
        for (int j = 0; j < array.length - 1; j++) {
            for (int x = 0; x < array.length - 1; x++) {
                while(array[x] % 2 == 0 && x < array.length-1){
                    x++;
                }
                int y = x+1;
                if(y < array.length) {
                    while (array[y] % 2 == 0 && y < array.length - 1) {
                        y++;
                    }
                    if (array[x] > array[y] && array[y] % 2 == 1 && array[x] % 2 == 1) {
                        temp = array[x];
                        array[x] = array[y];
                        array[y] = temp;
                        sortedArray = array;
                    }
                }
            }
        }
        for (int i: sortedArray) {
            System.out.println(i);
        }
        }


}

