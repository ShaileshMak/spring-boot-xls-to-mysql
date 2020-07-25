# spring-boot-xls-to-mysql
Spring Boot application reading XLS file and loading data to mySQL

- Test REST Api using following endpoint
```
http://localhost:8081/api/v1/export
```
  - SAMPLE  xls data
  
  Sample xlsx file is available at resources/static/sample_employee.xlsx
  
FirstName | LastName | Age | City | State | Country | Department
  
Sam	| Mike | 23 | Plano | TX | USA | CCD
--- | --- | --- | --- | --- | --- | ---
John | Michael | 32 | Edison | NJ | USA | CDC
Lee | Cooper | 33 | Reston | VA | USA | LOC
Rana| Sanga | 32 | Jodhpur | RJ | IND | CCB
  
```
Request
    - URL : http://localhost:8081/api/v1/export
    - RequestType : form-data
        - file: XXXX.xlsx
```

```
Response
    - Status 200
    - Data Exported Successfully
```