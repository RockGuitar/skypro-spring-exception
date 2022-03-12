package pro.sky.skyprospringexception;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    public Map<String, Employee> getEmployeeMap(){
        return employeeMap;
    }

    @Override
    public void removeEmployee ( String firstName, String lastName) {
        Employee oldEmployee = new Employee(firstName, lastName);
        String oldEmployeeFullName = firstName + " " + lastName;
        boolean found = false;
        if(employeeMap.containsKey(oldEmployeeFullName)){
            found = true;
            employeeMap.remove(oldEmployeeFullName);
            System.out.println("Сотрудник " + oldEmployeeFullName + " удален");
        }
        if (!found){
            throw new EmployeeNotFound();
        }
    }
    @Override
    public void findEmployee ( String firstName, String lastName ) {
        String requestedEmployeeFullName = firstName + " " + lastName;
        boolean found = false;
        if (employeeMap.containsKey(requestedEmployeeFullName)) {
            found = true;
            System.out.println("Сотрудник " + requestedEmployeeFullName + " находится в базе данных");
        }
        if(!found){
            throw new EmployeeNotFound();
        }
    }

    public void addEmployee(String firstName, String lastName){
        Employee newEmployee = new Employee(firstName, lastName);
        String newEmployeeFullName = firstName + " " + lastName;
        if(employeeMap.containsKey(newEmployeeFullName)){
            throw new EmployeeAlreadyExists();
        }else{
            employeeMap.put(newEmployeeFullName,newEmployee);
            System.out.println("Сотрудник " + newEmployee.getEmployeeFirstName() + " "
                    + newEmployee.getEmployeeLastName() + " добавлен");
        }
    }

}
