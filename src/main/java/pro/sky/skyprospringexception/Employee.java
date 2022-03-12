package pro.sky.skyprospringexception;

import java.util.Objects;

public class Employee {
    private String employeeFirstName;
    private String employeeLastName;

    public Employee ( String employeeFirstName, String employeeLastName ) {
        this.employeeFirstName = employeeFirstName;
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeFirstName () {
        return employeeFirstName;
    }
    public void setEmployeeFirstName ( String employeeFirstName ) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeLastName () {
        return employeeLastName;
    }
    public void setEmployeeLastName ( String employeeLastName ) {
        this.employeeLastName = employeeLastName;
    }

    @Override
    public boolean equals ( Object o ) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return employeeFirstName.equals(employee.employeeFirstName) && employeeLastName.equals(employee.employeeLastName);
    }

    @Override
    public int hashCode () {
        return Objects.hash(employeeFirstName, employeeLastName);
    }
}
