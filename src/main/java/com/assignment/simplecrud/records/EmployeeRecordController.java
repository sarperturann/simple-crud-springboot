package com.assignment.simplecrud.records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeRecordController {

    @Autowired
    private EmployeeRecordService service;

    @PostMapping("/createRecord")
    public String createRecord() {
        return "not implemented yet";
    }

    @PostMapping("/updateRecord")
    public String updateRecord() {
        return "not implemented yet";
    }

    @PostMapping("/deleteRecord")
    public String deleteRecord(@RequestParam int id) {
        return "not implemented yet";
    }

    @GetMapping("/readRecord")
    public ResponseEntity<?> readRecord(@RequestParam int id) {
        EmployeeRecord employeeRecord = service.getEmployeeRecordById((long) id);
        if (employeeRecord != null) {
            return ResponseEntity.ok(employeeRecord);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", String.format("Employee record with ID %d not found", id)));        }
    }

    @PostMapping("/addRecord")
    public ResponseEntity<EmployeeRecord> addRecord(@RequestBody EmployeeRecord employeeRecord) {
        EmployeeRecord savedEmployeeRecord = service.createEmployeeRecord(employeeRecord);
        return ResponseEntity.ok(savedEmployeeRecord);
    }

}