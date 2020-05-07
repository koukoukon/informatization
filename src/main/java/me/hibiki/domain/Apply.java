package me.hibiki.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class Apply implements Serializable {
    private Long applyId;

    private String applyTitle;

    private String applyComment;

    private Long applyUserPid;

    private String applyDate;

    private String applyEndDate;

    private String approveComment;

    private Long approveUserPid;

    private Integer applyStatus;

    private static final long serialVersionUID = 1L;
}