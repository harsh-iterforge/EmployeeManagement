import java.util.ArrayList;
import java.util.List;

public class PayrollSystem {
    private List<Employee> employees = new ArrayList<>();
    private String company;

    public PayrollSystem(String company) {
        this.company = company;
    }


    public void addEmployee(Employee e) {
        employees.add(e);
    }


    public boolean removeEmployee(String id) {
        return employees.removeIf(e -> e.getEmployeeId().equalsIgnoreCase(id));
    }


    public List<Employee> searchByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getFullName().toLowerCase().contains(name.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }


    public List<Employee> searchByRole(String role) {
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (e.getRole().toLowerCase().contains(role.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }


    public double calculateTotalPayroll() {
        double total = 0;
        for (Employee e : employees) {
            total += e.calculateSalary();
        }
        return total;
    }


    public void displayAllEmployees() {
        System.out.println("===== Employee List (" + company + ") =====");
        for (Employee e : employees) {
            System.out.println("ID: " + e.getEmployeeId() +
                    " | Name: " + e.getFullName() +
                    " | Role: " + e.getRole() +
                    " | Department: " + e.getDepartment() +
                    String.format(" | Salary: $%.2f", e.calculateSalary()));
        }
        System.out.println("===========================================");
    }

    public String generateSummaryReport() {
        StringBuilder report = new StringBuilder();
        report.append("\n===== Payroll Summary Report =====\n");
        report.append("Company: ").append(company).append("\n");
        report.append("Total Employees: ").append(employees.size()).append("\n");

        double totalPayroll = calculateTotalPayroll();
        report.append(String.format("Total Payroll: $%.2f\n", totalPayroll));

        report.append("\nEmployee Details:\n");
        for (Employee e : employees) {
            report.append(String.format("%s (%s) - $%.2f\n",
                    e.getFullName(), e.getRole(), e.calculateSalary()));
        }

        report.append("=================================\n");
        return report.toString();
    }
}
