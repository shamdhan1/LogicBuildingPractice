package JavaStream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class flatMapoperation {


    static class Student {

        private int id;
        private String Studentname;
        private double age;
        private double salary;

        public Student(int id, String studentname, double age, double salary) {
            this.id = id;
            Studentname = studentname;
            this.age = age;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", Studentname='" + Studentname + '\'' +
                    ", age=" + age +
                    ", salary=" + salary +
                    '}';
        }

        public int getId() {
            return id;
        }

        public String getStudentname() {
            return Studentname;
        }

        public double getAge() {
            return age;
        }

        public double getSalary() {
            return salary;
        }
    }


    public static void main(String[] args) {


        // ✅ 5 Students dataset
        List<Student> students = Arrays.asList(
                new Student(1, "Shamdhan", 22, 25000),
                new Student(2, "Sudam", 23, 28000),
                new Student(3, "Nikhil", 24, 30000),
                new Student(4, "Raj", 25, 27000),
                new Student(5, "Amit", 26, 30000)
        );

        students.forEach(System.out::println);


        List<List<String>> flatmaplist = List.of(List.of("A", "B"), List.of("C", "D"));

        System.out.println(flatmaplist);

        List<String> list = flatmaplist.stream().flatMap(List::stream).toList();
        System.out.println(list);


        List<String> list1 = flatmaplist.stream().flatMap(s -> Arrays.stream(s.toString().split(", ")))
                .distinct()
                .toList();
        System.out.println(list1);

        List<Double> studentSalary = students.stream()
                .map(Student::getSalary)  // flatten nested collections
                .distinct()
                .toList();

        System.out.println(studentSalary);   // flatmap is basically use for ex if you want list or data return chahie tab use karate he

        List<Student> list2 = students.stream().distinct().toList();
        System.out.println(list2);
        List<String> list3 = students.stream().map(s -> s.getStudentname())
                .distinct()
                .toList();
        System.out.println(list3);


        students.stream()
                .sorted(Comparator.comparingDouble(Student::getSalary).reversed())
                .limit(5)
                .forEach(System.out::println);


        String str = "I am java developer with java, spring boot and mysql database ";

        List<Character> list4 = str.chars()
                .mapToObj(c -> (char) c)
                .filter(c-> c !=' ')
                .distinct()
                .toList();

        System.out.println(list4);






    }
}
