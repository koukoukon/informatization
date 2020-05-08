package me.hibiki.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.Apply;
import me.hibiki.domain.ApplyExtend;
import me.hibiki.domain.ApplyJson;
import me.hibiki.domain.User;
import me.hibiki.service.ApplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/5/7 10:40
 */
@Controller
@RequestMapping(path = "/admin/apply")
public class ApplyController {
    @Resource
    private ApplyService applyService;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addHtml() {
        return "forward:/WEB-INF/view/admin/apply/applyForm.html";
    }

    @RequestMapping(path = "/manage", method = RequestMethod.GET)
    public String manageHtml() {
        return "forward:/WEB-INF/view/admin/apply/applyManage.html";
    }


    @PostMapping
    @ResponseBody
    public Map<String, Integer> addApply(Apply apply, @SessionAttribute(name = "user") User user) {        System.out.println(apply);
        //获取当前当登录用户的id
        System.out.println("用户为:"+user);
        apply.setUserPid(user.getUserId());
        //需要申请人id 标题 备注 申请时间 状态
        apply.setApplyDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        apply.setApplyStatus(0);
        int i = applyService.insertSelective(apply);
        HashMap<String, Integer> map = new HashMap<>(1);
        map.put("success", i);
        return map;
    }
    @GetMapping
    @ResponseBody
    public ApplyJson listDepartmentsByPagination(int pageNum){
        PageInfo<ApplyExtend> pageInfo = applyService.listApplyForApprove(pageNum, 5);
        ApplyJson applyJson = new ApplyJson();
        applyJson.setApplys(pageInfo.getList());
        applyJson.setPages(pageInfo.getPages());
        return applyJson;
    }
    @GetMapping(path = "/{applyId}")
    @ResponseBody
    public ApplyExtend getApplyExtendById(@PathVariable Long applyId){
        System.out.println(applyId);
        return applyService.getApplyExtendById(applyId);
    }

}
