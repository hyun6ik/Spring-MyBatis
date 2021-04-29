package com.example.mybatis_exercise.mapper;

import com.example.mybatis_exercise.company.Company;
import com.example.mybatis_exercise.employee.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    @Insert("INSERT INTO employee(company_id, employee_name, employee_address) VALUES(#{employee.companyId}, #{employee.name}, #{employee.address})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(@Param("employee") Employee employee);

    @Select("SELECT * FROM employee")
    @Results(id = "EmployeeMap", value = {
            @Result(property = "name", column = "employee_name"),
            @Result(property = "address", column = "employee_address")
            @Result(property = "employeeList", column = "id", many=Many(select="com."))
    })
    List<Company> findAll();

    @Select("SELECT * FROM employee WHERE id=#{id}")
    @ResultMap("EmployeeMap")
    Company findById(@Param("id") int id);

    @Select("SELECT * FROM employee WHERE company_id=#{companyId}")
    @ResultMap("EmployeeMap")
    List<Employee> getByCompanyId(@Param("companyId") int companyId);


}
