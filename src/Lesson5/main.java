package Lesson5;

public class main {
    public static void main(String[] args) {
        OfficePerson[] persArr = new OfficePerson[5];
        persArr[0] = new OfficePerson("Ivanov Ivan", "Manager", "ivanmanager@mail.ru", "+79384512141", 30000, 38);
        persArr[1] = new OfficePerson("Petrov Vasily", "Department head", "petrovsuper@mail.ru", "+79237777777", 70000, 42);
        persArr[2] = new OfficePerson("Pupkina Galina", "Secretary", "galya1158@mail.ru", "+79384649843", 25000, 27);
        persArr[3] = new OfficePerson("Vlasov Evgeny", "Boss", "bossevgeny@mail.ru", "+79270707077", 350000, 48);
        persArr[4] = new OfficePerson("Lapina Sofia", "Accountant", "secretbox@mail.ru", "+79270808088", 80000, 39);

        for (int i = 0; i < persArr.length; i++) {
            if(persArr[i].getAge() > 40){
                persArr[i].printInfo();
            }
        }

    }
}
