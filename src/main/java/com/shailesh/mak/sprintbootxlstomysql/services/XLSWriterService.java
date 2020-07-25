package com.shailesh.mak.sprintbootxlstomysql.services;

import com.shailesh.mak.sprintbootxlstomysql.model.Employee;
import com.shailesh.mak.sprintbootxlstomysql.repositories.EmployeeRepository;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class XLSWriterService {
    @Autowired
    EmployeeRepository employeeRepository;

    public Boolean export(MultipartFile file) throws IOException {
        try {
            File convFile = new File(System.getProperty("java.io.tmpdir")+"/"+ file.getName());
            file.transferTo(convFile);
            Workbook wb = WorkbookFactory.create(convFile);
            Sheet sheet = wb.getSheetAt(0);
            List<Employee> employeeList = StreamSupport.stream(sheet.spliterator(), false)
                                            .map(XLSWriterService::parsing)
                                            .map(XLSWriterService::parsing)
                                            .collect(Collectors.toList());
            employeeRepository.saveAll(employeeList);
            return Boolean.TRUE;
        } catch (IOException e) {
            System.out.println(e);
            return Boolean.FALSE;
        }
    }

    private static String parsing(Cell val) {
        String returnVal = "";
        if (val.getCellType() == CellType.NUMERIC) returnVal = Double.toString(val.getNumericCellValue());
        else if (val.getCellType() == CellType.STRING) returnVal = val.getStringCellValue();
        return returnVal;
    }

    private static Employee parsing(List<Cell> cell) {
        Employee employee = new Employee(cell.stream().map(XLSWriterService::parsing).collect(Collectors.toList()));
        return employee;
    }

    private static List<Cell> parsing(Row row) {
        return StreamSupport.stream(row.spliterator(), false).collect(Collectors.toList());
    }

}
