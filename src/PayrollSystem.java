import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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

        // Create a thread pool (3 threads here; you can tune this)
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Employee e : employees) {
            executor.submit(() -> {
                String info = "ID: " + e.getEmployeeId() +
                        " | Name: " + e.getFullName() +
                        " | Role: " + e.getRole() +
                        " | Department: " + e.getDepartment() +
                        String.format(" | Salary: $%.2f", e.calculateSalary());

                // Print with thread info for clarity
                System.out.println(Thread.currentThread().getName() + " -> " + info);
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // wait for all tasks to finish
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
    public void payAllEmployees(BankAccount account) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        for (Employee e : employees) {
            executor.submit(() -> {
                double salary = e.calculateSalary();
                account.withdraw(salary, e.getFullName());
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
            // wait for all payments to finish
        }

        System.out.println("✅ All salaries processed!");
    }

}
