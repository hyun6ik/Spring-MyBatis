package com.example.mybatis_exercise.employee;

import com.example.mybatis_exercise.company.Company;
import com.example.mybatis_exercise.mapper.EmployeeMapper;
import com.example.mybatis_exercise.response.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    @PostMapping("")
    public Result<Company> post(@RequestBody Employee employee){
        employeeMapper.insert(employee);
        return new Result(employee);
    }

    @GetMapping("")
    public Result<List<Company>> findAll(){
        List<Company> result = employeeMapper.findAll();
        return new Result(result);
    }

    @GetMapping("/{id}")
    public Result<Company> findById(@PathVariable("id") int id){
        Company result = employeeMapper.findById(id);
        return new Result(result);
    }
}
