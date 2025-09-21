package JavaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SortingOperation {

    static  class Lab implements  Comparable<Lab>{
        private int id;
        private String name;
        private int fees;
        private String feactures;

        public Lab(int id, String name, int fees, String feactures) {
            this.id = id;
            this.name = name;
            this.fees = fees;
            this.feactures = feactures;
        }

        @Override
        public String toString() {
            return "Lab{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", fees=" + fees +
                    ", feactures='" + feactures + '\'' +
                    '}';
        }

        @Override
        public int compareTo(Lab other) {
            return Integer.compare(this.fees, other.fees); // default sort by fees
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Lab)) return false;
            Lab lab = (Lab) o;
            return id == lab.id && fees == lab.fees && Objects.equals(name, lab.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, fees);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getFees() {
            return fees;
        }

        public String getFeactures() {
            return feactures;
        }




    }


    public static void main(String[] args) {

        List<Integer> numeber = Arrays.asList(10,20,30,41,20,12,35,26,12,18,65);

        List<Integer> list = numeber.stream().sorted().toList();
        System.out.println(list);
        List<Integer> list1 = numeber.stream().filter(num -> num % 2 == 0)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(list1);


        List<Lab> labs = Arrays.asList(
                new Lab(1, "Physics Lab", 5000, "Microscope, Projector"),
                new Lab(2, "Chemistry Lab", 7000, "Test Tubes, Chemicals"),
                new Lab(3, "Biology Lab", 4500, "Skeleton, Microscope"),
                new Lab(4, "Computer Lab", 10000, "PCs, Internet, Projector"),
                new Lab(5, "Electronics Lab", 8000, "Oscilloscope, Breadboard"),
                new Lab(6, "Robotics Lab", 15000, "3D Printer, Arduino"),
                new Lab(7, "Mechanical Lab", 12000, "Lathe, Drilling Machine"),
                new Lab(8, "Civil Lab", 9000, "Survey Tools, Models"),
                new Lab(9, "Language Lab", 6000, "Headsets, Audio System"),
                new Lab(10, "AI Lab", 20000, "GPU Servers, AI Tools")
        );


        labs.forEach(System.out::println);

        List<Lab> list2 = labs.stream()
                .sorted()
                .toList();

        System.out.println(list2);


        List<Lab> list3 = labs.stream().filter(lab -> lab.getFees() > 10000 && lab.getFees() < 35000)
                .distinct()
                .sorted(Comparator.comparingInt(Lab::getFees).reversed())
                .collect(Collectors.toUnmodifiableList());

        System.out.println(list3);

        List<Lab> list4 = labs.stream()
                .filter(lab -> lab.getId() > 2 && lab.getId() < 10)
                .distinct()
                .sorted(Comparator.comparingDouble(Lab::getId).reversed())
                .toList();

        System.out.println(list4);


        List<String> names = Arrays.asList("sudam", "shamdhan", "kunal", "hello world");

        List<String> list5 = names.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .distinct()
                .toList();
        System.out.println(list5);






    }
}
