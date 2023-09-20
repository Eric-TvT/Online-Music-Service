package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.ConsumerMapper;
import com.example.onlinemusicservice.model.domain.Consumer;
import com.example.onlinemusicservice.model.request.ConsumerRequest;
import com.example.onlinemusicservice.service.ConsumerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;

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

    /**
     * 用户注册
     * @param addConsumerRequest
     * @return
     */
    @Override
    public R addUser(ConsumerRequest addConsumerRequest) {
        //注册逻辑
        //1.判断前端请求的数据中必填字段不能为空
        String username = addConsumerRequest.getUsername();
        String password = addConsumerRequest.getPassword();
        Byte sex = addConsumerRequest.getSex();
        Date birth = addConsumerRequest.getBirth();

        if(StringUtils.isBlank(username) || StringUtils.isBlank(password) || sex ==null || birth ==null){
            return R.error("请检查数据");
        }
        //2.检验不能存在重复用户名
        QueryWrapper<Consumer> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("username",username);
        if(consumerMapper.selectCount(queryWrapper) >0 ){
            return R.error("用户名重复");
        }
        //3.将前端请求的数据转换为数据库consumer对应的实体字段
        Consumer consumer = new Consumer();
        BeanUtils.copyProperties(addConsumerRequest, consumer);
        //设置默认头像
        consumer.setAvator("img/avatorImages/user.jpg");
        //插入的时间为当前系统时间
        consumer.setCreateTime(new Date());
        consumer.setUpdateTime(new Date());
        // 4.插入到数据库中
        if (consumerMapper.insert(consumer) > 0) {
            return R.success("注册成功");
        } else {
            return R.error("注册失败");
        }
    }

    /**
     * 用户个人信息更新为实现
     * @param updateConsumerRequest
     * @return
     */
    @Override
    public R updateUser(ConsumerRequest updateConsumerRequest) {
        Consumer consumer = new Consumer();
        BeanUtils.copyProperties(updateConsumerRequest, consumer);
        int i =consumerMapper.updateById(consumer);
        if ( i > 0) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }


    }


}




