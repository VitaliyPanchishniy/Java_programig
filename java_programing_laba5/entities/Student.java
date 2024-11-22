package entities;

public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Учень{" + "ID=" + id + ", Ім'я='" + name + '\'' + ", Вік=" + age + '}';
    }
}
