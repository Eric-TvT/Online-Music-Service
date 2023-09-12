package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.AdminRequest;
import com.example.onlinemusicservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * admin管理员控制类
 */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    /**
     * 管理员登入
     * @param adminRequest
     * @param session
     * @return
     */
    // 判断是否登录成功
    @PostMapping("/admin/login/status")
    public R loginStatus(@RequestBody AdminRequest adminRequest, HttpSession session) {
        //调用服务层的校验密码业务
        R result = adminService.verityPasswd(adminRequest, session);
        return result;
    }
}
