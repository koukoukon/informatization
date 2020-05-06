package me.hibiki.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/5/1 1:35
 */
@Data
public class DepartmentJson {
    private List<Department> departments;
    private int pages;
}
