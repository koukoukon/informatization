package me.hibiki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import me.hibiki.domain.Department;
import me.hibiki.mapper.DepartmentMapper;
import me.hibiki.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/4/29 17:37
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public PageInfo<Department> listDepartmentsByPagination(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Department> departments = departmentMapper.listDepartments();
        return new PageInfo<Department>(departments);
    }

    @Override
    public List<Department> listDepartments() {
        return departmentMapper.listDepartments();
    }

    @Override
    public int deleteById(String[] departmentIds) {
        int i = 0;
        for (String departmentId : departmentIds) {
            i += departmentMapper.deleteById(Long.parseLong(departmentId));
        }
        return i;
    }

    @Override
    public int deleteByIds(String[] departmentIds) {
        return 0;
    }

    @Override
    public int insert(Department department) {
        int i = departmentMapper.countByName(department.getDepartmentName());
        if (i>0){
            return -1;
        }
        int j = departmentMapper.countByDepartmentNum(department.getDepartmentNum(), department.getDepartmentId());
        if (j>0){
            return -1;
        }
        return departmentMapper.insertSelective(department);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentMapper.selectByPrimaryKey(departmentId);
    }

    @Override
    public int updateDepartmentById(Department department) {
        int i = departmentMapper.countByName(department.getDepartmentName());
        if (i>0){
            return -1;
        }
        int j = departmentMapper.countByDepartmentNum(department.getDepartmentNum(), department.getDepartmentId());
        if (j>0){
            return -1;
        }
        return departmentMapper.updateByPrimaryKeySelective(department);
    }

    @Override
    public int countByDepartmentNum(String departmentNum) {
        return departmentMapper.countByDepartmentNum(departmentNum,null);
    }
}
