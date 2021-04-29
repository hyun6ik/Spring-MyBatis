package com.example.mybatis_exercise.company;

import com.example.mybatis_exercise.employee.Employee;
import com.example.mybatis_exercise.mapper.CompanyMapper;
import com.example.mybatis_exercise.mapper.EmployeeMapper;
import com.example.mybatis_exercise.response.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyMapper companyMapper;
    private final EmployeeMapper employeeMapper;

    public List<Company> findAll() {
        List<Company> companyList = companyMapper.findAll();
        if (companyList != null && companyList.size() > 0) {
            for (Company company : companyList) {
                company.setEmployeeList(employeeMapper.getByCompanyId(company.getId()));
            }
        }
        return companyList;
    }
}
