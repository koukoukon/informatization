package me.hibiki.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/4/29 14:26
 */
@Data
public class UserJson {
    private List<UserExtend> users;
    private Long total;
}
