package me.hibiki.service;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.Department;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/4/29 17:37
 */
public interface DepartmentService {
    PageInfo<Department> listDepartmentsByPagination(int pageNum,int pageSize);
    List<Department> listDepartments();
    int deleteById(String[] departmentIds);
    int deleteByIds(String[] departmentIds);
    int insert(Department department);
    Department getDepartmentById(Long departmentId);
    int updateDepartmentById(Department department);
    int countByDepartmentNum(String departmentNum);
}
