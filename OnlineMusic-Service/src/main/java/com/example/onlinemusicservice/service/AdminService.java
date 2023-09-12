package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Admin;
import com.example.onlinemusicservice.model.request.AdminRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin管理登入（service层）
 */
public interface AdminService extends IService<Admin> {
    /**
     * admin登入接口
     * @param adminRequest
     * @param session
     * @return
     */
    R verityPasswd(AdminRequest adminRequest, HttpSession session);
}

