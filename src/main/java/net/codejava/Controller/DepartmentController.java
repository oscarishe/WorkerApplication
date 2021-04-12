package net.codejava.Controller;

import net.codejava.Model.Department;
import net.codejava.Model.Worker;
import net.codejava.Service.DepartmentService;
import net.codejava.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @Autowired
    private WorkerService workerService;
    @RequestMapping("/department")
    public String viewDepartmentPage(Model model) {
        List<Department> listDep = service.listAll();
        List<Worker> listWorker = workerService.listAll();
        for(int i=0;i<listDep.size();i++) {
            int count = 0;
            for(int j=0;j<listWorker.size();j++) {
                if(listWorker.get(j).getDepartmentId()==listDep.get(i).getId())
                    count++;
            }
            listDep.get(i).setCount(count);
        }
        model.addAttribute("listDep",listDep);
        return "department";
    }
    @RequestMapping("/new_department")
    public String showNewDepartmentForm(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);

        return "new_department";
    }
    @RequestMapping(value = "/saveDepartment", method = RequestMethod.POST)
    public String saveDepartment(@ModelAttribute("department") Department department) {
        service.save(department);
        return "redirect:department";
    }

    @RequestMapping("/delete_department/{id}")
    public String deleteDepartment(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return "redirect:/department";
    }
    @RequestMapping("/edit_department/{id}")
    public ModelAndView showEditDepartmentForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("edit_department");
        Department department = service.get(id);
        mav.addObject("department", department);
        return mav;
    }
    @RequestMapping("/department_page/{id}")
    public ModelAndView showDepartmentProfile(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("department_page");
        List <Worker> listWorker = workerService.findByDepartmentId(id);
        mav.addObject("listWorker",listWorker);
        return mav;
    }
}
