package net.codejava.Controller;

import net.codejava.Model.Department;
import net.codejava.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @RequestMapping("/department")
    public String viewDepartmentPage(Model model) {
        List<Department> listDep = service.listAll();
        model.addAttribute("listDep",listDep);
        return "department";
    }
}
