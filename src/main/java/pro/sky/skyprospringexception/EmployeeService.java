package pro.sky.skyprospringexception;

public interface EmployeeService {
    Employee[] employeeList = new Employee[2];
    void addEmployee(String firstName, String lastName);
    void removeEmployee(String firstName, String lastName);
    void findEmployee(String firstName, String lastName);
}
