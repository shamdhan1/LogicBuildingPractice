package logicproblems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamPractice {

    public static void main(String[] args) {

        // basic filtering and mapping for java developer


        List<Integer> mylist = Arrays.asList(10,20,30,12,45,48,52,16,85,24,65,32,89);

        List<Integer> collect = mylist.stream()
                .filter(e -> e % 2 == 0)
                .filter(e -> e > 30 && e < 60)
                .map(n -> n + n)
                .collect(Collectors.toList());
        System.out.println(collect);
        int sum = mylist.parallelStream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println(sum);



        List<String> names = Arrays.asList("Shamdhan", "Sudam","pankaj","Kunal","Nikhil","Kishan");
        List<String> a = names.stream()
                .filter(n -> n.length()>3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(a);

        String collect1 = names.stream().collect(Collectors.joining(" + "));
        System.out.println(collect1);

        List<String> s = names.parallelStream()
                .filter(e -> e.startsWith("S"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println(s);




        int[] arr = {10,20,30,40,50,12,52,63,45,29,87,99,13};
        Integer i = Arrays.stream(arr)
                .boxed()
                .max(Integer::compareTo)
                .get();
        System.out.println(i);

        int asInt = Arrays.stream(arr)
                .max()
                .getAsInt();
        System.out.println(asInt);

        Optional<Integer> first = Arrays.stream(arr)
                .boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println(first);



    }


}
