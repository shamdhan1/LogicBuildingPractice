package JavaStream;



import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class MaptoIntOperation {

    static  class Employee {
        private int id;
        private String names;
        private int salary;
        private int age;

        public Employee(int id, String names, int salary, int age) {
            this.id = id;
            this.names = names;
            this.salary = salary;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public String getNames() {
            return names;
        }

        public int getSalary() {
            return salary;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    ", names='" + names + '\'' +
                    ", salary=" + salary +
                    ", age=" + age +
                    '}';
        }



    }


    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Sudam", 12000, 25),
                new Employee(2, "Shamdhan", 18000, 28),
                new Employee(3, "Nikhil", 22000, 30),
                new Employee(4, "Raj", 15000, 26),
                new Employee(5, "Amit", 30000, 35)
        );

        List<Integer> array = Arrays.asList(10, 25, 30, 45, 60, 75, 90, 100, 5, 15);

        List<String> names = Arrays.asList("Shamdhan", "Sudam", "Nikhil", "Raj", "Amit",
                "Vikas", "Pooja", "Anjali", "Sunita");


        System.out.println(employees);
        System.out.println(array);
        System.out.println(names);

        OptionalDouble average = OptionalDouble.of(employees.stream().mapToInt(Employee::getAge).sum());
        System.out.println(average);


        int sum = array.stream().mapToInt(Integer::intValue).sum();
        System.out.println("\n\nSum of Integer List: " + sum);



        employees.stream().mapToInt(Employee::getAge).
                forEach(age -> System.out.println("emplyee age  "+age));

        double v = employees.stream().mapToInt(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println(v);


        int i = employees.stream().mapToInt(Employee::getSalary)
                .max()
                .orElse(0);
        System.out.println(i);

        List<String> employee_names  = employees.stream().map(Employee::getNames)
                .collect(Collectors.toList());
        System.out.println(employee_names);


        List<Double> list = employees.stream().mapToDouble(g -> g.salary / 100.0).boxed().toList();
        System.out.println(list);


        double total_salary = employees.stream().mapToDouble(Employee::getSalary).sum();

        List<String> pracentagesalaryofTotalSalary = employees.stream()
                .map(e -> e.getNames() + " : " + String.format("%2f", e.getSalary() * 100 / total_salary) + "%")
                .collect(Collectors.toList());
        System.out.println(pracentagesalaryofTotalSalary);


        int maxSalary = employees.stream().mapToInt(Employee::getSalary)
                .max()
                .orElse(0);

        List<String> PracentagebyMaxsalary = employees.stream()
                .map(e -> e.getNames() + " " + e.getSalary() * 100 / maxSalary + "%")
                .collect(Collectors.toList());
        System.out.println(PracentagebyMaxsalary);





    }
}
