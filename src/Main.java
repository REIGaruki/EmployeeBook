public class Main {
    public static void main(String[] args) {
        Employee[] Employee = new Employee[10];
        Employee[0] = new Employee();
        Employee[0].setFirstName("Иван");
        Employee[0].setMiddleName("Иванович");
        Employee[0].setSecondName("Иванов");
        Employee[0].setDept(1);
        Employee[0].setSalary(30000);
        Employee[1] = new Employee();
        Employee[1].setFirstName("Петр");
        Employee[1].setMiddleName("Петрович");
        Employee[1].setSecondName("Петров");
        Employee[1].setDept(2);
        Employee[1].setSalary(40000);
        Employee[2] = new Employee();
        Employee[2].setFirstName("Сидор");
        Employee[2].setMiddleName("Сидорович");
        Employee[2].setSecondName("Сидоров");
        Employee[2].setDept(3);
        Employee[2].setSalary(35000);
        Employee[3] = new Employee();
        Employee[3].setFirstName("Елена");
        Employee[3].setMiddleName("Николаевна");
        Employee[3].setSecondName("Посадова");
        Employee[3].setDept(4);
        Employee[3].setSalary(37000);
        Employee[4] = new Employee();
        Employee[4].setFirstName("Анастасия");
        Employee[4].setMiddleName("Дмитриевна");
        Employee[4].setSecondName("Дмитриева");
        Employee[4].setDept(5);
        Employee[4].setSalary(45000);
        Employee[5] = new Employee();
        Employee[5].setFirstName("Мария");
        Employee[5].setMiddleName("Леонидовна");
        Employee[5].setSecondName("Павлова");
        Employee[5].setDept(1);
        Employee[5].setSalary(27000);
        Employee[6] = new Employee();
        Employee[6].setFirstName("Тимур");
        Employee[6].setMiddleName("Николаевич");
        Employee[6].setSecondName("Надзоров");
        Employee[6].setDept("2");
        Employee[6].setSalary(31000);
        Employee[7] = new Employee();
        Employee[7].setFirstName("Ирина");
        Employee[7].setMiddleName("Максимовна");
        Employee[7].setSecondName("Швец");
        Employee[7].setDept(3);
        Employee[7].setSalary(28000);
        Employee[8] = new Employee();
        Employee[8].setFirstName("Алена");
        Employee[8].setMiddleName("Викторовна");
        Employee[8].setSecondName("Евклидова");
        Employee[8].setDept("4");
        Employee[8].setSalary(39000);
        Employee[9] = new Employee();
        Employee[9].setFirstName("Екатерина");
        Employee[9].setMiddleName("Владимировна");
        Employee[9].setSecondName("Володина");
        Employee[9].setDept(5);
        Employee[9].setSalary(32000);
        double totalSalary = 0;
        double minimalSalary = (double) Integer.MAX_VALUE;
        int minSalaryEmployee = 0;
        double maximalSalary = 0;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < Main.Employee.counter; i++) {
            System.out.print("Номер сотрудника: " + Employee[i].getID());
            System.out.print("/ ");
            System.out.print(Employee[i].getDept() + "-й отдел");
            System.out.print("/ ");
            System.out.print(Employee[i].getName());
            System.out.print("/ ");
            System.out.print("Зарплата: " + Employee[i].getSalary() + " рублей");
            System.out.println();
            totalSalary+= Employee[i].getSalary();
            if (Employee[i].getSalary() > maximalSalary) {
                maximalSalary = Employee[i].getSalary();
                maxSalaryEmployee = i;
            }
            if (Employee[i].getSalary() < minimalSalary) {
                minimalSalary = Employee[i].getSalary();
                minSalaryEmployee = i;
            }
        }
        System.out.println("Общая зарплата сотрудников за месяц: " + totalSalary);
        System.out.println(Employee[minSalaryEmployee].getName() + " - сотрудник с наименьшей зарплатой: "
                + Employee[minSalaryEmployee].getSalary());
        System.out.println(Employee[maxSalaryEmployee].getName() + " - сотрудник с наибольшей зарплатой: "
                + Employee[maxSalaryEmployee].getSalary());
        System.out.println("Среднее значение зарплат: " + totalSalary / Main.Employee.counter);
        for (int i = 0; i < Main.Employee.counter; i++) {
            System.out.println(Employee[i].getName());
        }
        int index = 7;
        for (int i = 0; i < Main.Employee.counter; i++) {
            System.out.println("Номер сотрудника: " + Employee[i].getID());
            System.out.println("Зарплата проидексированная на " + index + "% равна " + Employee[i].indexSalary(index));
        }
        String dept = "2";
        totalSalary = 0;
        minimalSalary = (double) Integer.MAX_VALUE;
        minSalaryEmployee = 0;
        maximalSalary = 0;
        maxSalaryEmployee = 0;
        int deptCount = 0;
        System.out.println("Сотрудники отдела " + dept + ":");
        for (int i = 0; i < Main.Employee.counter; i++) {
            if (dept.equals(Employee[i].getDept())) {
                System.out.print("Номер сотрудника: " + Employee[i].getID());
                System.out.print("/ ");
                System.out.print(Employee[i].getName());
                System.out.print("/ ");
                System.out.print("Зарплата: " + Employee[i].getSalary() + " рублей");
                System.out.println();
                deptCount++;
                totalSalary+= Employee[i].getSalary();
                if (Employee[i].getSalary() > maximalSalary) {
                    maximalSalary = Employee[i].getSalary();
                    maxSalaryEmployee = i;
                }
                if (Employee[i].getSalary() < minimalSalary) {
                    minimalSalary = Employee[i].getSalary();
                    minSalaryEmployee = i;
                }
            }
        }
        System.out.println("Общая зарплата сотрудников отдела " + dept + " за месяц: " + totalSalary);
        System.out.println(Employee[minSalaryEmployee].getName() + " - сотрудник отдела " + dept + " с наименьшей зарплатой: "
                + Employee[minSalaryEmployee].getSalary());
        System.out.println(Employee[maxSalaryEmployee].getName() + " - сотрудник отдела " + dept + " с наибольшей зарплатой: "
                + Employee[maxSalaryEmployee].getSalary());
        System.out.println("Среднее значение зарплат отдела " + dept + ": " + totalSalary / deptCount);
        double salary = 33000;
        for (int i = 0; i < Main.Employee.counter; i++) {
            if (Employee[i].getSalary() >= salary) {
                System.out.println("Зарплата сотрудника " + Employee[i].getName() + " меньше чем " + salary);
            }
        }
        for (int i = 0; i < Main.Employee.counter; i++) {
            if (Employee[i].getSalary() < salary) {
                System.out.println("Зарплата сотрудника " + Employee[i].getName() + " равна/больше чем " + salary);
            }
        }
    }

    public static class Employee {
        private int id;
        static int counter;
        static {
            counter = 0;
        }
        String dept;
        String firstName;
        String middleName;
        String secondName;
        double salary;

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
        public double indexSalary(int index){
            this.salary+= this.salary * index / 100;
            return this.salary;
        }
    }
}
