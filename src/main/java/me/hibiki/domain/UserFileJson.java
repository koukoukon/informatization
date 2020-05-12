package me.hibiki.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/5/12 18:20
 */
@Data
public class UserFileJson {
    private List<UserFileExtend> userFiles;
    private int pages;
}
