import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        EmployeeBook employeeBook = new EmployeeBook();
        // заполнение массива отделов
        employeeBook.addNewDepartment("Первый");
        employeeBook.addNewDepartment("Второй");
        employeeBook.addNewDepartment("Третий");
        employeeBook.addNewDepartment("Четвертый");
        employeeBook.addNewDepartment("Пятый");
        // заполнение массива сотрудников
        employeeBook.addNewEmployee(employeeBook.returnDepartment(1),
                "Глинка", "Михаил", "Иванович", 30000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(1),
                "Мусоргский", "Модест", "Петрович", 40000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(2),
                "Рахманинов", "Сергей", "Васильевич", 35000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(2),
                "Чайковский", "Петр", "Ильич", 37000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(3),
                "Бородин", "Александр", "Порфирьевич", 45000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(3),
                "Римский-Корсаков", "Николай", "Андреевич", 27000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(4),
                "Скрябин", "Александр", "Николаевич", 31000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(4),
                "Шостакович", "Дмитрий", "Дмитриевич", 28000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(5),
                "Прокофьев", "Сергей", "Сергеевич", 32000);
        employeeBook.addNewEmployee(employeeBook.returnDepartment(5),
                "Стравинский", "Игорь", "Федорович", 39000);
        // работа с массивом сотрудников
        Scanner scan = new Scanner(System.in);
        int command = 0;
        while (command >= 0) {
            System.out.println("Добро пожаловать, бухгалтер");
            System.out.println("Для работы с отделом введите его номер");
            for (int i = 1; i <= employeeBook.returnDepLength(); i++) {
                System.out.println(i + ". - " + employeeBook.returnDepartment(i));
            }
            System.out.println("Для работы со всеми сотрудниками введите '0'");
            System.out.println("Для выхода введите '-1'");
            command = scan.nextInt();
            if (command == -1) {
                System.out.println("Завершение работы.");
            } else if (command == 0) {
                employeeBook.printEmployeeList();
                System.out.println("Список доступных действий:");
                System.out.println("0 - Распечатать информацию по ID");
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
                    case 0:
                        System.out.println("Введите ID:");
                        int idNumber = scan.nextInt();
                        System.out.println(employeeBook.findByID(idNumber));
                        break;
                    case 1:
                        employeeBook.printAllInfo();
                        break;
                    case 2:
                        System.out.println("Общая зарплата сотрудников за месяц: " +
                                employeeBook.calculateTotalSalary());
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
                        employeeBook.createNewEmployee();
                        break;
                    case 9:
                        System.out.println("Веедите номер сотрудника которого хотите удалить:");
                        int deleteID = scan.nextInt();
                        employeeBook.deleteEmployeeByID(deleteID);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + workCommand);
                }
            } else if (command > 0 && command <= employeeBook.returnDepLength()) {
                System.out.println("Вы выбрали отдел №" + command + ", " +
                        employeeBook.returnDepartment(command));
                System.out.println("Список доступных действий:");
                System.out.println("1 - Распечатать полную информацию по сотрудникам");
                System.out.println("2 - Вывести сумму зарплат");
                System.out.println("3 - Вывести сотрудника с минимальной зарплатой");
                System.out.println("4 - Вывести сотрудника с максимальной зарплатой");
                System.out.println("5 - Вывести среднее значение зарплат");
                System.out.println("6 - Произвести индексирование на процент");
                int deptCommand = scan.nextInt();
                Department dept = employeeBook.returnDepartment(command);
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
                        System.out.println(employeeBook.findMinSalary(dept).toStringWithoutDepartment());
                        break;
                    case 4:
                        System.out.println("Сотрудник отдела №" + command + " с наибольшей зарплатой: ");
                        System.out.println(employeeBook.findMaxSalary(dept).toStringWithoutDepartment());
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
        System.out.println("==========================================================================");
    }
}
