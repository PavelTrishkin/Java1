package Lesson4;

import java.util.Random;
import java.util.Scanner;

public class gameXO {

    static Scanner sc = new Scanner(System.in);
    static Random rand = new Random();

    static int SIZE;
    static int DOT_TO_WIN;
    static int counter = 0;

    static char[][] map;
    static final char DOT_X = 'X';
    static final char DOT_O = 'O';
    static final char DOT_EMPTY = '*';

    public static void main(String[] args) {
        mapSelection();
        initMap();
        printMap();

        while (true) {
            turnHuman();
            counter++;
            printMap();

            if (checkVictory(DOT_X)) {
                System.out.println("Игрок победил!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

            turnAi();
            counter++;
            printMap();

            if (checkVictory(DOT_O)) {
                System.out.println("ИИ победил!");
                break;
            }

            if (isFull()) {
                System.out.println("Ничья!");
                break;
            }

        }


    }

    public static void mapSelection(){
        System.out.println("Для выбора размера карты введите число от 3 до 10");
        SIZE = sc.nextInt();
        System.out.println("Введите количество знаков в подряд для победы. Минимум 3.");
        DOT_TO_WIN = sc.nextInt();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        System.out.print("  ");
        for (int i = 1; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void turnHuman() {
        int x, y;
        do {
            System.out.println("Введите координаты хода Y - ряд, Х - столбец.");
            y = sc.nextInt() - 1;
            x = sc.nextInt() - 1;
        } while (!checkBox(y, x));
        map[y][x] = DOT_X;
    }

    public static void turnAi() {
        int x, y;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkBox(i, j)) {
                    map[i][j] = DOT_O;
                    if (checkVictory(DOT_O)) {
                        map[i][j] = DOT_O;
                        return;
                    }
                    map[i][j] = DOT_EMPTY;
                }
            }
        }
        for (int k = 0; k < SIZE; k++) {
            for (int j = 0; j < SIZE; j++) {
                if (checkBox(k, j)) {
                    map[k][j] = DOT_X;
                    if (checkVictory(DOT_X)) {
                        map[k][j] = DOT_O;
                        return;
                    }
                    map[k][j] = DOT_EMPTY;
                }
            }
        }

        do {
            y = rand.nextInt(SIZE);
            x = rand.nextInt(SIZE);
        } while (!checkBox(y, x));
        map[y][x] = DOT_O;
    }

    public static boolean checkBox(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static boolean isFull() {
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) {
//                if(map[i][j]) == DOT_EMPTY;
//                return false;
//            }
//        }
//        return true;
        return counter == SIZE * SIZE;
    }

    public static boolean checkVictory(char symbol) {
        if(checkHorizont(symbol)){
            return true;
        }
        if(checkVetical(symbol)){
            return true;
        }

        if(checkDiag(symbol)) {
            return true;
        }

        if(checkRevDiag(symbol)) {
            return true;
        }

       return false;

//       if (map[0][0] == symbol && map[0][1] == symbol && map[0][2] == symbol){ return true; }
//       if (map[1][0] == symbol && map[1][1] == symbol && map[1][2] == symbol){ return true; }
//       if (map[2][0] == symbol && map[2][1] == symbol && map[2][2] == symbol){ return true; }
//
//       if (map[0][0] == symbol && map[1][0] == symbol && map[2][0] == symbol){ return true; }
//       if (map[0][1] == symbol && map[1][1] == symbol && map[2][1] == symbol){ return true; }
//       if (map[0][2] == symbol && map[1][2] == symbol && map[2][2] == symbol){ return true; }
//
//       if (map[0][0] == symbol && map[1][1] == symbol && map[2][2] == symbol){ return true; }
//       if (map[0][2] == symbol && map[1][1] == symbol && map[2][0] == symbol){ return true; }
//
    }
    public static boolean checkHorizont(char symbol){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int x = 0;
                for (int k = 0; k < DOT_TO_WIN; k++){
                    if ((checkLine(i, j + k)) && map[i][j + k] == symbol) {
                        x++;
                        if (x == DOT_TO_WIN) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    } //проверка горизонтальной линии

    public static boolean checkVetical(char symbol){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int x = 0;
                for (int k = 0; k < DOT_TO_WIN; k++){
                    if ((checkLine(i + k, j)) && map[i + k][j] == symbol) {
                        x++;
                        if (x == DOT_TO_WIN) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }  //проверка вертикальной линии

    public static boolean checkDiag(char symbol){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int x = 0;
                for (int k = 0; k < DOT_TO_WIN; k++){
                    if ((checkLine(i + k, j + k)) && map[i + k][j + k] == symbol) {
                        x++;
                        if (x == DOT_TO_WIN) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }  //проверка диагональной линии

    public static boolean checkRevDiag(char symbol){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                int x = 0;
                for (int k = 0; k < DOT_TO_WIN; k++){
                    if ((checkLine(i - k, j + k)) && map[i - k][j + k] == symbol) {
                        x++;
                        if (x == DOT_TO_WIN) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }  //проверка обратной диагональной линии

    public static boolean checkLine(int y, int x) {
        if (x < 0 || y < 0 || x >= SIZE || y >= SIZE) {
            return false;
        }
        return true;
    }

}
