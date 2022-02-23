//TODO: 1 +
//List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
//	Вивести в консоль всі змінні в відсортованому вигляді
// які починаються з «с» та трансформувати їх в верхній регістр
//TODO: 2 +
//Заповнити масив розміром n рандомними значеннями в діапазоні (від 0 до 9)
// та порахувати середнє арифметичне всіх парних чисел
//TODO: 3 +
//Данний рядок «sjdhgfsjkavchjwagehf» (Просто набір букв в нижньому регістрі),
// потрібно підняти в верхній регістр всі букви в діапазоні від H до T по алфавіту
//TODO: 4
//Переписати реалізацію LinkedList, ArrayList (Stack, Queue) на Generics
//TODO: 5 +
//Є клас User (name, age, height, group, password, email) створити UserDto класс (name, age, email).
// Створити класс UserMapper з методами mapToUser(UserDto userDto), та mapToDto(User user);
//   Створити колекцію яка буде зберігати 5-10 юзерів і з допомогою stream
//   api вибрати всіх хто досяг повноліття та повернути на виході List<UserDto>

package com.company;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // write your code here
        while (true) {

            System.out.print("Choose what you want to do:\n" +
                    "1) First task\n" +
                    "2) Second tasky\n" +
                    "3) Third task\n" +
                    "4) Fourth task\n" +
                    "5) Fifth task\n" +
                    "0) Exit from menu\n" +
                    "Enter: ");
            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            if (choice == 0) {
                break;
            }
            if (choice == 1) {
                taskOne();
            }
            if (choice == 2) {
                System.out.println("Size of array: ");
                Scanner in1 = new Scanner(System.in);
                int size = in1.nextInt();
                fillArray(size);
            }
            if (choice == 3) {
                System.out.println(stringUpper("sjdhgfsjkavchjwagehf"));
            }
            if (choice == 5){
                createFirstCollection();
            }

        }
    }

    private static void taskOne(){
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");
        myList.stream()
                .filter(s -> s.charAt(0) == 'c')
                .sorted().map(s -> s.toUpperCase(Locale.ROOT))//Locale.ROOT пустая строка
                .forEach(System.out::println);
        for(char i = 0; i < 3; i++){
            System.out.println(myList.get(i));
        }

    }

    private static void fillArray(int r){
        double sum = 0;
        int count = 0;
        int[] array = new int[r];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int) (Math.random() * 9));
            System.out.println(array[i]);
            if (array[i]%2 ==0 ){
                count++;
                sum += array[i];
            }
        }
        System.out.print("Average is " + (sum/count) + "\n"+
                "Number of digits paired: " + count + "\n");
    }

    private static String stringUpper(String s){
        return s.chars().mapToObj(c -> {
            if(c >= 104 && c < 116){
                return String.valueOf((char) (c - 32));
            }

            return String.valueOf((char) c);
        }).collect(Collectors.joining());
    }

    private static Collection createFirstCollection() {
        List<User> users = Arrays.asList(
                new User("User 1", 19,  190, "PD-31", "1234", "test@gmail.com"),
                new User("User 2", 15,  190, "10 Class", "12345", "test@gmail.com"),
                new User("User 3", 23,  190, "PD-51", "123456", "test@gmail.com"),
                new User("User 4", 10,  190, "4 Class", "1234567", "test@gmail.com"),
                new User("User 5", 30,  190, "PD-61", "12345678", "test@gmail.com")
        );
        List<UserDto> userDtos = users.stream().filter(user -> user.age > 18).map(UserMapper::mapToDto).toList();
        System.out.println("Количество пользователей старше 18 = "+ userDtos.stream().count());
        return userDtos;
    }
}



