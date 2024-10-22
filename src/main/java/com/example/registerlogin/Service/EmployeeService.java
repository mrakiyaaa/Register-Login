package com.example.registerlogin.Service;

import com.example.registerlogin.Dto.EmployeeDTO;
import com.example.registerlogin.Dto.LoginDTO;
import com.example.registerlogin.response.LoginResponse;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDTO loginDTO);
}
