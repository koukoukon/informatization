package me.hibiki.domain;

import java.io.Serializable;
import lombok.Data;

@Data
public class Apply implements Serializable {
    private Long applyId;

    private String applyTitle;

    private String applyComment;

    private Long userPid;

    private String applyDate;

    private String applyEndDate;

    private String approveComment;

    private Long approveUserPid;

    private Integer applyStatus;

    private static final long serialVersionUID = 1L;
}