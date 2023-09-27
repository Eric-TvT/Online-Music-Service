package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.JwtUtils;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Token;
import com.example.onlinemusicservice.model.request.AdminRequest;
import com.example.onlinemusicservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * admin管理员控制类（controller层）
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
        if (result.getSuccess()){
            //登入成功，生成token并返回客户端
            String strToken = JwtUtils.generateToken(adminRequest.getUsername());
            Token token = new Token();
            token.setAuthorization(strToken);
            result.setData(token);
        }
        return result;
    }
}
