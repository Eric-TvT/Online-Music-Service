package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.ConsumerMapper;
import com.example.onlinemusicservice.model.domain.Consumer;
import com.example.onlinemusicservice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * admin -用户管理接口实现类
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


}




