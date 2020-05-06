package me.hibiki.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Department implements Serializable {
    private Long departmentId;

    private String departmentName;

    private String departmentComment;

    private String departmentNum;

    private Integer departmentDeleteFlag;

    private static final long serialVersionUID = 1L;
}