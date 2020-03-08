package Lesson7;


import java.util.Random;

public class Cat {

    static Random rand = new Random();

    private String name;
    private boolean satiety;
    private int appetite;


    public Cat(String name) {
        this.name = name;
        satiety = false;
        appetite = rand.nextInt(14) + 1;

    }

    public void eat(Plate plate) {
        if (appetite <= plate.getFood()) {
            plate.decreaseFood(appetite);
            satiety = true;
            System.out.println(name + " наелся и мурлыкает.");
        } else {
            System.out.println("Для кота: " + name + " мало еды, он не будет есть.");
        }
    }

    public void info() {
        System.out.println("Имя: " + name + "; Сытость: " + satiety + "; Аппетит: " + appetite + ";");
    }

}
