package pro.sky.skyprospringexception;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Override
    public List<Employee> getAllEmployees(){
        return employeeList;
    }

    @Override
    public void addEmployee ( String firstName, String lastName) {
        Employee newEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.size(); i++) {
            if (newEmployee.equals(employeeList.get(i))){
                throw new EmployeeAlreadyExists();
            }
        }
        employeeList.add(newEmployee);
        System.out.println("Сотрудник " + newEmployee.getEmployeeFirstName() + " "
                + newEmployee.getEmployeeLastName() + " добавлен");
    }

    @Override
    public void removeEmployee ( String firstName, String lastName) {
        Employee oldEmployee = new Employee(firstName, lastName);
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if(oldEmployee.equals(employeeList.get(i))){
                found = true;
                employeeList.remove(i);
                System.out.println("Сотрудник " + oldEmployee.getEmployeeFirstName() + " "
                        + oldEmployee.getEmployeeLastName() + " удален");
            }
        }
        if (!found){
            throw new EmployeeNotFound();
        }
    }

    @Override
    public void findEmployee ( String firstName, String lastName ) {
        Employee requestedEmployee = new Employee(firstName, lastName);
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (requestedEmployee.equals(employeeList.get(i))) {
                found = true;
                System.out.println("Сотрудник " + requestedEmployee.getEmployeeFirstName() + " "
                        + requestedEmployee.getEmployeeLastName() + " найден под номером в списке:" + i);
            }
        }
        if(!found){
            throw new EmployeeNotFound();
        }
    }
}
