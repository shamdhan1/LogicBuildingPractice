package JavaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LimitOperation {


    public static void main(String[] args) {


        List<Integer> num = Arrays.asList(10,20,30,40,51,21,23,42,62,51,25,85,96,45,75,78,15);


        List<Integer> list = num.stream()
                .distinct()
                .filter(n -> n > 50 && n < 80)
                .filter(even -> even % 2 == 0)
                .map(s -> s*s)
                .sorted(Comparator.reverseOrder())
                .limit(1)
                .toList();
        System.out.println(list);


        List<Integer> list1 = num.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(1)
                .findFirst()
                .stream().toList();

        System.out.println(list1);




    }
}
