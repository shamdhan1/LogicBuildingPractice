package JavaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapFunction {

    private int id;
    private String names;
    private int age;

    public MapFunction(int id, String names, int age) {
        this.id = id;
        this.names = names;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getNames() {
        return names;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "MapFunction{" +
                "id=" + id +
                ", names='" + names + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        // Integer List with multiple elements

        List<Integer> intList = Arrays.asList(10, 25, 30, 45, 60, 75, 90, 100, 5, 15);

        // String List with multiple elements
        List<String> stringList = Arrays.asList("Shamdhan", "Sudam", "Nikhil", "Raj", "Amit", "Vikas", "Pooja", "Anjali", "Sunita");


        List<Integer> collect = intList.stream().map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println(collect);

        List<String> collect1 = stringList.stream().map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(collect1);


        List<MapFunction> employee = Arrays.asList(
                new MapFunction(1,"sudam",22),
                new MapFunction(2,"kunal",19),
                new MapFunction(3,"pankaj",23)
        );


        List<Integer> list = employee.stream().map(MapFunction::getAge)
                .toList();
        System.out.println(list);

        List<Integer> list1 = stringList.stream().map(String::length)
                .toList();

        System.out.println(list1);

        List<Integer> list2 = employee.stream().map(emp -> emp.getAge() * 2)
                .toList();

        System.out.println(list2);

    }
}
