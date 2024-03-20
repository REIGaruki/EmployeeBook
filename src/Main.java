import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        employeeBook.department[0] = new Department("Первый");
        employeeBook.department[1] = new Department("Второй");
        employeeBook.department[2] = new Department("Третий");
        employeeBook.department[3] = new Department("Четвертый");
        employeeBook.department[4] = new Department("Пятый");
        // заполнение массива
        employeeBook.addNewEmployee(1, "Глинка", "Михаил", "Иванович", 30000);
        employeeBook.addNewEmployee(2, "Мусоргский", "Модест", "Петрович", 40000);
        employeeBook.addNewEmployee(3, "Рахманинов", "Сергей", "Васильевич", 35000);
        employeeBook.addNewEmployee(4, "Чайковский", "Петр", "Ильич", 37000);
        employeeBook.addNewEmployee(5, "Бородин", "Александр", "Порфирьевич", 45000);
        employeeBook.addNewEmployee(1, "Римский-Корсаков", "Николай", "Андреевич", 27000);
        employeeBook.addNewEmployee(2, "Скрябин", "Александр", "Николаевич", 31000);
        employeeBook.addNewEmployee(3, "Шостакович", "Дмитрий", "Дмитриевич", 28000);
        employeeBook.addNewEmployee(4, "Прокофьев", "Сергей", "Сергеевич", 32000);
        employeeBook.addNewEmployee(5, "Стравинский", "Игорь", "Федорович", 39000);
        // работа с массивом сотрудников
        System.out.println(employeeBook.employees[1].getID());
        Scanner scan = new Scanner(System.in);
        int command = 0;
        while (command >= 0) {
            System.out.println("Добро пожаловать, бухгалтер");
            System.out.println("Для работы с отделом введите его номер");
            for (int i = 1; i <= employeeBook.department.length; i++) {
                System.out.println(i + ". - " + employeeBook.department[i - 1]);
            }
            System.out.println("Для работы со всеми сотрудниками введите '0'");
            System.out.println("Для выхода введите '-1'");
            command = scan.nextInt();
            if (command == -1) {
                System.out.println("Завершение работы.");
            } else if (command == 0) {
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
                int workCommand = scan.nextInt();
                switch (workCommand) {
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
                        System.out.println("Индексирование зарплаты, нужно ввести процент");
                        int index = scan.nextInt();
                        employeeBook.calculateIndexedSalary(index);
                        employeeBook.printAllInfo();
                        break;
                    case 7:
                        System.out.println("Нужно ввести зарплату для проверки");
                        double salary = scan.nextDouble();
                        employeeBook.printSalaryComparisonMore(salary);
                        employeeBook.printSalaryComparisonLess(salary);
                        break;
                    case 8:
                        System.out.println("Веедите данные:");
                        employeeBook.createNewEmployee(employeeBook.department);
                        break;
                    case 9:
                        System.out.println("Веедите номер сотрудника которого хотите удалить:");
                        int deleteID = scan.nextInt();
                        employeeBook.deleteEmployeeByID(deleteID);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + workCommand);
                }
            } else if (command > 0 && command <= employeeBook.department.length) {
                System.out.println("Вы выбрали отдел №" + command + ", " + employeeBook.department[command - 1]);
                System.out.println("Список доступных действий:");
                System.out.println("1 - Распечатать полную информацию по сотрудникам");
                System.out.println("2 - Вывести сумму зарплат");
                System.out.println("3 - Вывести сотрудника с минимальной зарплатой");
                System.out.println("4 - Вывести сотрудника с максимальной зарплатой");
                System.out.println("5 - Вывести среднее значение зарплат");
                System.out.println("6 - Произвести индексирование на процент");
                int deptCommand = scan.nextInt();
                Department dept = employeeBook.department[command - 1];
                switch (deptCommand) {
                    case 1:
                        employeeBook.printAllInfo(dept);
                        break;
                    case 2:
                        System.out.println("Общая зарплата сотрудников отдела №" + command + " за месяц: " +
                                employeeBook.calculateTotalSalary(dept));
                        break;
                    case 3:
                        System.out.println("Сотрудник отдела №" + command + " с наименьшей зарплатой: ");
                        System.out.println(employeeBook.findMinSalary(dept).toString(dept));
                        break;
                    case 4:
                        System.out.println("Сотрудник отдела №" + command + " с наибольшей зарплатой: ");
                        System.out.println(employeeBook.findMaxSalary(dept).toString(dept));
                        break;
                    case 5:
                        System.out.println("Среднее значение зарплат отдела №" + command + ": " +
                                employeeBook.calculateAverageSalary(dept));
                        break;
                    case 6:
                        System.out.println("Индексирование зарплаты, нужно ввести процент");
                        int index = scan.nextInt();
                        employeeBook.calculateIndexedSalary(dept, index);
                        employeeBook.printAllInfo(dept);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + deptCommand);
                }
            } else {
                throw new IllegalStateException("Unexpected value: " + command);
            }
            System.out.println("==========================================================================");
        }
        employeeBook.printAllInfo();
    }
    // конец метода main
    // конец метода main
    // конец метода main
    private static class EmployeeBook {
        Department[] department = new Department[5];
        // объявление массива объектов "Отдел"
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
                    System.out.println(employee.toString(dept));
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
            System.out.println("Сотрудники предприятия:");
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
        public void calculateIndexedSalary(Department dept, int index) {
            for (Employee employee : employees) {
                if (employee != null && dept.equals(employee.getDept())) {
                    double indexedSalary = indexing(employee.getSalary(), index);
                    employee.setSalary(indexedSalary);
                }
            }
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
                if (employee != null && employee.getSalary() >= salary) {
                    System.out.println("Зарплата сотрудника " + employee + " больше чем " + salary);
                }
            }
        }
        public int findByID(int number) {
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
           if (employeeID > Employee.counter || employeeID <= 0 || findByID(employeeID) == findFreeSpace()) {
               throw new RuntimeException("ID не существует или пуст");
            } else {
               employees[findByID(employeeID)] = null;
            }
        }
        public void addNewEmployee(int deptNumber, String secondName, String firstName, String middleName, double salary) {
            if (checkFreeSpace()) {
                int free = findFreeSpace();
                employees[free] = new Employee(department[deptNumber - 1], secondName, firstName, middleName, salary);
            }  else {
                System.out.println("EMPLOYEE BOOK IS FULL");
            }
        }
        public void createNewEmployee(Department[] departments) {
            if (checkFreeSpace()) {
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
            }  else {
                System.out.println("EMPLOYEE BOOK IS FULL");
            }
        }
    }

}
