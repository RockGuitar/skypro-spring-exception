package pro.sky.skyprospringexception;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private int size;

    public int getSize () {
        return size;
    }

    @Override
    public void addEmployee ( String firstName, String lastName ) {
        if (size >= employeeList.length) {
            throw new EmployeeArrayIsFull();
        }
        Employee newEmployee = new Employee(firstName, lastName);
        for (int i = 0; i < employeeList.length; i++) {
            if (newEmployee.equals(employeeList[i])){
                throw new EmployeeAlreadyExists();
            }
        }
        employeeList[size++] = newEmployee;
        System.out.println("Сотрудник " + newEmployee.getEmployeeFirstName() + " "
                + newEmployee.getEmployeeLastName() + " добавлен");
    }

    @Override
    public void removeEmployee ( String firstName, String lastName ) {
        Employee oldEmployee = new Employee(firstName, lastName);
        boolean found = false;
        for (int i = 0; i < employeeList.length; i++) {
            if(oldEmployee.equals(employeeList[i])){
                found = true;
                employeeList[i] = null;
                if (i != employeeList.length - 1) {
                    System.arraycopy(employeeList, i + 1, employeeList, i, size - i);
                }
                size--;
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
        for (int i = 0; i < employeeList.length; i++) {
            if (requestedEmployee.equals(employeeList[i])) {
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
