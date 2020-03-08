package Lesson7;


public class Main {


    public static void main(String[] args) {

        Plate plate = new Plate(20);
        Cat[] cat = new Cat[4];
        cat[0] = new Cat("Barsik");
        cat[1] = new Cat("Vaskya");
        cat[2] = new Cat("Myrka");
        cat[3] = new Cat("Myrzik");

        System.out.println("В чашке: " + plate.getFood() + " еды");
        for (int i = 0; i < cat.length; i++) {
            cat[i].eat(plate);
            cat[i].info();
        }

        plate.foodInfo();

    }
}
