package Lesson6;

import Lesson6.Animal.Animal;
import Lesson6.Animal.Cat;
import Lesson6.Animal.Dog;

public class Main {

    public static void main(String[] args) {
        Animal[] animals = {
                new Cat("Barsik", "white", 3, 6, 12),
                new Cat("Vaska", "grey", 2, 5, 10),
                new Cat("Myrka", "black", 5, 4, 9),
                new Dog("Tuzik", "black", 7, 15, 30),
                new Dog("Sharik", "white", 2, 12, 25),
                new Dog("Bobik", "grey", 5, 18, 35),
        };

        for (Animal a : animals) {
            a.info();
            System.out.print("jump: " + a.jump(0.5) + "; ");
            System.out.print("swimming: " + a.swimming(10) + "; ");
            System.out.println("run: " + a.run(500) + ".");
        }
    }
}
