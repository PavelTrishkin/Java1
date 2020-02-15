package Lesson3;

import com.sun.org.apache.xpath.internal.objects.XNumber;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework3 {
    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    public static void main(String[] args) {

        //guessTheNumber(10);
        guessWord();
    }

    //Homework part.1
    public static void guessTheNumber(int level) {
//        Random rand = new Random();
//        Scanner sc = new Scanner(System.in);
        int starGame = 1, count = 2, number = rand.nextInt(level);

        while (starGame == 1) {
            if (count >= 0) {
                System.out.print("Угадайте число от 0 до " + level + ": ");
                int answer = sc.nextInt();
                if (answer == number) {
                    System.out.println("Вы угадали. Загаданное число: " + number);
                    System.out.println("Введите 1 чтобы повторить игру или 0 чтобы закончить.");
                    starGame = sc.nextInt();
                    count = 2;
                    number = rand.nextInt(level);
                } else if (answer > number) {
                    System.out.println("Введеное число больше загаданного. Попробуйте еще раз.");
                    count--;
                } else {
                    System.out.println("Введеное число меньше загаданного. Попробуйте еще раз.");
                    count--;
                }
            } else {
                System.out.println("Вы проиграли. Загаданное число: " + number);
                System.out.println("Введите 1 чтобы повторить игру или 0 чтобы закончить.");
                starGame = sc.nextInt();
                count = 2;
                number = rand.nextInt(level);
            }
        }
        System.out.println("Это была отличная игра! Всего хорошего!");
    }

    //Homework part.2
    private static void guessWord() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        String answer;
        String word = words[rand.nextInt(words.length)];
        String stop = "exit";
        System.out.println(Arrays.toString(words));
        do {
            System.out.println("Для завершения игры введите: exit.");
            System.out.print("Отгадайте слово: ");
            answer = sc.next();
            for (int i = 0; i < 15; i++) {
                if (i < word.length() && i < answer.length() && word.charAt(i) == answer.charAt(i)){
                    System.out.print(word.charAt(i));
                }
                else
                    System.out.print((word.equals(answer)) ? "" : "#");
            }
            System.out.println();

            if(word.equals(answer)){
                System.out.println("Поздравляю! Вы угадали слово.");
            }
        } while (!word.equals(answer) && !answer.equals(stop));
        System.out.println("Игра закончена.");
    }
}
