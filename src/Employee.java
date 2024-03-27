import java.util.Objects;

public class Employee {
    private int id;
    public static int counter;
    static {
        counter = 0;
    }
    private Department dept;
    private String firstName;
    private String middleName;
    private String secondName;
    private double salary;

    public Employee(Department dept, String secondName, String firstName, String middleName, double salary) {
        this.dept = dept;
        this.firstName = firstName;
        this.middleName = middleName;
        this.secondName = secondName;
        this.salary = salary;
        this.id = ++counter;
    }
    public Employee(Department dept, String secondName, String firstName, double salary) {
        this(dept, secondName, firstName, "", salary);
        this.id = ++counter;
    }

    public Employee() {
        this.id = ++counter;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSecondName() {
        return secondName;
    }

    public Department getDept() {
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
    public void setDept(Department dept) {
        this.dept = dept;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", " + dept +
                ", Ф.И.О: " + secondName + ' ' +
                firstName + ' ' +
                middleName +
                ", зарплата: " + salary + " рублей";
    }
    public String toStringOnlyName() {
        return secondName + ' ' +
                firstName + ' ' +
                middleName;
    }
    public String toStringWithoutDepartment() {
        return "id=" + id +
                ", Ф.И.О: " + secondName + ' ' +
                firstName + ' ' +
                middleName +
                ", зарплата: " + salary + " рублей";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(middleName, employee.middleName) && Objects.equals(secondName, employee.secondName);
    }
    @Override
    public int hashCode() {
        return Objects.hash(firstName, middleName, secondName);
    }
}
