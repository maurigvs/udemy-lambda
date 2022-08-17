import app.entities.Product;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);
        String path = "/Users/mauri/Temp/employees.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Product> list = new ArrayList<>();
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                list.add(new Product(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            System.out.print("Enter salary: ");
            Double salary = sc.nextDouble();

            System.out.println("Email of people whose salary is more than " + salary);

            List<String> emails = list.stream()
                    .filter(x -> x.getSalary() > salary)
                    .map(y -> y.getEmail())
                    .sorted().collect(Collectors.toList());

            emails.forEach(System.out::println);

            System.out.print("Sum of salary of people whose name starts with 'M': ");
            String initial = "M";
            int sum = list.stream()
                    .filter(x -> x.getName().substring(0,1).equals(initial))
                    .reduce(0.0, (x, y) -> Double.parseDouble(x.getSalary()) + Double.parseDouble(y.getSalary()));

            System.out.println(list.stream().fil);

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        sc.close();

    }
}