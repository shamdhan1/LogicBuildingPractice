package JavaStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterPractice {


    private String name;
    private int salary;
    private int age;

    public FilterPractice(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "FilterPractice{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {


        // filter is useful for the applying condition in functional style

//        java.util.List<Integer> ListInt = Arrays.asList(10,20,30,40,50,60,70,80,100,25,46,32,10,10,20);
//
//        java.util.List<Integer> collect = ListInt.stream()
//                .filter(e -> e % 2 == 0)
//                .collect(Collectors.toList());
//
//        System.out.println(collect);
//
//        java.util.List<String> names = Arrays.asList("shamdhan","Sudam","nikhil","","");
//        java.util.List<String> collect1 = names.stream().filter(e -> !e.isEmpty())
//                .collect(Collectors.toList());


       List<FilterPractice> employee = Arrays.asList(
               new FilterPractice("Sudam", 20000, 22),
               new FilterPractice("Sham", 12000, 24),
               new FilterPractice("Nikhil", 25000, 28),
               new FilterPractice("Amit", 18000, 26)
       );

        employee.stream().filter(e -> e.getSalary() > 10000)
                .collect(Collectors.toList())
                        .forEach(System.out::println);


        List<String> names = Arrays.asList("shamdhan","Sudam","nikhil","","");
        List<String> s = names.stream().filter(e -> e.startsWith("S"))
                .collect(Collectors.toList());
        System.out.println(s);


    }



}
