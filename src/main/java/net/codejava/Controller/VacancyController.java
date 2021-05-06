package net.codejava.Controller;

import net.codejava.Model.Department;
import net.codejava.Model.Vacancy;
import net.codejava.Service.DepartmentService;
import net.codejava.Service.VacancyService;
import net.codejava.Service.VacationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class VacancyController {
    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/vacancies")
    public String getVacancies(Model model) {
        List<Vacancy> vacancyList = vacancyService.listAllActive();
        List<Vacancy> archiveList = vacancyService.listAllArchive();
        List<Department> departmentList = departmentService.listAll();
        model.addAttribute("vacancyList",vacancyList);
        model.addAttribute("archiveList",archiveList);
        model.addAttribute("departmentList",departmentList);
        return "vacancies";
    }
    @RequestMapping("/delete_vacancy/{id}")
    public String deleteVacancy(@PathVariable(name = "id") Long id) {
        vacancyService.delete(id);
        return "redirect:/vacancies";
    }

    @RequestMapping("/archive_vacancy/{id}")
    public String archiveVacancy(@PathVariable(name = "id") Long id) {
        Vacancy vacancy = vacancyService.get(id);
        vacancy.setStatus(0);
        vacancyService.save(vacancy);
        return "redirect:/vacancies";
    }
}
