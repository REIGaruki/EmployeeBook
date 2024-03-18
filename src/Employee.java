public class Employee {
    private final int id;
    public static int counter;
    static {
        counter = 0;
    }
    private String dept;
    private String firstName;
    private String middleName;
    private String secondName;
    private double salary;

    public Employee() {
        id = ++counter;
    }
    public String getName() {
        return (this.secondName + " " + this.firstName + " " + this.middleName);
    }
    public String getDept() {
        return this.dept;
    }
    public double getSalary() {
        return this.salary;
    }
    public int getID() {
        return this.id;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void setDept(String dept) {
        this.dept = dept;
    }
    public void setDept(int dept) {
        this.dept = Integer.toString(dept);
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
}
