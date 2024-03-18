import java.util.Scanner;

public class Main {
    public static class Department {
        public String deptName;
        public Department(String deptName) {
            this.deptName = deptName;
        }
    }
    public static void main(String[] args) {
        Department[] department = new Department[5]; // объявление массива оюъектов "Отдел"
        department[0] = new Department("1");
        department[1] = new Department("2");
        department[2] = new Department("3");
        department[3] = new Department("4");
        department[4] = new Department("5");
        Employee[] employee = new Employee[10]; // объявление массива оюъектов "Сотрудник"
        // заполнение массива
        employee[0] = new Employee();
        employee[0].setFirstName("Михаил");
        employee[0].setMiddleName("Иванович");
        employee[0].setSecondName("Глинка");
        employee[0].setDept(department[0].deptName);
        employee[0].setSalary(30000);
        employee[1] = new Employee();
        employee[1].setFirstName("Модест");
        employee[1].setMiddleName("Петрович");
        employee[1].setSecondName("Мусоргский");
        employee[1].setDept(department[1].deptName);
        employee[1].setSalary(40000);
        employee[2] = new Employee();
        employee[2].setFirstName("Сергей");
        employee[2].setMiddleName("Васильевич");
        employee[2].setSecondName("Рахманинов");
        employee[2].setDept(department[2].deptName);
        employee[2].setSalary(35000);
        employee[3] = new Employee();
        employee[3].setFirstName("Петр");
        employee[3].setMiddleName("Ильич");
        employee[3].setSecondName("Чайковский");
        employee[3].setDept(department[3].deptName);
        employee[3].setSalary(37000);
        employee[4] = new Employee();
        employee[4].setFirstName("Александр");
        employee[4].setMiddleName("Порфирьевич");
        employee[4].setSecondName("Бородин");
        employee[4].setDept(department[4].deptName);
        employee[4].setSalary(45000);
        employee[5] = new Employee();
        employee[5].setFirstName("Николай");
        employee[5].setMiddleName("Андреевич");
        employee[5].setSecondName("Римский-Корсаков");
        employee[5].setDept(department[0].deptName);
        employee[5].setSalary(27000);
        employee[6] = new Employee();
        employee[6].setFirstName("Александр");
        employee[6].setMiddleName("Николаевич");
        employee[6].setSecondName("Скрябин");
        employee[6].setDept(department[1].deptName);
        employee[6].setSalary(31000);
        employee[7] = new Employee();
        employee[7].setFirstName("Дмитрий");
        employee[7].setMiddleName("Дмитриевич");
        employee[7].setSecondName("Шостакович");
        employee[7].setDept(department[2].deptName);
        employee[7].setSalary(28000);
        employee[9] = new Employee();
        employee[9].setFirstName("Сергей");
        employee[9].setMiddleName("Сергеевич");
        employee[9].setSecondName("Прокофьев");
        employee[9].setDept(department[3].deptName);
        employee[9].setSalary(32000);
        employee[8] = new Employee();
        employee[8].setFirstName("Игорь");
        employee[8].setMiddleName("Федорович");
        employee[8].setSecondName("Стравинский");
        employee[8].setDept(department[4].deptName);
        employee[8].setSalary(39000);
        // работа с массивом сотрудников
        Scanner scan = new Scanner(System.in);
        if (employee != null) {
            System.out.println("Добро пожаловать, бухгалтер");
            System.out.println("Для работы со всеми сотрудниками введите '0'");
            System.out.println("Для работы с отделом введите '1'");
            int command = scan.nextInt();
            if (command == 0) {
                printEmployeeList(employee);
                System.out.println("Список доступных действий:");
                System.out.println("1 - Распечатать полную информацию по сотрудникам");
                System.out.println("2 - Вывести сумму зарплат");
                System.out.println("3 - Вывести сотрудника с минимальной зарплатой");
                System.out.println("4 - Вывести сотрудника с максимальной зарплатой");
                System.out.println("5 - Вывести среднее значение зарплат");
                System.out.println("6 - Произвести индексирование на процент");
                System.out.println("7 - Сверить зарплату сотрудников с определенным числом");
                command = scan.nextInt();
                switch (command) {
                    case 1:
                        printAllInfo(employee);
                        break;
                    case 2:
                        System.out.println("Общая зарплата сотрудников за месяц: " + calculateTotalSalary(employee));
                        break;
                    case 3:
                        System.out.println("Сотрудник с наименьшей зарплатой: ");
                        printInfo(findMinSalary(employee));
                        break;
                    case 4:
                        System.out.println("Сотрудник с наибольшей зарплатой: ");
                        printInfo(findMaxSalary(employee));
                        break;
                    case 5:
                        System.out.println("Среднее значение зарплат: " + calculateAverageSalary(employee));
                        break;
                    case 6:
                        System.out.println(" Индексирование зарплаты, нужно ввести процент");
                        int index = scan.nextInt();
                        calculateIndexedSalary(employee, index);
                        printAllInfo(employee);
                        break;
                    case 7:
                        System.out.println(" Нужно ввести зарплату для проверки");
                        double salary = scan.nextDouble();
                        printSalaryComparisonMore(employee, salary);
                        printSalaryComparisonLess(employee, salary);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + command);
                }
            } else if (command == 1) {
                System.out.println("Нужно ввести отдел");
                String dept = scan.nextLine();
                if (scan.hasNextLine()){
                    dept = scan.nextLine();
                }
                System.out.println("Список доступных действий:");
                System.out.println("1 - Распечатать полную информацию по сотрудникам");
                System.out.println("2 - Вывести сумму зарплат");
                System.out.println("3 - Вывести сотрудника с минимальной зарплатой");
                System.out.println("4 - Вывести сотрудника с максимальной зарплатой");
                System.out.println("5 - Вывести среднее значение зарплат");
                command = scan.nextInt();
                switch (command) {
                    case 1:
                        printInfo(employee, dept);
                        break;
                    case 2:
                        System.out.println("Общая зарплата сотрудников отдела " + dept + " за месяц: " +
                                calculateTotalSalary(employee, dept));
                        break;
                    case 3:
                        System.out.println("Сотрудник " + dept + " с наименьшей зарплатой: ");
                        printInfo(findMinSalary(employee, dept));
                        break;
                    case 4:
                        System.out.println("Сотрудник " + dept + " с наибольшей зарплатой: ");
                        printInfo(findMaxSalary(employee, dept));
                        break;
                    case 5:
                        System.out.println("Среднее значение зарплат отдела " + dept + ": " +
                                calculateAverageSalary(employee, dept));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + command);
                }
            } else {
                throw new IllegalStateException("Unexpected value: " + command);
            }
        } else {
            throw new IllegalStateException("IS NULL");
        }
    }
    // распечатка полной инофрмации в списке сотрудников
    public static void printAllInfo(Employee[] employeeList) {
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null) {
                printInfo(employeeList[i]);
            }
        }
    }
    // расчет суммы всех зарплат
    public static double calculateTotalSalary(Employee[] employeeList) {
        double totalSalary = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null) {
                totalSalary += employeeList[i].getSalary();
            }
        }
        return  totalSalary;
    }
    // нахождение сотрудника с минимальной зарплатой
    public static Employee findMinSalary(Employee[] employeeList) {
        int minSalaryEmployee = 0;
        double minimalSalary = (double) Integer.MAX_VALUE;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() < minimalSalary) {
                minimalSalary = employeeList[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        return employeeList[minSalaryEmployee];
    }
    // нахождение сотрудника с максимальной зарплатой
    public static Employee findMaxSalary(Employee[] employeeList) {
        double maximalSalary = 0;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() > maximalSalary) {
                maximalSalary = employeeList[i].getSalary();
                maxSalaryEmployee = i;
            }
        }
        return employeeList[maxSalaryEmployee];
    }
    // расчет среднего арифметического зарплат всех сотрудников
    public static double calculateAverageSalary(Employee[] employeeList) {
        return calculateTotalSalary(employeeList) / employeeList.length;
    }
    // распечатать список сотрудников
    public static void printEmployeeList(Employee[] employeeList) {
        System.out.println("СОтрудники предприятия:");
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null) {
                System.out.println(employeeList[i].getName());
            }
        }
    }
    public static double indexing(double salary, int index){
        salary+= salary * index / 100;
        return salary;
    }
    // индексирование зарплат
    public static void calculateIndexedSalary(Employee[] employeeList, int index) {
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null) {
                double indexedSalary = indexing(employeeList[i].getSalary(), index);
                employeeList[i].setSalary(indexedSalary);
            }
        }
    }
    // информация по одному сотруднику отдела
    public static void printInfo(Employee[] employeeList, String dept) {
        System.out.println("Сотрудники отдела " + dept + ":");
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && dept.equals(employeeList[i].getDept())) {
                System.out.print("Номер сотрудника: " + employeeList[i].getID());
                System.out.print("/ ");
                System.out.print(employeeList[i].getName());
                System.out.print("/ ");
                System.out.print("Зарплата: " + employeeList[i].getSalary() + " рублей");
                System.out.println();
            }
        }
    }
    // информация по одному сотруднику
    public static void printInfo(Employee employee) {
        System.out.print("Номер сотрудника: " + employee.getID());
        System.out.print("/ ");
        System.out.print(employee.getDept() + "-й отдел");
        System.out.print("/ ");
        System.out.print(employee.getName());
        System.out.print("/ ");
        System.out.print("Зарплата: " + employee.getSalary() + " рублей");
        System.out.println();
    }
    // расчет суммы зарплат одного отдела
    public static double calculateTotalSalary(Employee[] employeeList, String dept) {
        double totalSalary = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && dept.equals(employeeList[i].getDept())) {
                totalSalary += employeeList[i].getSalary();
            }
        }
        return  totalSalary;
    }
    // расчет среднего арифметического зарплат всех сотрудников отдела
    public static double calculateAverageSalary(Employee[] employeeList, String dept) {
        int deptEmployeeCount = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && dept.equals(employeeList[i].getDept())) {
                deptEmployeeCount++;
            }
        }
        if (deptEmployeeCount == 0) {
            return 0;
        } else {
            return calculateTotalSalary(employeeList, dept) / deptEmployeeCount;
        }
    }
    // нахождение сотрудника отдела с минимальной зарплатой
    public static Employee findMinSalary(Employee[] employeeList, String dept) {
        int minSalaryEmployee = 0;
        double minimalSalary = (double) Integer.MAX_VALUE;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() < minimalSalary && dept.equals(employeeList[i].getDept())) {
                minimalSalary = employeeList[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        return employeeList[minSalaryEmployee];
    }
    // нахождение сотрудника с максимальной зарплатой
    public static Employee findMaxSalary(Employee[] employeeList, String dept) {
        double maximalSalary = 0;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() > maximalSalary && dept.equals(employeeList[i].getDept())) {
                maximalSalary = employeeList[i].getSalary();
                maxSalaryEmployee = i;
            }
        }
        return employeeList[maxSalaryEmployee];
    }
    public static void printSalaryComparisonLess(Employee[] employeeList, double salary) {
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() < salary) {
                System.out.println("Зарплата сотрудника " + employeeList[i].getName() + " меньше чем " + salary);
            }
        }
    }
    public static void printSalaryComparisonMore(Employee[] employeeList, double salary) {
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() > salary) {
                System.out.println("Зарплата сотрудника " + employeeList[i].getName() + " больше чем " + salary);
            }
        }
    }
}
