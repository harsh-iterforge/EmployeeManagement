import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankAccount companyAccount = new BankAccount(500000);
        PayrollSystem payroll = new PayrollSystem("TechCorp");
        Manager manager = new Manager("Harsh Sanjay Tuli", 8000, "Management");
        manager.setTeamSize(5);
        manager.setProjectBonus(2000);
        manager.setProjectBonus("abc");
        manager.setProjectBonus("-80");

        Developer dev1 = new Developer("Ankit Ramesh Pradhan", 6000, "Development", "Java", "Senior");
        dev1.completeProject();
        dev1.completeProject(2);

        Designer designer1 = new Designer("Parth Dhiren Wande", 5000, "Design", "Photoshop", "UI/UX");
        designer1.completeDesign();
        designer1.completeDesign(3);

        payroll.addEmployee(manager);
        payroll.addEmployee(dev1);
        payroll.addEmployee(designer1);

        payroll.displayAllEmployees();


        System.out.println("\n--- Encapsulation Demo ---");
        System.out.println("Manager ID: " + manager.getEmployeeId());
        System.out.println("Developer Email: " + dev1.generateEmail());
        System.out.println("Designer Portfolio: " + designer1.generatePortfolioURL());


        System.out.println("\n--- Polymorphism Demo ---");
        System.out.println(manager.generatePaySlip());
        System.out.println(dev1.generatePaySlip());
        System.out.println(designer1.generatePaySlip());


        System.out.println("\n--- Search Demo ---");
        List<Employee> searchByName = payroll.searchByName("Alice");
        System.out.println("Search by name 'Alice':");
        for(Employee e : searchByName){
            System.out.println(e.getFullName() + " | " + e.getRole());
        }

        List<Employee> searchByRole = payroll.searchByRole("Designer");
        System.out.println("\nSearch by role 'Designer':");
        for(Employee e : searchByRole){
            System.out.println(e.getFullName() + " | " + e.getRole());
        }


        System.out.println("\n--- Payroll Summary Report ---");
        System.out.println(payroll.generateSummaryReport());


        dev1.completeProject(5);
        designer1.completeDesign("Graphic", 2);
        System.out.println("\nAfter completing additional projects/designs:");
        payroll.displayAllEmployees();


        payroll.payAllEmployees(companyAccount);

        System.out.println("Final Bank Balance: $" + companyAccount.getBalance());
    }
}
