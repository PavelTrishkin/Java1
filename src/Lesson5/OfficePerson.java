package Lesson5;

public class OfficePerson {
    private String name;
    private String position;
    private String email;
    private String phoneNum;
    private int salary;
    private int age;

    public OfficePerson(String name, String position, String email, String phoneNum, int salary, int age) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNum = phoneNum;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println("ФИО: " + name + "; Должность: " + position + "; email: " + email + "; Номер телефона:" + phoneNum + "; Зарплата: " + salary + "; Возраст: " + age);
    }

    public int getAge() {
        return age;
    }
}
