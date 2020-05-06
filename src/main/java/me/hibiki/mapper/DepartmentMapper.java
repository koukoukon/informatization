package me.hibiki.mapper;

import me.hibiki.domain.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DepartmentMapper {
    int deleteByPrimaryKey(Long departmentId);

    int insert(Department record);

    int insertSelective(Department record);

    Department selectByPrimaryKey(Long departmentId);

    int updateByPrimaryKeySelective(Department record);

    int updateByPrimaryKey(Department record);
    List<Department> listDepartments();
    int deleteById(Long departmentId);
    int deleteByIds(String[] departmentIds);
    int countByName(String departmentName);
    int countByDepartmentNum(@Param("departmentNum") String departmentNum,@Param("departmentId") Long departmentId);
}