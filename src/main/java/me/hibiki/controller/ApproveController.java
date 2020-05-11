package me.hibiki.controller;

import me.hibiki.domain.Approve;
import me.hibiki.domain.ApproveExtend;
import me.hibiki.domain.User;
import me.hibiki.service.ApplyService;
import me.hibiki.service.ApproveService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 高弘昆
 * @date 2020/5/8 11:37
 */
@Controller
@RequestMapping(path = "/admin/approve")
public class ApproveController {
    @Resource
    private ApproveService approveService;
    @Resource
    private ApplyService applyService;

    @RequestMapping(path = "/manage", method = RequestMethod.GET)
    public String approveHtml() {
        return "forward:/WEB-INF/view/admin/approve/approveManage.html";
    }

    @RequestMapping(path = "/edit", method = RequestMethod.GET)
    public String editHtml() {
        return "forward:/WEB-INF/view/admin/approve/approveForm.html";
    }

    @PostMapping
    @ResponseBody
    public Map<String, Integer> approve(Approve approve, @SessionAttribute("user") User user) {
        approve.setUserPid(user.getUserId());
        approve.setApproveDate(new Date());
        int i = approveService.insertSelective(approve, user);
        HashMap<String, Integer> map = new HashMap<String, Integer>(1);

        map.put("success", i);
        return map;
    }

    @GetMapping
    @ResponseBody
    public List<ApproveExtend> listByApplyPidApproves(Long applyPid) {
        return approveService.listByApplyPidApproves(applyPid);
    }
}
