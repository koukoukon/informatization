package me.hibiki.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserFile implements Serializable {
    private Long userFileId;

    private String userFileName;

    private String userFileTitle;

    private String userFileComment;

    private String userFileDate;

    private Long userPid;

    private Integer userFileDeleteFlag;

    private static final long serialVersionUID = 1L;
}