public class Employee {
    // Thuộc tính instance
    private int id;
    private String name;
    private double salary;

    // Thuộc tính static
    private static int employeeCount = 0;
    private static int nextId = 1000;
    public static String companyName = "TechCorp";
    private static double totalSalary = 0;

    // Constructor
    public Employee(String name, double salary) {
        this.id = nextId;
        nextId++;

        this.name = name;
        this.salary = salary;

        employeeCount++;
        totalSalary += salary;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(double salary) {
        // Trừ lương cũ khỏi totalSalary
        totalSalary -= this.salary;

        // Cập nhật lương mới
        this.salary = salary;

        // Cộng lương mới vào totalSalary
        totalSalary += this.salary;
    }

    // Phương thức tăng lương theo phần trăm
    public void raiseSalary(double percent) {
        double increase = this.salary * percent / 100;
        setSalary(this.salary + increase);
    }

    // Static methods
    public static int getEmployeeCount() {
        return employeeCount;
    }

    public static double getTotalSalary() {
        return totalSalary;
    }

    public static double getAverageSalary() {
        if (employeeCount == 0) {
            return 0;
        }
        return totalSalary / employeeCount;
    }

    // Đổi tên công ty
    public static void changeCompanyName(String newName) {
        companyName = newName;
    }
}
