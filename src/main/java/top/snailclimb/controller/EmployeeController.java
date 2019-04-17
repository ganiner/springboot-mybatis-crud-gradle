package top.snailclimb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.snailclimb.bean.Employee;
import top.snailclimb.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/all")
    public List<Employee> selectAllEmployee() {
        return employeeService.selectAllEmployee();
    }

    //测试URL：http://localhost:8080/employees/insert?name=SnailClimb&age=23&gender=男
    @RequestMapping("/insert")
    public List<Employee> insertEmployee(@RequestParam(value = "name", defaultValue = "SnailClimb") String name,
                                         @RequestParam(value = "age") int age,
                                         @RequestParam(value = "gender") String gender) {
        employeeService.insertEmployee(name, age, gender);
        return employeeService.selectAllEmployee();
    }

    //测试URL：http://localhost:8080/employees/delete?id=6
    @RequestMapping("/delete")
    public List<Employee> deleteEmployeeById(@RequestParam(value = "id") int id) {
        employeeService.deleteEmployeeById(id);
        return employeeService.selectAllEmployee();
    }

    @RequestMapping("/update")
    public List<Employee> updateEmployeeById(@RequestParam(value = "name", defaultValue = "SnailClimb") String name,
                                             @RequestParam(value = "age") int age,
                                             @RequestParam(value = "gender") String gender,
                                             @RequestParam(value = "id") int id) {
        employeeService.updateEmployeeById(name, age, gender, id);
        return employeeService.selectAllEmployee();
    }

}
