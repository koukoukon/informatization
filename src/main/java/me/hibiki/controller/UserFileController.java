package me.hibiki.controller;

import com.github.pagehelper.PageInfo;
import me.hibiki.domain.User;
import me.hibiki.domain.UserFile;
import me.hibiki.domain.UserFileExtend;
import me.hibiki.domain.UserFileJson;
import me.hibiki.service.UserFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author 高弘昆
 * @date 2020/5/12 16:17
 */
@Controller
@RequestMapping(path = "/admin/file")
public class UserFileController {
    @Resource
    private UserFileService userFileService;

    @GetMapping(path = "view")
    public String viewHtml() {
        return "forward:/WEB-INF/view/admin/file/fileView.html";
    }

    @GetMapping(path = "add")
    public String addHtml() {
        return "forward:/WEB-INF/view/admin/file/fileForm.html";
    }

    @GetMapping(path = "manage")
    public String manageHtml() {
        return "forward:/WEB-INF/view/admin/file/fileManage.html";
    }

    @GetMapping
    @ResponseBody
    public UserFileJson listUserFileExtends(int pageNum) {
        PageInfo<UserFileExtend> pageInfo = userFileService.listUserFileExtends(pageNum, 5);
        UserFileJson userFileJson = new UserFileJson();
        userFileJson.setUserFiles(pageInfo.getList());
        userFileJson.setPages(pageInfo.getPages());
        System.out.println(userFileJson);
        return userFileJson;
    }

    @GetMapping(path = "/myFile")
    @ResponseBody
    public UserFileJson listByUserPidUserFileExtends(int pageNum, @SessionAttribute("user") User user) {
        PageInfo<UserFileExtend> pageInfo = userFileService.listByUserPidUserFileExtends(user.getUserId(), pageNum, 5);
        UserFileJson userFileJson = new UserFileJson();
        userFileJson.setUserFiles(pageInfo.getList());
        userFileJson.setPages(pageInfo.getPages());
        return userFileJson;
    }

    @PostMapping
    public String uploadFile(HttpServletRequest request, String userFileTitle, String userFileComment, MultipartFile file,@SessionAttribute("user") User user) throws IOException {
        String realPath = request.getServletContext().getRealPath("/userFiles");
        File file1 = new File(realPath);
        if (!file1.exists()) {
            file1.mkdirs();
        }
        String userFileName = file.getOriginalFilename();
        file.transferTo(new File(realPath, userFileName));

        UserFile userFile = new UserFile();
        userFile.setUserFileName(userFileName);
        userFile.setUserFileTitle(userFileTitle);
        userFile.setUserFileComment(userFileComment);
        userFile.setUserFileDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        userFile.setUserPid(user.getUserId());
        userFileService.insertSelective(userFile);
        return "redirect:view";
    }
}
