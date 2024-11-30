package functional;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private int age;
    private String citizenship;

    public Person(String n, int a, String c) {
        this.name = n;
        this.age = a;
        this.citizenship = c;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public static List<Person> createList() {
        List<Person> res = new ArrayList<>();

        res.add(new Person("Frank", 28, "FR"));
        res.add(new Person("Tom", 40, "DE"));
        res.add(new Person("Mark", 18, "EN"));
        res.add(new Person("Alice", 23, "IT"));

        return res;
    }
}
