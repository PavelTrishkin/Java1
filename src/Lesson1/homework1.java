public class homework1 {
    // Homework part.1
    public static void main(String[] args) {
        System.out.println(calculate(25,10,5,2));
        System.out.println(task10and20(8,9));
        isPositiveOrNegative(-20);
        System.out.println(isNegative(2));
        greetings("Павел");
        whatYear(2020);
    }

    // Homework part.2
        byte a = 1;
        short s = 8;
        int i = 65;
        long l = 3165464;
        float fl = 45.6f;
        double d = 0.461;
        char ch = 'a';
        boolean boo = true;
        final int x = 120;

    // Homework part.3
        public static int calculate(int a, int b, int c, int d) {
            int result = a * (b + (c / d));
            return result;
        }

    // Homework part.4
        public static boolean task10and20(int x1, int x2) {
            int sum = x1 + x2;
            if(sum > 10 && sum <= 20)
                return true;
            else
                return false;
        }

    // Homework part.5
        public static void isPositiveOrNegative(int x) {
            if(x >= 0) {
                System.out.println("Число " + x + " положительное");
            } else {
                System.out.println("Число " + x + " отрицательное");
            }
        }
    // Homework part.6
        public static boolean isNegative(int x) {
            if(x < 0) {
                return true;
            }
            return false;
        }

    // Homework part.7
        public static void greetings(String name) {
            System.out.println("Привет " + name);
    }

    // Homework part.8
        public static void whatYear(int year) {
            if(year % 400 == 0 && year % 100 == 0){
                System.out.println(year + " год является високосным");
            }
            else if(year % 100 != 0 && year % 4 == 0){
                System.out.println(year + " год является високосным");
            }
            else
                System.out.println(year + " год не является високосным");

    }

}
