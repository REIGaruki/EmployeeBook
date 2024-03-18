import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Employee[] employee = new Employee[10]; // объявление массива оюъектов "Сотрудник"
        // заполнение массива
        employee[0] = new Employee();
        employee[0].setFirstName("Иван");
        employee[0].setMiddleName("Иванович");
        employee[0].setSecondName("Иванов");
        employee[0].setDept(1);
        employee[0].setSalary(30000);
        employee[1] = new Employee();
        employee[1].setFirstName("Петр");
        employee[1].setMiddleName("Петрович");
        employee[1].setSecondName("Петров");
        employee[1].setDept(2);
        employee[1].setSalary(40000);
        employee[2] = new Employee();
        employee[2].setFirstName("Сидор");
        employee[2].setMiddleName("Сидорович");
        employee[2].setSecondName("Сидоров");
        employee[2].setDept(3);
        employee[2].setSalary(35000);
        employee[3] = new Employee();
        employee[3].setFirstName("Елена");
        employee[3].setMiddleName("Николаевна");
        employee[3].setSecondName("Посадова");
        employee[3].setDept(4);
        employee[3].setSalary(37000);
        employee[4] = new Employee();
        employee[4].setFirstName("Анастасия");
        employee[4].setMiddleName("Дмитриевна");
        employee[4].setSecondName("Дмитриева");
        employee[4].setDept(5);
        employee[4].setSalary(45000);
        employee[5] = new Employee();
        employee[5].setFirstName("Мария");
        employee[5].setMiddleName("Леонидовна");
        employee[5].setSecondName("Павлова");
        employee[5].setDept(1);
        employee[5].setSalary(27000);
        employee[6] = new Employee();
        employee[6].setFirstName("Тимур");
        employee[6].setMiddleName("Николаевич");
        employee[6].setSecondName("Надзоров");
        employee[6].setDept("2");
        employee[6].setSalary(31000);
        employee[7] = new Employee();
        employee[7].setFirstName("Ирина");
        employee[7].setMiddleName("Максимовна");
        employee[7].setSecondName("Швец");
        employee[7].setDept(3);
        employee[7].setSalary(28000);
        employee[9] = new Employee();
        employee[9].setFirstName("Екатерина");
        employee[9].setMiddleName("Владимировна");
        employee[9].setSecondName("Володина");
        employee[9].setDept(5);
        employee[9].setSalary(32000);
        employee[8] = new Employee();
        employee[8].setFirstName("Алена");
        employee[8].setMiddleName("Викторовна");
        employee[8].setSecondName("Евклидова");
        employee[8].setDept("4");
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
                        printMinSalary(employee);
                        break;
                    case 4:
                        printMaxSalary(employee);
                        break;
                    case 5:
                        System.out.println("Среднее значение зарплат: " + calculateAverageSalary(employee));
                        break;
                    case 6:
                        System.out.println(" Индексирование зарплаты, нужно ввести процент");
                        int index = scan.nextInt();
                        printIndexedSalary(employee, index);
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
                        printMinSalary(employee, dept);
                        break;
                    case 4:
                        printMaxSalary(employee, dept);
                        break;
                    case 5:
                        printAverageSalary(employee, dept);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + command);
                }
            }
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
    public static void printMinSalary(Employee[] employeeList) {
        int minSalaryEmployee = 0;
        double minimalSalary = (double) Integer.MAX_VALUE;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() < minimalSalary) {
                minimalSalary = employeeList[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        System.out.println(employeeList[minSalaryEmployee].getName() + " - сотрудник с наименьшей зарплатой: "
                + employeeList[minSalaryEmployee].getSalary());
    }
    // нахождение сотрудника с максимальной зарплатой
    public static void printMaxSalary(Employee[] employeeList) {
        double maximalSalary = 0;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() > maximalSalary) {
                maximalSalary = employeeList[i].getSalary();
                maxSalaryEmployee = i;
            }
        }
        System.out.println(employeeList[maxSalaryEmployee].getName() + " - сотрудник с наибольшей зарплатой: "
                + employeeList[maxSalaryEmployee].getSalary());
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
    public static void printIndexedSalary(Employee[] employeeList, int index) {
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null) {
                double indexedSalary = indexing(employeeList[i].getSalary(), index);
                employeeList[i].setSalary(indexedSalary);
                System.out.println("Номер сотрудника: " + employeeList[i].getID());
                System.out.println("Зарплата проидексированная на " + index + "% равна " + employeeList[i].getSalary());
            }
        }
    }
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
    public static void printAverageSalary(Employee[] employeeList, String dept) {
        int deptEmployeeCount = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && dept.equals(employeeList[i].getDept())) {
                deptEmployeeCount++;
            }
        }
        if (deptEmployeeCount == 0) {
            System.out.println("В отделе никто не работает");
        } else {
            double averageSalary = calculateTotalSalary(employeeList, dept) / deptEmployeeCount;
            System.out.println("Среднее значение зарплат отдела " + dept + ": " + averageSalary);
        }
    }
    // нахождение сотрудника отдела с минимальной зарплатой
    public static void printMinSalary(Employee[] employeeList, String dept) {
        int minSalaryEmployee = 0;
        double minimalSalary = (double) Integer.MAX_VALUE;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() < minimalSalary && dept.equals(employeeList[i].getDept())) {
                minimalSalary = employeeList[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        System.out.println(employeeList[minSalaryEmployee].getName() + " - сотрудник отдела " + dept + " с наименьшей зарплатой: "
                + employeeList[minSalaryEmployee].getSalary());
    }
    // нахождение сотрудника с максимальной зарплатой
    public static void printMaxSalary(Employee[] employeeList, String dept) {
        double maximalSalary = 0;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < employeeList.length; i++) {
            if (employeeList[i] != null && employeeList[i].getSalary() > maximalSalary && dept.equals(employeeList[i].getDept())) {
                maximalSalary = employeeList[i].getSalary();
                maxSalaryEmployee = i;
            }
        }
        System.out.println(employeeList[maxSalaryEmployee].getName() + " - сотрудник отдела " + dept + " с наибольшей зарплатой: "
                + employeeList[maxSalaryEmployee].getSalary());
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
