package Lesson6.Animal;

public class Animal {
    String name;
    String color;
    int age;
    int weight;
    int growth;

    Animal(String name, String color, int age, int weight, int growth) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.weight = weight;
        this.growth = growth;
    }

    public boolean jump(double height) {
        return true;
    }

    public boolean swimming(int length) {
        return true;
    }

    public boolean run(int distance) {
        return true;
    }

    public void info(){
        System.out.print(name + " ");
    }

    public int getWeight() {
        return weight;
    }

    public int getGrowth() {
        return growth;
    }
}
