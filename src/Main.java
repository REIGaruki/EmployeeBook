import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Department[] department = new Department[5]; // объявление массива объектов "Отдел"
        department[0] = new Department("1");
        department[1] = new Department("2");
        department[2] = new Department("3");
        department[3] = new Department("4");
        department[4] = new Department("5");
        Employee[] employee = new Employee[11]; // объявление массива объектов "Сотрудник"
        EmployeeBook employeeBook = new EmployeeBook(employee);
        // заполнение массива
        employeeBook.employee[0] = new Employee();
        employeeBook.employee[0].setFirstName("Михаил");
        employeeBook.employee[0].setMiddleName("Иванович");
        employeeBook.employee[0].setSecondName("Глинка");
        employeeBook.employee[0].setDept(department[0].getDeptName());
        employeeBook.employee[0].setSalary(30000);
        employeeBook.employee[1] = new Employee();
        employeeBook.employee[1].setFirstName("Модест");
        employeeBook.employee[1].setMiddleName("Петрович");
        employeeBook.employee[1].setSecondName("Мусоргский");
        employeeBook.employee[1].setDept(department[1].getDeptName());
        employeeBook.employee[1].setSalary(40000);
        employeeBook.employee[2] = new Employee();
        employeeBook.employee[2].setFirstName("Сергей");
        employeeBook.employee[2].setMiddleName("Васильевич");
        employeeBook.employee[2].setSecondName("Рахманинов");
        employeeBook.employee[2].setDept(department[2].getDeptName());
        employeeBook.employee[2].setSalary(35000);
        employeeBook.employee[3] = new Employee();
        employeeBook.employee[3].setFirstName("Петр");
        employeeBook.employee[3].setMiddleName("Ильич");
        employeeBook.employee[3].setSecondName("Чайковский");
        employeeBook.employee[3].setDept(department[3].getDeptName());
        employeeBook.employee[3].setSalary(37000);
        employeeBook.employee[4] = new Employee();
        employeeBook.employee[4].setFirstName("Александр");
        employeeBook.employee[4].setMiddleName("Порфирьевич");
        employeeBook.employee[4].setSecondName("Бородин");
        employeeBook.employee[4].setDept(department[4].getDeptName());
        employeeBook.employee[4].setSalary(45000);
        employeeBook.employee[5] = new Employee();
        employeeBook.employee[5].setFirstName("Николай");
        employeeBook.employee[5].setMiddleName("Андреевич");
        employeeBook.employee[5].setSecondName("Римский-Корсаков");
        employeeBook.employee[5].setDept(department[0].getDeptName());
        employeeBook.employee[5].setSalary(27000);
        employeeBook.employee[6] = new Employee();
        employeeBook.employee[6].setFirstName("Александр");
        employeeBook.employee[6].setMiddleName("Николаевич");
        employeeBook.employee[6].setSecondName("Скрябин");
        employeeBook.employee[6].setDept(department[1].getDeptName());
        employeeBook.employee[6].setSalary(31000);
        employeeBook.employee[7] = new Employee();
        employeeBook.employee[7].setFirstName("Дмитрий");
        employeeBook.employee[7].setMiddleName("Дмитриевич");
        employeeBook.employee[7].setSecondName("Шостакович");
        employeeBook.employee[7].setDept(department[2].getDeptName());
        employeeBook.employee[7].setSalary(28000);
        employeeBook.employee[9] = new Employee();
        employeeBook.employee[9].setFirstName("Сергей");
        employeeBook.employee[9].setMiddleName("Сергеевич");
        employeeBook.employee[9].setSecondName("Прокофьев");
        employeeBook.employee[9].setDept(department[3].getDeptName());
        employeeBook.employee[9].setSalary(32000);
        employeeBook.employee[8] = new Employee();
        employeeBook.employee[8].setFirstName("Игорь");
        employeeBook.employee[8].setMiddleName("Федорович");
        employeeBook.employee[8].setSecondName("Стравинский");
        employeeBook.employee[8].setDept(department[4].getDeptName());
        employeeBook.employee[8].setSalary(39000);
        // работа с массивом сотрудников
        Scanner scan = new Scanner(System.in);
        if (employeeBook.employee != null) {
            System.out.println("Добро пожаловать, бухгалтер");
            System.out.println("Для работы со всеми сотрудниками введите '0'");
            System.out.println("Для работы с отделом введите '1'");
            int command;
            command = scan.nextInt();
            if (command == 0) {
                employeeBook.printEmployeeList(employee);
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
                        employeeBook.printAllInfo(employeeBook.employee);
                        break;
                    case 2:
                        System.out.println("Общая зарплата сотрудников за месяц: " +
                                employeeBook.calculateTotalSalary(employeeBook.employee));
                        break;
                    case 3:
                        System.out.println("Сотрудник с наименьшей зарплатой: ");
                        employeeBook.printInfo(employeeBook.findMinSalary(employeeBook.employee));
                        break;
                    case 4:
                        System.out.println("Сотрудник с наибольшей зарплатой: ");
                        employeeBook.printInfo(employeeBook.findMaxSalary(employeeBook.employee));
                        break;
                    case 5:
                        System.out.println("Среднее значение зарплат: " +
                                employeeBook.calculateAverageSalary(employeeBook.employee));
                        break;
                    case 6:
                        System.out.println(" Индексирование зарплаты, нужно ввести процент");
                        int index = scan.nextInt();
                        employeeBook.calculateIndexedSalary(employeeBook.employee, index);
                        employeeBook.printAllInfo(employeeBook.employee);
                        break;
                    case 7:
                        System.out.println(" Нужно ввести зарплату для проверки");
                        double salary = scan.nextDouble();
                        employeeBook.printSalaryComparisonMore(employeeBook.employee, salary);
                        employeeBook.printSalaryComparisonLess(employeeBook.employee, salary);
                        break;
                    case 8:
                        System.out.println(" Веедите данные:");
                        employeeBook.createNewEmployee(employeeBook.employee, department);
                        break;
                    case 9:
                        System.out.println(" Веедите номер сотрудника которого хотите удалить:");
                        int deleteID = scan.nextInt();
                        employeeBook.deleteEmployeeByID(employeeBook.employee, deleteID);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + command);
                }
                employeeBook.printAllInfo(employeeBook.employee);
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
                        employeeBook.printInfo(employeeBook.employee, dept);
                        break;
                    case 2:
                        System.out.println("Общая зарплата сотрудников отдела " + dept + " за месяц: " +
                                employeeBook.calculateTotalSalary(employeeBook.employee, dept));
                        break;
                    case 3:
                        System.out.println("Сотрудник " + dept + " с наименьшей зарплатой: ");
                        employeeBook.printInfo(employeeBook.findMinSalary(employeeBook.employee, dept));
                        break;
                    case 4:
                        System.out.println("Сотрудник " + dept + " с наибольшей зарплатой: ");
                        employeeBook.printInfo(employeeBook.findMaxSalary(employeeBook.employee, dept));
                        break;
                    case 5:
                        System.out.println("Среднее значение зарплат отдела " + dept + ": " +
                                employeeBook.calculateAverageSalary(employeeBook.employee, dept));
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + command);
                }
                employeeBook.printAllInfo(employeeBook.employee, dept);
            } else {
                throw new IllegalStateException("Unexpected value: " + command);
            }
        } else {
            throw new IllegalStateException("IS NULL");
        }
    }
    private static class EmployeeBook {
        private final Employee[] employee;
        private EmployeeBook(Employee[] employee) {
            this.employee = employee;
        }
        // распечатка полной инофрмации в списке сотрудников
        public void printAllInfo(Employee[] employeeList) {
            for (Employee employee : employeeList) {
                if (employee != null) {
                    printInfo(employee);
                }
            }
        }
        public void printAllInfo(Employee[] employeeList, String dept) {
            for (Employee employee : employeeList) {
                if (employee != null && dept.equals(employee.getDept())) {
                    printInfo(employee);
                }
            }
        }
        // расчет суммы всех зарплат
        public double calculateTotalSalary(Employee[] employeeList) {
            double totalSalary = 0;
            for (Employee employee : employeeList) {
                if (employee != null) {
                    totalSalary += employee.getSalary();
                }
            }
            return  totalSalary;
        }
        // нахождение сотрудника с минимальной зарплатой
        public Employee findMinSalary(Employee[] employeeList) {
            int minSalaryEmployee = 0;
            double minimalSalary = Integer.MAX_VALUE;
            for (int i = 0; i < employeeList.length; i++) {
                if (employeeList[i] != null && employeeList[i].getSalary() < minimalSalary) {
                    minimalSalary = employeeList[i].getSalary();
                    minSalaryEmployee = i;
                }
            }
            return employeeList[minSalaryEmployee];
        }
        // нахождение сотрудника с максимальной зарплатой
        public Employee findMaxSalary(Employee[] employeeList) {
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
        public double calculateAverageSalary(Employee[] employeeList) {
            return calculateTotalSalary(employeeList) / employeeList.length;
        }
        // распечатать список сотрудников
        public void printEmployeeList(Employee[] employeeList) {
            System.out.println("СОтрудники предприятия:");
            for (Employee employee : employeeList) {
                if (employee != null) {
                    System.out.println(employee.getName());
                }
            }
        }
        public double indexing(double salary, int index){
            salary+= salary * index / 100;
            return salary;
        }
        // индексирование зарплат
        public void calculateIndexedSalary(Employee[] employeeList, int index) {
            for (Employee employee : employeeList) {
                if (employee != null) {
                    double indexedSalary = indexing(employee.getSalary(), index);
                    employee.setSalary(indexedSalary);
                }
            }
        }
        // информация по одному сотруднику отдела
        public void printInfo(Employee[] employeeList, String dept) {
            System.out.println("Сотрудники отдела " + dept + ":");
            for (Employee employee : employeeList) {
                if (employee != null && dept.equals(employee.getDept())) {
                    System.out.print("Номер сотрудника: " + employee.getID());
                    System.out.print("/ ");
                    System.out.print(employee.getName());
                    System.out.print("/ ");
                    System.out.print("Зарплата: " + employee.getSalary() + " рублей");
                    System.out.println();
                }
            }
        }
        // информация по одному сотруднику
        public void printInfo(Employee employee) {
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
        public double calculateTotalSalary(Employee[] employeeList, String dept) {
            double totalSalary = 0;
            for (Employee employee : employeeList) {
                if (employee != null && dept.equals(employee.getDept())) {
                    totalSalary += employee.getSalary();
                }
            }
            return  totalSalary;
        }
        // расчет среднего арифметического зарплат всех сотрудников отдела
        public double calculateAverageSalary(Employee[] employeeList, String dept) {
            int deptEmployeeCount = 0;
            for (Employee employee : employeeList) {
                if (employee != null && dept.equals(employee.getDept())) {
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
        public Employee findMinSalary(Employee[] employeeList, String dept) {
            int minSalaryEmployee = 0;
            double minimalSalary = Integer.MAX_VALUE;
            for (int i = 0; i < employeeList.length; i++) {
                if (employeeList[i] != null && employeeList[i].getSalary() < minimalSalary &&
                        dept.equals(employeeList[i].getDept())) {
                    minimalSalary = employeeList[i].getSalary();
                    minSalaryEmployee = i;
                }
            }
            return employeeList[minSalaryEmployee];
        }
        // нахождение сотрудника с максимальной зарплатой
        public Employee findMaxSalary(Employee[] employeeList, String dept) {
            double maximalSalary = 0;
            int maxSalaryEmployee = 0;
            for (int i = 0; i < employeeList.length; i++) {
                if (employeeList[i] != null && employeeList[i].getSalary() > maximalSalary &&
                        dept.equals(employeeList[i].getDept())) {
                    maximalSalary = employeeList[i].getSalary();
                    maxSalaryEmployee = i;
                }
            }
            return employeeList[maxSalaryEmployee];
        }
        public void printSalaryComparisonLess(Employee[] employeeList, double salary) {
            for (Employee employee : employeeList) {
                if (employee != null && employee.getSalary() < salary) {
                    System.out.println("Зарплата сотрудника " + employee.getName() + " меньше чем " + salary);
                }
            }
        }
        public void printSalaryComparisonMore(Employee[] employeeList, double salary) {
            for (Employee employee : employeeList) {
                if (employee != null && employee.getSalary() > salary) {
                    System.out.println("Зарплата сотрудника " + employee.getName() + " больше чем " + salary);
                }
            }
        }
        public  int getEmployeeByID(Employee[] employeeList, int number) {
            for (int i = 0; i< employeeList.length; i++) {
                if (employeeList[i].getID() == number) {
                    return i;
                }
            }
            return -1;
        }
        public boolean checkFreeSpace(Employee[] employeeList) {
            for (Employee employee : employeeList) {
                if (employee == null) {
                    return true;
                }
            }
            return false;
        }
        public int findFreeSpace(Employee[] employeeList) {
            for (int i = 0; i < employeeList.length; i++) {
                if (employeeList[i] == null) {
                    return i;
                }
            }
            return -1;
        }
        public void deleteEmployeeByID(Employee[] employeeList, int employeeID) {
            employeeList[getEmployeeByID(employeeList, employeeID)] = null;
        }
        public void createNewEmployee(Employee[] employeeList, Department[] departments) {
            if (checkFreeSpace(employeeList)) {
                Scanner scan = new Scanner(System.in);
                int free = findFreeSpace(employeeList);
                String firstName = "";
                String secondName = "";
                String middleName = "";
                System.out.println("Веедите имя");
                if (scan.hasNextLine()) {
                    firstName = scan.nextLine();
                }
                System.out.println("Веедите фамилию");
                if (scan.hasNextLine()) {
                    secondName = scan.nextLine();
                }
                System.out.println("Веедите отчество");
                if (scan.hasNextLine()) {
                    middleName = scan.nextLine();
                }
                System.out.println("Веедите номер отдела");
                int deptNumber = scan.nextInt() - 1;
                System.out.println("Веедите значение заработной платы");
                double salary = scan.nextDouble();
                employeeList[free] = new Employee();
                employeeList[free].setFirstName(firstName);
                employeeList[free].setMiddleName(middleName);
                employeeList[free].setSecondName(secondName);
                employeeList[free].setDept(departments[deptNumber].getDeptName());
                employeeList[free].setSalary(salary);
            }  else {
                System.out.println("EMPLOYEE BOOK IS FULL");
            }
        }
    }

}
