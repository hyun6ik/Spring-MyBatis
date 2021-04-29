package com.example.mybatis_exercise.company;

import com.example.mybatis_exercise.mapper.CompanyMapper;
import com.example.mybatis_exercise.response.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyMapper companyMapper;

    @PostMapping("")
    public Result<Company> post(@RequestBody Company company){
       companyMapper.insert(company);
       return new Result(company);
    }

    @GetMapping("")
    public Result<List<Company>> findAll(){
        List<Company> result = companyMapper.findAll();
        return new Result(result);
    }

    @GetMapping("/{id}")
    public Result<Company> findById(@PathVariable("id") int id){
        Company result = companyMapper.findById(id);
        return new Result(result);
    }
}
