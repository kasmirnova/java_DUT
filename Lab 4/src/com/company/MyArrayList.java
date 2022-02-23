package com.company;

public class MyArrayList<T> {
    private final int SIZE = 16;
    private final int CUT_RATE = 4;
    private Object[] array = new Object[SIZE];
    private int pointer = 0;

    public void add(T item) {
        if (pointer == array.length - 1)
            resize(array.length * 2); // увеличу в 2 раза, если достигли границ
        array[pointer++] = item;
    }

    // Повернення елементу по індексу
    public boolean contains(Object o) {
        boolean hasElem = false;
        for (Object el : array) {
            if (o != null && el == o) {
                hasElem = true;
            }
        }
        return hasElem;
    }

    /*
    Видалення елементу, зменшення розміру масива для економії місця
    */
    public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1];
        array[pointer] = null;
        pointer--;
        if (array.length > SIZE && pointer < array.length / CUT_RATE)
            resize(array.length / 2);
    }

    /*К-ість елементів у листі*/
    public int size() {
        return pointer;
    }

    // Збілшуємо capacity
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }
}
