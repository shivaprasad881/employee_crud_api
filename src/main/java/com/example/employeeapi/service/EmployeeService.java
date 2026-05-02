package com.example.employeeapi.service;
import java.util.Map;
import com.example.employeeapi.entity.Employee;
import com.example.employeeapi.exception.ResourceNotFoundException;
import com.example.employeeapi.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existingEmployee = getEmployeeById(id);
        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setDepartment(updatedEmployee.getDepartment());
        return employeeRepository.save(existingEmployee);
    }

    public Employee patchEmployee(Long id, Map<String, Object> updates) {
        Employee existingEmployee = getEmployeeById(id);
        
        updates.forEach((key, value) -> {
            switch (key) {
                case "name":           // ✅ Matches your entity
                    existingEmployee.setName((String) value);
                    break;
                case "email":          // ✅ Matches your entity
                    existingEmployee.setEmail((String) value);
                    break;
                case "department":     // ✅ Matches your entity
                    existingEmployee.setDepartment((String) value);
                    break;
                default:
                    throw new RuntimeException("Invalid field: " + key + ". Allowed fields: name, email, department");
            }
        });
        
        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id) {
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
