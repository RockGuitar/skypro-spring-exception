package pro.sky.skyprospringexception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EmployeeService {
    Map<String, Employee> employeeMap = new HashMap<>();

    void addEmployee ( String firstName, String lastName);

    void removeEmployee ( String firstName, String lastName);

    void findEmployee ( String firstName, String lastName);

    Map<String, Employee> getEmployeeMap();
}
