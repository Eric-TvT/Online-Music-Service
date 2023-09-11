package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.ConsumerMapper;
import com.example.onlinemusicservice.model.domain.Consumer;
import com.example.onlinemusicservice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * admin -用户管理接口实现类
 */
@Service
public class ConsumerServiceImpl extends ServiceImpl<ConsumerMapper, Consumer> implements ConsumerService {
    @Autowired
    private ConsumerMapper consumerMapper;
    /**
     * 查询所有用户信息的实现方法
     * @return R.success
     */
    @Override
    public R allUser() {
        List<Consumer> consumerList = consumerMapper.selectList(null);
        return R.success("查询成功",consumerList);
    }
    /**
     *批量删除用户数据（根据id）
     */
    @GetMapping("/user/delete")
    public R deleteUser(@RequestParam Integer id){
        int cid = consumerMapper.deleteById(id);
        if (cid >0){
            return R.success("删除成功",deleteUser(id));
        }
        return R.error("删除失败");
    }


}