public class Developer extends Employee {
    private String programmingLanguage;
    private int projectsCompleted;
    private String skillLevel;


    public Developer(String fullName, double baseSalary,String department,String programmingLanguage,String skillLevel){
        super(fullName,baseSalary,department);
        this.programmingLanguage = programmingLanguage;
        this.skillLevel = skillLevel;
    }
    public double calculateSalary(){
        double skillAllowance = 0;
        if (skillLevel.equalsIgnoreCase("senior")) {
            skillAllowance = 0.25;
        } else if (skillLevel.equalsIgnoreCase("mid")) {
            skillAllowance = 0.15;
        } else {
            skillAllowance = 0.05;
        }
        return getBaseSalary() + (getBaseSalary() * skillAllowance) + getBonus();

    }
    public String getRole(){
        return "Developer";
    }
    public double getBonus(){
        return projectsCompleted * 300;
    }
    public void completeProject(){
        projectsCompleted++;
    }
    public void completeProject(int a){
        projectsCompleted+=a;
    }
    public String generateEmail(){
        return getFirstName().charAt(0) + "." + getLastName() +"@techcorp.com";
    }



}
