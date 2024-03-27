import java.util.Scanner;
public class EmployeeBook {
    // поля
    private final Department[] departments = new Department[9];
    private int deptCount;
    private final Employee[] employees = new Employee[11];
    // метод возвращает количество ненулевых элементов в массиве "ОТДЕЛЫ"
    public int returnDepLength() {
        return deptCount;
    }
    // метод возвращает отдел по номеру
    public Department returnDepartment(int deptNumber) {
        return departments[deptNumber - 1];
    }
    // распечатка полной инофрмации в списке сотрудников
    public void printAllInfo() {
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee);
            }
        }
    }
    public void printAllInfo(Department dept) {
        for (Employee employee : employees) {
            if (employee != null && dept.equals(employee.getDept())) {
                System.out.println(employee.toStringWithoutDepartment());
            }
        }
    }
    // расчет суммы всех зарплат
    public double calculateTotalSalary() {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }
    // нахождение сотрудника с минимальной зарплатой
    public Employee findMinSalary() {
        int minSalaryEmployee = 0;
        double minimalSalary = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minimalSalary) {
                minimalSalary = employees[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        return employees[minSalaryEmployee];
    }
    // нахождение сотрудника с максимальной зарплатой
    public Employee findMaxSalary() {
        double maximalSalary = 0;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maximalSalary) {
                maximalSalary = employees[i].getSalary();
                maxSalaryEmployee = i;
            }
        }
        return employees[maxSalaryEmployee];
    }
    // расчет среднего арифметического зарплат всех сотрудников
    public double calculateAverageSalary() {
        double totalSalary = 0;
        int employeeCount = 0;
        for (Employee employee : employees) {
            if (employee != null) {
                totalSalary += employee.getSalary();
                employeeCount++;
            }
        }
        return totalSalary / employeeCount;
    }
    // распечатать список сотрудников
    public void printEmployeeList() {
        System.out.println("Сотрудники предприятия:");
        for (Employee employee : employees) {
            if (employee != null) {
                System.out.println(employee.toStringOnlyName());
            }
        }
    }
    // увеличение на процент
    private double indexing(double salary, int index) {
        return salary + salary * index / 100;
    }
    // индексирование зарплат
    public void calculateIndexedSalary(int index) {
        for (Employee employee : employees) {
            if (employee != null) {
                double indexedSalary = indexing(employee.getSalary(), index);
                employee.setSalary(indexedSalary);
            }
        }
    }
    // расчет суммы зарплат одного отдела
    public double calculateTotalSalary(Department dept) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && dept.equals(employee.getDept())) {
                totalSalary += employee.getSalary();
            }
        }
        return totalSalary;
    }
    // расчет среднего арифметического зарплат всех сотрудников отдела
    public double calculateAverageSalary(Department dept) {
        int deptEmployeeCount = 0;
        double totalSalary = 0;
        for (Employee employee : employees) {
            if (employee != null && dept.equals(employee.getDept())) {
                deptEmployeeCount++;
                totalSalary += employee.getSalary();
            }
        }
        if (deptEmployeeCount == 0) {
            return 0;
        } else {
            return totalSalary / deptEmployeeCount;
        }
    }
    // нахождение сотрудника отдела с минимальной зарплатой
    public Employee findMinSalary(Department dept) {
        int minSalaryEmployee = -1;
        double minimalSalary = Integer.MAX_VALUE;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < minimalSalary &&
                    dept.equals(employees[i].getDept())) {
                minimalSalary = employees[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        return employees[minSalaryEmployee];
    }
    // нахождение сотрудника с максимальной зарплатой
    public Employee findMaxSalary(Department dept) {
        double maximalSalary = 0;
        int maxSalaryEmployee = -1;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > maximalSalary &&
                    dept.equals(employees[i].getDept())) {
                maximalSalary = employees[i].getSalary();
                maxSalaryEmployee = i;
            }
        }
        return employees[maxSalaryEmployee];
    }
    // индексирование зарплат по отделу
    public void calculateIndexedSalary(Department dept, int index) {
        for (Employee employee : employees) {
            if (employee != null && dept.equals(employee.getDept())) {
                double indexedSalary = indexing(employee.getSalary(), index);
                employee.setSalary(indexedSalary);
            }
        }
    }
    // найти сотрудников с зарплатой меньше чем число
    public void printSalaryComparisonLess(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() < salary) {
                System.out.println("Зарплата сотрудника " + employee + " меньше чем " + salary);
            }
        }
    }
    // найти сотрудников с зарплатой не меньше чем число
    public void printSalaryComparisonMore(double salary) {
        for (Employee employee : employees) {
            if (employee != null && employee.getSalary() >= salary) {
                System.out.println("Зарплата сотрудника " + employee + " больше чем " + salary);
            }
        }
    }
    // найти сотрудника по ID
    public Employee findByID(int number) {
        for (Employee employee : employees) {
            if (employee.getID() == number) {
                return employee;
            }
        }
        return null;
    }
    // найти свободную ячейку массива
    private int findFreeSpace() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                return i;
            }
        }
        return -1;
    }
    // удалить сотрудника по ID
    public void deleteEmployeeByID(int employeeID) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getID() == employeeID) {
                employees[i] = null;
            }
        }
    }
    // добавить отдел
    public void addNewDepartment(String departmentName) {
        if (deptCount >= departments.length) {
            throw new RuntimeException("NO FREE SPACE FOR NEW DEPARTMENT");
        } else {
            departments[deptCount++] = new Department(departmentName);
        }
    }
    // добавить сотрудника
    public void addNewEmployee(Department dept, String sName, String fName, String mName, double salary) {
        if (findFreeSpace() >= 0) {
            int free = findFreeSpace();
            employees[free] = new Employee(dept, sName, fName, mName, salary);
        } else {
            throw new RuntimeException("EMPLOYEE BOOK IS FULL");
        }
    }
    // создать нового сотрудника
    public void createNewEmployee() {
        if (findFreeSpace() >= 0) {
            Scanner scan = new Scanner(System.in);
            int free = findFreeSpace();
            String firstName = "";
            String secondName = "";
            String middleName = "";
            System.out.println("Веедите номер отдела");
            int deptNumber = scan.nextInt() - 1;
            System.out.println("Веедите фамилию");
            if (scan.hasNextLine()) {
                secondName = scan.nextLine();
            }
            System.out.println("Веедите имя");
            if (scan.hasNextLine()) {
                firstName = scan.nextLine();
            }
            System.out.println("Веедите отчество");
            if (scan.hasNextLine()) {
                middleName = scan.nextLine();
            }
            System.out.println("Веедите значение заработной платы");
            double salary = scan.nextDouble();
            employees[free] = new Employee(departments[deptNumber], secondName, firstName, middleName, salary);
        } else {
            System.out.println("Нет свободных ячеек");
        }
    }


}

