package com.shailesh.mak.sprintbootxlstomysql.repositories;

import com.shailesh.mak.sprintbootxlstomysql.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
