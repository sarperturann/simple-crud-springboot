package com.assignment.simplecrud.records;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> updateRecord(@RequestBody EmployeeRecord employeeRecord) {
        EmployeeRecord existingRecord = service.getEmployeeRecordById(employeeRecord.getId());
        if (existingRecord != null) {
            service.updateEmployeeRecord(employeeRecord);
            return ResponseEntity.ok("Record updated successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("Employee record with ID %d not found", employeeRecord.getId()));
        }
    }

    @PostMapping("/deleteRecord")
    public ResponseEntity<String> deleteRecord(@RequestParam int id) {
        EmployeeRecord existingRecord = service.getEmployeeRecordById((long) id);
        if (existingRecord != null) {
            service.deleteEmployeeRecord((long) id);
            return ResponseEntity.ok("Record deleted successfully");
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("Employee record with ID %d not found", id));
        }
    }
    @GetMapping("/readRecord")
    public ResponseEntity<?> readRecord(@RequestParam int id) {
        EmployeeRecord employeeRecord = service.getEmployeeRecordById((long) id);
        if (employeeRecord != null) {
            return ResponseEntity.ok(employeeRecord);
        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(String.format("Employee record with ID %d not found", id));        }
    }

    @PostMapping("/addRecord")
    public ResponseEntity<EmployeeRecord> addRecord(@RequestBody EmployeeRecord employeeRecord) {
        EmployeeRecord savedEmployeeRecord = service.createEmployeeRecord(employeeRecord);
        return ResponseEntity.ok(savedEmployeeRecord);
    }

}