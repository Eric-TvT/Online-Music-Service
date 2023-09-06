package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Admin;
import com.example.onlinemusicservice.model.request.AdminRequest;

import javax.servlet.http.HttpSession;

/**
 * Admin接口类
 */
public interface AdminService extends IService<Admin> {
    R verityPasswd(AdminRequest adminRequest, HttpSession session);
}

