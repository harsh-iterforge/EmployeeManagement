public class Designer extends Employee{
    private String designTool;
    private int designsCompleted=0;
    private String specialization;
    public Designer(String fullName, double baseSalary,String department,String designTool,String specialization){
        super(fullName,baseSalary,department);
        this.designTool = designTool;
        this.specialization = specialization;
    }
    public double calculateSalary(){
        return getBaseSalary() + (getBaseSalary() * 0.15) + getBonus();
    }
    public String getRole(){
        return specialization + " Designer";
    }
    public double getBonus(){
        return designsCompleted * 250;
    }
    public void completeDesign() {
        designsCompleted++;
    }

    public void completeDesign(int count) {
        designsCompleted += count;
    }
    public void completeDesign(String newSpecialization, int count) {
        this.specialization = newSpecialization;
        designsCompleted += count;
    }

    public String generatePortfolioURL(){
        return "https://portfolio.techcorp.com/" + getFirstName() + getLastName();
    }
    public String createSignature(){
        return getInitial() + " | " + designTool + " | " + specialization;
    }

}
