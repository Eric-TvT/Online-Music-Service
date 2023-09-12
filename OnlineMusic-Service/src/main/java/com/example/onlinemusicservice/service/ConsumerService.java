package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Consumer;

/**
 * admin-用户管理（Service层）
 */
public interface ConsumerService extends IService<Consumer> {
    /**
     * 管理界面调用：返回所有用户进行分页管理接口
     * @param page
     * @return
     */
    R allUser(IPage page);


    /**
     * 通过id删除单个用户接口
     * @param id
     * @return
     */
    R deleteUser(Integer id);

    /**
     * 批量删除用户接口
     * @param ids
     * @return
     */
    R deleteUsers(String[] ids);

}



