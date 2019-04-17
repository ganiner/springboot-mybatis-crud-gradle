package top.snailclimb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.snailclimb.bean.Employee;
import top.snailclimb.dao.EmployeeDao;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    /**
     * 查找所有Employee
     */
    public List<Employee> selectAllEmployee() {
        return employeeDao.findAllEmployee();
    }
    /**
     * 插入Employee
     */
    public void insertEmployee(String name,int age,String gender){
        employeeDao.insertEmployee(name,age,gender);
    }
    /**
     * 根据id 删除Employee
     */
    public void deleteEmployeeById(int id) {
        employeeDao.deleteEmployee(id);
    }

    /**
     * 根据id 更新Employee
     */
    public void updateEmployeeById(String name,int age,String gender,int id) {
        employeeDao.updateEmployee(name,age,gender,id);
    }
}
