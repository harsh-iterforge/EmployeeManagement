
public class Manager extends Employee{
    private int teamSize;
    private double projectBonus;

    public Manager(String fullName, double baseSalary,String department){
        super(fullName,baseSalary,department);
    }
    public double calculateSalary(){
        return getBaseSalary() + (getBaseSalary() * 0.20) + projectBonus + getBonus();
    }
    public String getRole(){
        return "Manager";
    }
    public double getBonus(){
        return teamSize * 500;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public void setProjectBonus(double projectBonus) {
        this.projectBonus = projectBonus;
    }
    public void setProjectBonus(String projectBonus) {
        try {
            double number = Double.parseDouble(projectBonus);
            checkNumber(number);
            this.projectBonus = number;

        }catch(NumberFormatException e){
            System.out.println("Error: '" + projectBonus + "' is not a valid integer.");
        }catch (NegativeNumberException e) {
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String toString() {
        return String.format("Manager [ID=%s, Name=%s, TeamSize=%d, Salary=%.2f]",
                getEmployeeId(), getFullName(), teamSize, calculateSalary());
    }
    public static void checkNumber(Double num) throws NegativeNumberException {
        if (num < 0) {
            throw new NegativeNumberException("Number cannot be negative: " + num);
        } else {
            System.out.println("Number is valid: " + num);
        }
    }

}
