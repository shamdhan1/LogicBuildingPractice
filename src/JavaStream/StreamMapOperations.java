package JavaStream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapOperations {


    public static void main(String[] args) {

        List<String> names = Arrays.asList("hello", "world", "sudam","nikhil");

        Map<String, Long> collect = names.stream()
                .collect(Collectors.groupingBy(cha -> cha, Collectors.counting()));
        System.out.println(collect);


        String str = "Shamdhan_ramdhan_Charawande ";
        Character collect1 = str.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                        .entrySet().stream()
                        .max(Map.Entry.comparingByValue())
                                .map(Map.Entry::getKey)
                                        .orElse(null);
        System.out.println(collect1);

        List<String> words = Arrays.asList("a","b","c","d","a","f","g","h","a");

        String s = words.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
        System.out.println(s);

        List<String> mynamelist = List.of("Alice", "Bob", "Ankit", "Charlie");

        Map<Character, List<String>> collect2 = mynamelist.stream()
                .collect(Collectors.groupingBy(name -> name.charAt(0)));
        System.out.println(collect2);




        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);

        Map<String, List<Integer>> collect3 = nums.stream().collect(Collectors.groupingBy(num -> num % 2 == 0 ? "even" : "odd"));

        System.out.println(collect3);

        String str2 = "swiss";

        Character c1 = str2.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);
        System.out.println(c1);


        Map<String, Integer> map1 = Map.of("A", 1, "B", 2);
        Map<String, Integer> map2 = Map.of("B", 3, "C", 4);

        Map<String, Integer> collect4 = Stream.concat(map1.entrySet().stream(), map2.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, Integer::sum));

        System.out.println(collect4);

        List<String> lang = List.of("Java", "Spring", "Hibernate");

        Map<String, Integer> collect5 = lang.stream().collect(Collectors.toMap(l -> l, String::length));
        System.out.println(collect5);


        String subject = "javaSpringBoot";

        HashMap<Character, Integer> collect6 = subject.chars().mapToObj(c -> (char) c)
                .collect(Collectors.toMap(ch -> ch, ch -> subject.indexOf(ch),
                        (a, b) -> a, HashMap::new));
        System.out.println(collect6);


    }
}
