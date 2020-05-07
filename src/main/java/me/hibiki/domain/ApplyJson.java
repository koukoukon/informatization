package me.hibiki.domain;

import lombok.Data;

import java.util.List;

/**
 * @author 高弘昆
 * @date 2020/5/7 16:04
 */
@Data
public class ApplyJson {
    public List<ApplyExtend> applys;
    public int pages;
}
