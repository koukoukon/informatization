package me.hibiki.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Approve implements Serializable {
    private Long approveId;

    private Long applyPid;

    private Long userPid;

    private String approveComment;

    private Date approveDate;

    private Integer approveStatus;

    private static final long serialVersionUID = 1L;
}