import java.io.IOException;

public class Main {

    private static final String FILE_NAME = "employees.csv";

    public static void main(String[] args) throws IOException {
        Employee[] employees = FileUtils.readFileAndAddEmployeeToArray(FILE_NAME);
        double averageSalary = FileUtils.calculateAverageSalary(employees);
        double lowestSalary = FileUtils.findLowestSalary(employees);
        double highestSalary = FileUtils.findHighestSalary(employees);
        int itDepartment = FileUtils.calculateItDepartments(employees);
        int supportDepartment = FileUtils.calculateSupportDepartments(employees);
        int managementDepartment = FileUtils.calculateManagementDepartments(employees);
        EmployeeStats stats = new EmployeeStats(averageSalary, lowestSalary, highestSalary,
                itDepartment, supportDepartment, managementDepartment);
        FileUtils.writeDataToFile("stats.txt", stats);
    }
}