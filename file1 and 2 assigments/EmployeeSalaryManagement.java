class Employee {
    protected String employeeId;
    protected String name;
    protected String department;
    protected double basicSalary;

    public Employee(String employeeId, String name, String department, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }


    public double calculateSalary() {
        return basicSalary;
    }

    public String getCategory() {
        return "Employee";
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Category: " + getCategory());
        System.out.printf("Monthly Salary: $%.2f%n", calculateSalary());
        System.out.println();
    }
}


class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(String employeeId, String name, String department,
                            double basicSalary, double allowance) {
        super(employeeId, name, department, basicSalary);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + allowance;
    }

    @Override
    public String getCategory() {
        return "Full-Time Employee";
    }
}


class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String name, String department,
                            double hoursWorked, double hourlyRate) {
        super(employeeId, name, department, 0); // no fixed basic salary
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getCategory() {
        return "Part-Time Employee";
    }
}


class Manager extends Employee {
    private double bonus;

    public Manager(String employeeId, String name, String department,
                   double basicSalary, double bonus) {
        super(employeeId, name, department, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public String getCategory() {
        return "Manager";
    }
}


public class EmployeeSalaryManagement {
    public static void main(String[] args) {

        Employee[] employees = new Employee[3];
        employees[0] = new FullTimeEmployee("EMP001", "Ahmed Ali", "Finance", 500.00, 150.00);
        employees[1] = new PartTimeEmployee("EMP002", "Fatima Hassan", "Administration", 40, 6.00);
        employees[2] = new Manager("EMP003", "Mohamed Omar", "Operations", 1000.00, 200.00);

        System.out.println("===== EMPLOYEE SALARY REPORT =====");
        System.out.println();


        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}