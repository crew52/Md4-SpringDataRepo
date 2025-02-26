package codegym.c10.testuser.controller;

import codegym.c10.testuser.model.Employee;
import codegym.c10.testuser.service.IEmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/emp")
public class EmController {
    @Autowired
    private IEmService service;

    @GetMapping
    public ModelAndView listEmployees(@PageableDefault(size = 3) Pageable pageable) {
        Page<Employee> employees = service.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("employees", employees);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView create() {
        return new ModelAndView("/create", "employee", new Employee());
    }

    @PostMapping("/save")
    public String save(Employee employee) {
        service.save(employee);
        return "redirect:/emp";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView update(@PathVariable Long id) {
        return new ModelAndView("/update", "employee", service.findById(id));
    }

    @PostMapping("/update")
    public String update(Employee employee) {
        service.save(employee);
        return "redirect:/emp";
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        return new ModelAndView("/delete", "employee", service.findById(id));
    }

    @PostMapping("/delete")
    public String delete(Employee employee, RedirectAttributes redirect) {
        service.remove(employee.getId());
        redirect.addFlashAttribute("success", "Removed emp successfully!");
        return "redirect:/emp";
    }

    @GetMapping("/{id}/view")
    public ModelAndView view(@PathVariable Long id) {
        Optional<Employee> employee = service.findById(id);
        ModelAndView modelAndView = new ModelAndView("/view");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }
}
