package Lesson6.Animal;

public class Dog extends Animal {
    public Dog(String name, String color, int age, int weight, int growth) {
        super(name, color, age, weight, growth);
    }

    @Override
    public boolean jump(double height) {
        if (height <= 0.5 && getGrowth() > 25) {
                return true;
        }
        return false;
    }

    @Override
    public boolean swimming(int length) {
        if(length <= 10 ) {
            return true;
        }
        return false;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= 500 && getWeight() < 15) {
            return true;
        }
        return false;
    }
}
