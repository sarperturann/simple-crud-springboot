package com.assignment.simplecrud.records;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping("/api")
public class EmployeeRecordController {

    @Autowired
    private EmployeeRecordService service;

    @PostMapping("/createRecord")
    public ResponseEntity<List<EmployeeRecord>> createRecord(@RequestBody byte[] spreadsheet) {
        List<EmployeeRecord> createdRecords = new ArrayList<>();

        try {
            byte[] decoded = Base64.getDecoder().decode(spreadsheet);
            InputStream inputStream = new ByteArrayInputStream(decoded);
            Workbook workbook = WorkbookFactory.create(inputStream, "xlsx");

            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();

            if (rowIterator.hasNext()) {
                rowIterator.next();
            }

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                String name = row.getCell(0).getStringCellValue();
                String surname = row.getCell(1).getStringCellValue();
                int age = (int) row.getCell(2).getNumericCellValue();
                int salary = (int) row.getCell(3).getNumericCellValue();
                int workYears = (int) row.getCell(4).getNumericCellValue();
                String title = row.getCell(5).getStringCellValue();

                EmployeeRecord employeeRecord = new EmployeeRecord();
                employeeRecord.setName(name);
                employeeRecord.setSurname(surname);
                employeeRecord.setAge(age);
                employeeRecord.setSalary(salary);
                employeeRecord.setWorkYears(String.valueOf(workYears));
                employeeRecord.setTitle(title);

                EmployeeRecord savedRecord = service.createEmployeeRecord(employeeRecord);
                createdRecords.add(savedRecord);
            }

            return ResponseEntity.ok(createdRecords);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
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