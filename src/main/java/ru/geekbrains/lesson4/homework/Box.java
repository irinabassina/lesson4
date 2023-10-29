package ru.geekbrains.lesson4.homework;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits = new ArrayList<>();

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight() {
        float nettoWeight = 0.0f;
        for (T fruit : fruits) {
            nettoWeight += fruit.getWeight();
        }
        return nettoWeight;
    }

    /*
     * e. Внутри класса Box сделать метод compare(), который позволяет сравнить
     * текущую коробку с той, которую
     * подадут в compare() в качестве параметра. true – если их массы равны, false в
     * противоположном случае.
     * Можно сравнивать коробки с яблоками и апельсинами;
     */
    public boolean compare(Box<?> otherBox) {
        return Math.abs(this.getWeight() - otherBox.getWeight()) < 0.0001;
    }

    public void transfer(Box<T> otherBox) {
        for (T fruit : fruits) {
            otherBox.addFruit(fruit);
        }
        fruits.clear();
    }
}