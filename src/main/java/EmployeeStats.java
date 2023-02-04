import java.text.DecimalFormat;

public class EmployeeStats {
    private final double averageSalary;
    private final double lowestSalary;
    private final double highestSalary;
    private final int itDepartment;
    private final int supportDepartment;
    private final int managementDepartment;

    public EmployeeStats(double averageSalary, double lowestSalary, double highestSalary, int itDepartment, int supportDepartment, int managementDepartment) {
        this.averageSalary = averageSalary;
        this.lowestSalary = lowestSalary;
        this.highestSalary = highestSalary;
        this.itDepartment = itDepartment;
        this.supportDepartment = supportDepartment;
        this.managementDepartment = managementDepartment;
    }

    public double getAverageSalary() {
        return averageSalary;
    }

    public double getLowestSalary() {
        return lowestSalary;
    }

    public double getHighestSalary() {
        return highestSalary;
    }

    public int getItDepartment() {
        return itDepartment;
    }

    public int getSupportDepartment() {
        return supportDepartment;
    }

    public int getManagementDepartment() {
        return managementDepartment;
    }
}