
import java.io.*;
import java.util.Scanner;

public class FileUtils {

    private static int lines = 0;
    private static Employee[] employees = new Employee[lines];

    public static Employee[] readFileAndAddEmployeeToArray(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            int lines = countLines(fileName);
            Employee[] employees = new Employee[lines];
            for (int i = 0; i < employees.length; i++) {
                if (scanner.hasNextLine()) {
                    String readLines = scanner.nextLine();
                    String[] splitLine = readLines.split(";");
                    employees[i] = createEmployee(splitLine);
                    System.out.println(employees[i]);
                }
            }
            System.out.println("Wczytano informacje z pliku " + fileName);
            return employees;
        }
    }

    public static void writeDataToFile(String statsFileName, EmployeeStats stats) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(statsFileName))) {
            bufferedWriter.write("Średnia wypłata: " + stats.getAverageSalary());
            bufferedWriter.newLine();
            bufferedWriter.write("Minimalna wypłata: " + stats.getLowestSalary());
            bufferedWriter.newLine();
            bufferedWriter.write("Maksymalna wypłata: " + stats.getHighestSalary());
            bufferedWriter.newLine();
            bufferedWriter.write("Liczba pracowników IT: " + stats.getItDepartment());
            bufferedWriter.newLine();
            bufferedWriter.write("Liczba pracowników Support: " + stats.getSupportDepartment());
            bufferedWriter.newLine();
            bufferedWriter.write("Liczba pracowników Management: " + stats.getManagementDepartment());
        }
    }

    public static double calculateAverageSalary(Employee[] employee) {
        double sum = 0;
        for (Employee employee1 : employee) {
            sum += employee1.getSalary();
        }
        return sum / employee.length;
    }

    public static double findLowestSalary(Employee[] employee) {
        double sum = employee[0].getSalary();
        for (Employee employee1 : employee) {
            if (employee1.getSalary() < sum) {
                sum = employee1.getSalary();
            }
        }
        return sum;
    }

    public static double findHighestSalary(Employee[] employee) {
        double sum = employee[0].getSalary();
        for (Employee employee1 : employee) {
            if (employee1.getSalary() > sum) {
                sum = employee1.getSalary();
            }
        }
        return sum;
    }

    public static int calculateItDepartments(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getSection().equals("IT")) {
                sum++;
            }
        }
        return sum;
    }

    public static int calculateSupportDepartments(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getSection().equals("Support")) {
                sum++;
            }
        }
        return sum;
    }

    public static int calculateManagementDepartments(Employee[] employees) {
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.getSection().equals("Management")) {
                sum++;
            }
        }
        return sum;
    }

    private static Employee createEmployee(String[] splitLine) {
        String firstName = splitLine[0];
        String lastName = splitLine[1];
        String pesel = splitLine[2];
        String section = splitLine[3];
        double salary = Double.parseDouble(splitLine[4]);
        return new Employee(firstName, lastName, pesel, section, salary);
    }

    private static int countLines(String fileName) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
            return lines;
        }
    }
}