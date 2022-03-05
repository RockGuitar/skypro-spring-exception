package pro.sky.skyprospringexception;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    List<Employee> employeeList = new ArrayList<>();

    void addEmployee ( String firstName, String lastName);

    void removeEmployee ( String firstName, String lastName);

    void findEmployee ( String firstName, String lastName);

    List<Employee> getAllEmployees();
}
