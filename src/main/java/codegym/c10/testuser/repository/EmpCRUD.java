package codegym.c10.testuser.repository;

import codegym.c10.testuser.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpCRUD extends CrudRepository<Employee, Long> {

}
