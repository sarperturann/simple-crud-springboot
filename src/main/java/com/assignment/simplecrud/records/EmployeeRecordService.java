package com.assignment.simplecrud.records;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeRecordService {
    @Autowired
    EmployeeRecordRepository employeeRecordRepository;

    public EmployeeRecord createEmployeeRecord(EmployeeRecord employeeRecord) {
        return employeeRecordRepository.save(employeeRecord);
    }

    public EmployeeRecord getEmployeeRecordById(Long employeeRecordId) {
        return employeeRecordRepository.findById(employeeRecordId).orElse(null);
    }

    public void deleteEmployeeRecord(Long employeeRecordId) {
        employeeRecordRepository.deleteById(employeeRecordId);
    }

    public void updateEmployeeRecord(EmployeeRecord employeeRecord) {
        employeeRecordRepository.save(employeeRecord);
    }
}
