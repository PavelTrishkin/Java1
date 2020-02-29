package Lesson6.Animal;

public class Cat extends Animal {
    public Cat(String name, String color, int age, int weight, int growth) {
        super(name, color, age, weight, growth);
    }


    @Override
    public boolean jump(double height) {
        if (height <= 2) {
            return true;
        }
        return false;
    }

    @Override
    public boolean swimming(int length) {
        return false;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= 200) {
            return true;
        }
        return false;
    }
}
