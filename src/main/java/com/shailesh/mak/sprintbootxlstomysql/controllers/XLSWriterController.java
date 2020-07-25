package com.shailesh.mak.sprintbootxlstomysql.controllers;

import com.shailesh.mak.sprintbootxlstomysql.services.XLSWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class XLSWriterController {

    @Autowired
    XLSWriterService xlsWriterService;

    @PostMapping("/export")
    public ResponseEntity<String> export(@RequestParam MultipartFile file) throws IOException {
        try {
            final Boolean isSuccessFull = xlsWriterService.export(file);
            if(isSuccessFull) {
                return new ResponseEntity<String>("Data Exported Successfully", HttpStatus.OK);
            }
            return new ResponseEntity<String>("Failed to export EXLS", HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (IOException e) {
            System.out.println(e);
            return new ResponseEntity<String>("Failed to export EXLS", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
