package codegym.c10.testuser.service;

import codegym.c10.testuser.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmService extends IGenerateService<Employee>{
    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findAllByNameContaining(Pageable pageable, String name);
}
