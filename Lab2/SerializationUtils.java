package com.company;
import java.io.*;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {
	// write your code here
        Save obj = new Save();
        File f = new File("obj.txt"); // create new file
        // Serialization
        System.out.print("Enter your name: ");
        Scanner in1 = new Scanner(System.in);
        obj.name = in1.nextLine();
        System.out.print("Enter your age: ");
        Scanner in = new Scanner(System.in);
        obj.age = in.nextInt();
        FileOutputStream fos = new FileOutputStream(f);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(obj);

        // Deserialization
        FileInputStream fis = new FileInputStream(f);
        ObjectInputStream ois = new ObjectInputStream(fis);
        Save obj1 = (Save) ois.readObject();
        System.out.println("Your name is:  " + obj1.name + "\n"+
        "Your age is: " + obj.age);
    }
}

class Save implements Serializable
{
    int age;
    String name;
}
