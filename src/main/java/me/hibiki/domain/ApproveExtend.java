package me.hibiki.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author 高弘昆
 * @date 2020/5/11 11:26
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ApproveExtend extends Approve{
    private User user;
}
