package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.AdminMapper;
import com.example.onlinemusicservice.model.domain.Admin;
import com.example.onlinemusicservice.model.request.AdminRequest;
import com.example.onlinemusicservice.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Admin 接口实现类
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public R verityPasswd(AdminRequest adminRequest, HttpSession session) {
        //具体校验账号和密码的业务
        //调用Mapper去完成基础的查询功能
        //设置查询条件：select * from admin where name='xxx' and password ='xxxx';
        QueryWrapper<Admin> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name",adminRequest.getUsername());
        queryWrapper.eq("password",adminRequest.getPassword());
        //得到查询的数量
        //第一种
        Long count = adminMapper.selectCount(queryWrapper);

        if (count > 0) {
            //登录成功
            session.setAttribute("name", adminRequest.getUsername());
            return R.success("登录成功");
        }else {
            //登录失败
            return R.error("用户名或密码错误");
        }

        //第二种
//        if (adminMapper.selectCount(queryWrapper) > 0) {
//            session.setAttribute("name", adminRequest.getUsername());
//            return R.success("登录成功");
//        } else {
//            return R.error("用户名或密码错误");
//        }

    }
}