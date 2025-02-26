package codegym.c10.testuser.service;

import codegym.c10.testuser.model.Employee;
import codegym.c10.testuser.repository.EmpCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpCrudService implements IEmService{
    @Autowired
    private EmpCRUD repository;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    public void save(Employee employee) {
            repository.save(employee);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void remove(Long id) {
        repository.deleteById(id);
    }
}
