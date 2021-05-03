package net.codejava.Controller;


import net.codejava.Model.Department;
import net.codejava.Service.DepartmentService;
import net.codejava.Service.FiredWorkerService;
import net.codejava.Service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StatsController {

    @Autowired
    private WorkerService workerService;
    @Autowired
    private FiredWorkerService firedService;
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/genderStats")
    public String pieChart(Model model) {
        int men = workerService.getCountByGender("Мужской");
        int woman = workerService.getCountByGender("Женский");
        model.addAttribute("men", men);
        model.addAttribute("woman", woman);
        return "genderStats";
    }
    @GetMapping("/employeeMoves")
    public String moveStats(Model model) {
        Map<String, Integer> surveyMap = new LinkedHashMap<>();
        List<Department> departmentList = departmentService.listAll();
        for(int i=0;i<departmentList.size();i++) {
            surveyMap.put(departmentList.get(i).getName(), workerService.getCountByDepartment(departmentList.get(i).getId()));
        }
        model.addAttribute("surveyMap", surveyMap);
        return "employeeMoves";

    }
    @GetMapping("/yearsStat")
    public String yearsStats(Model model) {

        Map<String, Integer> yearEmploy = new LinkedHashMap<>();
        Map<String, Integer> yearFired = new LinkedHashMap<>();
        for(int i=2010;i<=2021;i++) {
                yearFired.put(String.valueOf(i), firedService.getFiredByYear(i));
                yearEmploy.put(String.valueOf(i), workerService.getEmployByYear(i));
        }
        model.addAttribute("totalEmploy", yearEmploy.values().stream().reduce(0,Integer::sum));
        model.addAttribute("totalFired", yearFired.values().stream().reduce(0,Integer::sum));
        model.addAttribute("total", yearEmploy.values().stream().reduce(0,Integer::sum)-yearFired.values().stream().reduce(0,Integer::sum));
        model.addAttribute("yearEmploy",yearEmploy);
        model.addAttribute("yearFired",yearFired);
        return "yearsStat";
    }
}
