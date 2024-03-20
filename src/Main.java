import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Department[] department = new Department[5]; // объявление массива объектов "Отдел"
        department[0] = new Department("Первый");
        department[1] = new Department("Второй");
        department[2] = new Department("Третий");
        department[3] = new Department("Четвертый");
        department[4] = new Department("Пятый");
        EmployeeBook employeeBook = new EmployeeBook();
        // заполнение массива
        employeeBook.employees[0] = new Employee(department[0], "Глинка", "Михаил", "Иванович", 30000);
        employeeBook.employees[1] = new Employee(department[1], "Мусоргский", "Модест", "Петрович", 40000);
        employeeBook.employees[2] = new Employee(department[2], "Рахманинов", "Сергей", "Васильевич", 35000);
        employeeBook.employees[3] = new Employee(department[3], "Чайковский", "Петр", "Ильич", 37000);
        employeeBook.employees[4] = new Employee(department[4], "Бородин", "Александр", "Порфирьевич", 45000);
        employeeBook.employees[5] = new Employee(department[0], "Римский-Корсаков", "Николай", "Андреевич", 27000);
        employeeBook.employees[6] = new Employee(department[1], "Скрябин", "Александр", "Николаевич", 31000);
        employeeBook.employees[7] = new Employee(department[2], "Шостакович", "Дмитрий", "Дмитриевич", 28000);
        employeeBook.employees[8] = new Employee(department[3], "Прокофьев", "Сергей", "Сергеевич", 32000);
        employeeBook.employees[9] = new Employee(department[4], "Стравинский", "Игорь", "Федорович", 39000);
        // работа с массивом сотрудников
        System.out.println(employeeBook.employees[1].getID());
        Scanner scan = new Scanner(System.in);
        System.out.println("Добро пожаловать, бухгалтер");
        System.out.println("Для работы со всеми сотрудниками введите '0'");
        System.out.println("Для работы с отделом введите '1'");
        int command;
        command = scan.nextInt();
        if (command == 0) {
            employeeBook.printEmployeeList();
            System.out.println("Список доступных действий:");
            System.out.println("1 - Распечатать полную информацию по сотрудникам");
            System.out.println("2 - Вывести сумму зарплат");
            System.out.println("3 - Вывести сотрудника с минимальной зарплатой");
            System.out.println("4 - Вывести сотрудника с максимальной зарплатой");
            System.out.println("5 - Вывести среднее значение зарплат");
            System.out.println("6 - Произвести индексирование на процент");
            System.out.println("7 - Сверить зарплату сотрудников с определенным числом");
            System.out.println("8 - Добавление новой записи о сотруднике");
            System.out.println("9 - Удаление записи о сотруднике");
            command = scan.nextInt();
            switch (command) {
                case 1:
                    employeeBook.printAllInfo();
                    break;
                case 2:
                    System.out.println("Общая зарплата сотрудников за месяц: " + employeeBook.calculateTotalSalary());
                    break;
                case 3:
                    System.out.println("Сотрудник с наименьшей зарплатой: ");
                    System.out.println(employeeBook.findMinSalary());
                    break;
                case 4:
                    System.out.println("Сотрудник с наибольшей зарплатой: ");
                    System.out.println(employeeBook.findMaxSalary());
                    break;
                case 5:
                    System.out.println("Среднее значение зарплат: " +
                            employeeBook.calculateAverageSalary());
                    break;
                case 6:
                    System.out.println(" Индексирование зарплаты, нужно ввести процент");
                    int index = scan.nextInt();
                    employeeBook.calculateIndexedSalary(index);
                    employeeBook.printAllInfo();
                    break;
                case 7:
                    System.out.println(" Нужно ввести зарплату для проверки");
                    double salary = scan.nextDouble();
                    employeeBook.printSalaryComparisonMore(salary);
                    employeeBook.printSalaryComparisonLess(salary);
                    break;
                case 8:
                    System.out.println(" Веедите данные:");
                    employeeBook.createNewEmployee(department);
                    break;
                case 9:
                    System.out.println(" Веедите номер сотрудника которого хотите удалить:");
                    int deleteID = scan.nextInt();
                    employeeBook.deleteEmployeeByID(deleteID);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        } else if (command == 1) {
            System.out.println("Нужно ввести отдел");
            int dept = scan.nextInt() - 1;
            System.out.println("Список доступных действий:");
            System.out.println("1 - Распечатать полную информацию по сотрудникам");
            System.out.println("2 - Вывести сумму зарплат");
            System.out.println("3 - Вывести сотрудника с минимальной зарплатой");
            System.out.println("4 - Вывести сотрудника с максимальной зарплатой");
            System.out.println("5 - Вывести среднее значение зарплат");
            command = scan.nextInt();
            switch (command) {
                case 1:
                    employeeBook.printAllInfo(department[dept]);
                    break;
                case 2:
                    System.out.println("Общая зарплата сотрудников отдела " + dept + " за месяц: " +
                            employeeBook.calculateTotalSalary(department[dept]));
                    break;
                case 3:
                    System.out.println("Сотрудник " + dept + " с наименьшей зарплатой: ");
                    System.out.println(employeeBook.findMinSalary(department[dept]));
                    break;
                case 4:
                    System.out.println("Сотрудник " + dept + " с наибольшей зарплатой: ");
                    System.out.println(employeeBook.findMaxSalary(department[dept]));
                    break;
                case 5:
                    System.out.println("Среднее значение зарплат отдела " + dept + ": " +
                            employeeBook.calculateAverageSalary(department[dept]));
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + command);
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + command);
        }
    }
    private static class EmployeeBook {
        private final Employee[] employees = new Employee[11];
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
                    System.out.println(employee);
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
            return  totalSalary;
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
            return calculateTotalSalary() / employees.length;
        }
        // распечатать список сотрудников
        public void printEmployeeList() {
            System.out.println("СОтрудники предприятия:");
            for (Employee employee : employees) {
                if (employee != null) {
                    System.out.println(employee.getSecondName() + ' ' + employee.getFirstName()
                            + ' ' + employee.getMiddleName());
                }
            }
        }
        public double indexing(double salary, int index){
            salary+= salary * index / 100;
            return salary;
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
            return  totalSalary;
        }
        // расчет среднего арифметического зарплат всех сотрудников отдела
        public double calculateAverageSalary(Department dept) {
            int deptEmployeeCount = 0;
            for (Employee employee : employees) {
                if (employee != null && dept.equals(employee.getDept())) {
                    deptEmployeeCount++;
                }
            }
            if (deptEmployeeCount == 0) {
                return 0;
            } else {
                return calculateTotalSalary(dept) / deptEmployeeCount;
            }
        }
        // нахождение сотрудника отдела с минимальной зарплатой
        public Employee findMinSalary(Department dept) {
            int minSalaryEmployee = 0;
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
            int maxSalaryEmployee = 0;
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getSalary() > maximalSalary &&
                        dept.equals(employees[i].getDept())) {
                    maximalSalary = employees[i].getSalary();
                    maxSalaryEmployee = i;
                }
            }
            return employees[maxSalaryEmployee];
        }
        public void printSalaryComparisonLess(double salary) {
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() < salary) {
                    System.out.println("Зарплата сотрудника " + employee + " меньше чем " + salary);
                }
            }
        }
        public void printSalaryComparisonMore(double salary) {
            for (Employee employee : employees) {
                if (employee != null && employee.getSalary() > salary) {
                    System.out.println("Зарплата сотрудника " + employee + " больше чем " + salary);
                }
            }
        }
        public  int getEmployeeByID(int number) {
            for (int i = 0; i< employees.length; i++) {
                if (employees[i].getID() == number) {
                    return i;
                }
            }
            return -1;
        }
        public boolean checkFreeSpace() {
            for (Employee employee : employees) {
                if (employee == null) {
                    return true;
                }
            }
            return false;
        }
        public int findFreeSpace() {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        public void deleteEmployeeByID(int employeeID) {
            employees[getEmployeeByID(employeeID)] = null;
        }
        public void createNewEmployee(Department[] departments) {
            if (checkFreeSpace()) {
                Scanner scan = new Scanner(System.in);
                int free = findFreeSpace();
                String firstName = "";
                String secondName = "";
                String middleName = "";
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
                System.out.println("Веедите номер отдела");
                int deptNumber = scan.nextInt() - 1;
                System.out.println("Веедите значение заработной платы");
                double salary = scan.nextDouble();
                employees[free] = new Employee();
                employees[free].setFirstName(firstName);
                employees[free].setMiddleName(middleName);
                employees[free].setSecondName(secondName);
                employees[free].setDept(departments[deptNumber]);
                employees[free].setSalary(salary);
            }  else {
                System.out.println("EMPLOYEE BOOK IS FULL");
            }
        }
    }

}
