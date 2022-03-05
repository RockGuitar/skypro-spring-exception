package pro.sky.skyprospringexception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class Controller {
    private final EmployeeService employeeService;

    public Controller ( EmployeeService employeeService ) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee( @RequestParam String firstName,
                                 @RequestParam String lastName ){
        Employee employee = new Employee(firstName, lastName);
        employeeService.addEmployee(firstName,lastName);
        return employee;
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String firstName,
                                 @RequestParam String lastName){
        Employee employee = new Employee(firstName, lastName);
        employeeService.findEmployee(firstName,lastName);
        return employee;
    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName,
                                   @RequestParam String lastName) {

        Employee employee = new Employee(firstName, lastName);
        employeeService.removeEmployee(firstName,lastName);
        return employee;
    }
    @GetMapping("/info")
    public List<Employee> employeeInformation(){
        return employeeService.getAllEmployees();
    }
}
