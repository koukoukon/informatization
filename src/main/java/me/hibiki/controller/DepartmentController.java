package me.hibiki.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.Department;
import me.hibiki.domain.DepartmentJson;
import me.hibiki.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/4/29 17:39
 */
@Controller
@RequestMapping(path = "/admin/dept")
public class DepartmentController {
    @Resource
    private DepartmentService departmentService;

    @RequestMapping(path = "/manage", method = RequestMethod.GET)
    public String manageHtml() {
        return "forward:/WEB-INF/view/admin/dept/deptManage.html";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addHtml() {
        return "forward:/WEB-INF/view/admin/dept/deptForm.html";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editHtml() {
        return "forward:/WEB-INF/view/admin/dept/deptForm.html";
    }

    @GetMapping(path = "/{departmentId}")
    @ResponseBody
    public Department getDepartmentById(@PathVariable Long departmentId) {
        return departmentService.getDepartmentById(departmentId);
    }

    @GetMapping(params = {"pageNum"})
    @ResponseBody
    public DepartmentJson listDepartmentsByPagination(int pageNum) {
        PageInfo<Department> departmentPageInfo = departmentService.listDepartmentsByPagination(pageNum, 5);
        List<Department> departments = departmentPageInfo.getList();
        int pages = departmentPageInfo.getPages();
        DepartmentJson departmentJson = new DepartmentJson();
        departmentJson.setDepartments(departments);
        departmentJson.setPages(pages);
        return departmentJson;
    }

    @GetMapping
    @ResponseBody
    public List<Department> listDepartments() {
        return departmentService.listDepartments();
    }

    @DeleteMapping
    @ResponseBody
    public Map<String, Integer> deleteDepartment(String deptIds) {
        String[] deptIdArray = deptIds.split(",");
        int i = departmentService.deleteById(deptIdArray);
        Map<String, Integer> statusMap = new HashMap<String, Integer>(1);
        statusMap.put("success", i);
        return statusMap;
    }

    @PostMapping
    @ResponseBody
    public Map<String, Integer> addDepartment(Department department) {
        department.setDepartmentDeleteFlag(0);
        int i = departmentService.insert(department);
        HashMap<String, Integer> map = new HashMap<>(1);
        map.put("success", i);
        return map;
    }

    @PutMapping
    @ResponseBody
    public Map<String, Integer> editDepartment(Department department) {
        int i = departmentService.updateDepartmentById(department);
        HashMap<String, Integer> map = new HashMap<String, Integer>(1);
        map.put("success", i);
        return map;
    }

    @GetMapping(path = "/countNum")
    @ResponseBody
    public Map<String, Integer> countDepartmentNum(String departmentNum) {
        System.out.println(departmentNum);
        int i = departmentService.countByDepartmentNum(departmentNum);
        HashMap<String, Integer> map = new HashMap<String, Integer>(1);
        map.put("success", i);
        return map;
    }
}
