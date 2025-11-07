public abstract class Employee {
    private String employeeId;
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private double baseSalary;
    private String department;
    private static  int id = 100;


    public Employee(){

    }
    public Employee( String fullName,double baseSalary, String department) {
        this.baseSalary = baseSalary;
        this.fullName = fullName;
        this.department = department;
        parseName();
        generateEmployeeId();
    }
    private void parseName(){
        String[] parts = fullName.split("\\s+");
        firstName = parts[0];
        middleName = parts[1];
        lastName = parts[2];
    }
    public String getInitial(){
        StringBuilder sb = new StringBuilder();
        sb.append(firstName.charAt(0));
        sb.append(middleName.charAt(0));
        sb.append(lastName.charAt(0));
        return sb.toString();
    }
    private void generateEmployeeId(){
        employeeId = getRole().substring(0,3) + "_" + getInitial() + "_" +  id++;
    }
    public String generatePaySlip() {
        return "------ Payslip ------\n"
                + "Employee: " + fullName + "\n"
                + "Role: " + getRole() + "\n"
                + "Base Salary: $" + String.format("%.2f", baseSalary) + "\n"
                + "Bonus: $" + String.format("%.2f", getBonus()) + "\n"
                + "Total Salary: $" + String.format("%.2f", calculateSalary()) + "\n"
                + "---------------------\n";
    }
    public abstract double calculateSalary();
    public abstract String getRole();
    public abstract double getBonus();

    public String getEmployeeId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName() {
        return fullName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }
}
