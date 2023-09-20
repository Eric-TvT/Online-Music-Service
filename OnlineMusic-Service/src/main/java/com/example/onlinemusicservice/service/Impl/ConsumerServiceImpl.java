package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.ConsumerMapper;
import com.example.onlinemusicservice.model.domain.Consumer;
import com.example.onlinemusicservice.model.request.ConsumerRequest;
import com.example.onlinemusicservice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * admin -用户管理（service层接口实现类）
 */
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;

    /**
     * 查询所有用户信息进行分页实现方法
     * @param page
     * @return
     */
    @Override
    public R allUser(IPage page) {
        return R.success("查询成功",consumerMapper.selectPage(page,null));
    }

    /**
     * 删除用户
     */
    @Override
    public R deleteUser(Integer id) {
        if (consumerMapper.deleteById(id) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    /**
     * 批量删除多个用户
     */
    @Override
    public R deleteUsers(String[] ids) {
        //把数组转成字符串
        //把数组中参数组织成SQL语句需要的格式
        StringBuffer sb = new StringBuffer();
        for (String i : ids) {
            sb.append(i + ",");
        }
        //截掉最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        if (consumerMapper.deleteByIds(sb.toString()) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    /**
     * 歌单id用户评论
     * @param id
     * @return
     */
    @Override
    public R userDetail(int id) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",id);
        return R.success("查询成功",consumerMapper.selectList(queryWrapper));
    }

    /**
     * 首页用户模型显示
     * @return
     */
    @Override
    public R allUser() {
        return R.success(null, consumerMapper.selectList(null));
    }

    /**
     * 用户登入
     * @param consumerRequest
     * @param session
     * @return
     */
    @Override
    public R loginStatus(ConsumerRequest consumerRequest, HttpSession session) {
        String username = consumerRequest.getUsername();
        String password = consumerRequest.getPassword();
        QueryWrapper<Consumer> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("username",username);
        queryWrapper.eq("password",password);
        Long i =consumerMapper.selectCount(queryWrapper);
        if (i > 0) {
            //登录成功
            session.setAttribute("username",username);
            return R.success("登录成功",consumerMapper.selectList(queryWrapper));
        }else {
            //登录失败
            return R.error("用户名或密码错误");
        }

    }


}




