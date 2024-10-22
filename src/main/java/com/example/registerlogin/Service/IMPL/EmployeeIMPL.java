package com.example.registerlogin.Service.IMPL;

import com.example.registerlogin.Dto.EmployeeDTO;
import com.example.registerlogin.Dto.LoginDTO;
import com.example.registerlogin.Entity.Employee;
import com.example.registerlogin.Repo.EmployeeRepo;
import com.example.registerlogin.Service.EmployeeService;
import com.example.registerlogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(

                employeeDTO.getEmployeeId(),
                employeeDTO.getEmployeeName(),
                employeeDTO.getEmail(),

                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);
//        return employee.getEmployeeName();
        return "Registered Successfully";
    }

    @Override
    public LoginResponse loginEmployee(LoginDTO loginDTO) {
        Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());

        if (employee != null) {
            // Get the stored encoded password from the database
            String encodedPassword = employee.getPassword();
            // Check if the provided raw password matches the stored encoded password
            boolean isPwdRight = passwordEncoder.matches(loginDTO.getPassword(), encodedPassword);

            if (isPwdRight) {
                return new LoginResponse("Login Success", true);
            } else {
                return new LoginResponse("Password Not Match", false);
            }
        } else {
            return new LoginResponse("Email not exists", false);
        }
    }

}
