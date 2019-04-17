package top.snailclimb.dao;

import org.apache.ibatis.annotations.*;
import top.snailclimb.bean.Employee;

import java.util.List;

@Mapper
public interface EmployeeDao {

    /**
     * 查询所有用户信息
     */
    @Select("SELECT * FROM employee")
    List<Employee> findAllEmployee();

    /**
     * 插入用户信息
     */
    @Insert("INSERT INTO employee(name, age,gender) VALUES(#{name}, #{age}, #{gender})")
    void insertEmployee(@Param("name") String name, @Param("age") Integer age, @Param("gender") String gender);

    /**
     * 根据 id 删除用户信息
     */
    @Delete("DELETE from employee WHERE id = #{id}")
    void deleteEmployee(@Param("id") int id);

    /**
     * 根据 id 更新用户信息
     */
    @Update("UPDATE  employee SET name = #{name},age = #{age},gender= #{gender} WHERE id = #{id}")
    void updateEmployee(@Param("name") String name, @Param("age") Integer age, @Param("gender") String gender,
                        @Param("id") int id);

}
