import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)]));
        }
        persons.stream()
                .filter(x -> persons.size() >= 18)
                .filter(x -> persons.size() <= 27)
                .count();

        persons.stream()
                .filter((p) -> p.getAge() >= 18 && p.getAge() < 27
                        && p.getSex() == Sex.MAN)
                .map(Person::getFamily)
                .collect(Collectors.toList());

        persons.stream()
                .filter((p) -> p.getAge() >= 18)
                .filter((p) -> (p.getSex() == Sex.WOMAN && p.getAge() < 60) ||
                        (p.getSex() == Sex.MAN && p.getAge() < 65))
                .sorted(Comparator.comparing(Person::getEducation))
                .collect(Collectors.toList());


    }
}
