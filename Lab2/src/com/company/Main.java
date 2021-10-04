package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        ArrayList array = new ArrayList();
        while (true) {

            System.out.print("Choose what you want to do:\n" +
                    "1) Add something to the array\n" +
                    "2) Remove something from the array\n" +
                    "3) Find out the size of the array\n" +
                    "4) Output the entire array\n" +
                    "5) Enlarge capacity of the array\n" +
                    "0) Exit from menu\n" +
                    "Enter: ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if (choice == 0) {
                    break;
                    }
            // REALIZATION ADD()
            if (choice == 1){
                    Scanner in1 = new Scanner(System.in);
                    System.out.print("Enter something to add to the array: ");
                    String value = in1.nextLine();
                    array.add(value);
                    System.out.print("You added: " + value + "\n");
                }
            // REALIZATION REMOVE()
            else if (choice == 2){
                Scanner in2 = new Scanner(System.in);
                System.out.print("Enter the item you want to delete: ");
                String value_to_delete = in2.nextLine();
                    if (array.contains(value_to_delete)) {
                        array.remove(value_to_delete);
                        System.out.print("Item was removed.\n");
                    }
                    else {
                        System.out.print("This element is not in the array.\n");
                    }
            }
            // REALIZATION SIZE()
            else if(choice == 3){
                System.out.print("The size of the array: " + array.size() + "\n");
            }
            // REALIZATION CONTAINS()
            else if(choice == 4){
                Scanner in4 = new Scanner(System.in);
                System.out.print("Enter something to find in the array: ");
                String value_find = in4.nextLine();
                System.out.print(array.contains(value_find) + "\n");
            }
            // REALIZATION CAPACITY()
            else if(choice == 5){
                StringBuffer sb = new StringBuffer();
                Scanner in5 = new Scanner(System.in);
                System.out.println("Default capacity: " + sb.capacity() );
                System.out.println("Enter what size to change to: ");
                int new_capacity = in5.nextInt();
                sb = new StringBuffer(new_capacity);
                System.out.print("New capacity is " + sb.capacity() + "\n");
            }
            else{
                System.out.print("Programming doesn't forgive mistakes. Bye!");
                break;
            }
        }

    }
}
