package functional;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Pow3 implements Function<Integer, Integer> {
    @Override
    public Integer apply(Integer num) {
        return num * num * num;
    }
}

class isEven implements Predicate<Integer> {
    @Override
    public boolean test(Integer num) {
        return num % 2 == 0;
    }
}

public class Main {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("x", "y", "z", "u");

        for (int i = 0; i < words.size(); i++)
            System.out.println(words.get(i));

        for (String word : words)
            System.out.println(word);

        words.forEach(word -> System.out.println(word));

        Pow3 f = new Pow3();
        System.out.println(f.apply(3));

        isEven pred = new isEven();
        System.out.println(pred.test(3));

        Predicate<Person> pred1 = p -> p.getName().charAt(0) == 'F' && p.getAge() <= 32;
        Predicate<Person> pred2 = p -> p.getName().charAt(0) == 'M';
        Predicate<Person> pred3 = p -> !p.getCitizenship().equals("IT");

        List<Person> people = Person.createList();

        people.forEach(p -> System.out.println(p.getName() + " " + pred1.test(p)));
        people.forEach(p -> System.out.println(p.getName() + " " + pred2.test(p)));
        people.forEach(p -> System.out.println(p.getName() + " " + pred3.test(p)));

        Collections.sort(people, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        people.forEach(p -> System.out.println(p.getName()));

        List<Integer> prices = Arrays.asList(30, 20, 15, 45);

        double total = prices.stream().filter(p -> p > 20)
                .map(p -> p * 0.9)
                .reduce(0.0, (p1, p2) -> p1 + p2);

        System.out.println(total);


    }

}
