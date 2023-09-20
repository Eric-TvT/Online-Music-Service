package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Consumer;
import com.example.onlinemusicservice.model.request.ConsumerRequest;

import javax.servlet.http.HttpSession;

/**
 * admin-用户管理（service层接口）
 */
public interface ConsumerService extends IService<Consumer> {
    /**
     * 管理界面调用：返回所有用户进行分页管理接口
     * @param page
     * @return
     */
    public R allUser(IPage page);


    /**
     * 通过id删除单个用户接口
     * @param id
     * @return
     */
    public R deleteUser(Integer id);

    /**
     * 批量删除用户接口
     * @param ids
     * @return
     */
    public R deleteUsers(String[] ids);

    /**
     * 歌单id用户评论
     * @param id
     * @return
     */

    public R userDetail(int id);

    /**
     * 首页用户用户模型显示
     * @return
     */
    public R allUser();

    /**
     * 用户登入
     * @param consumerRequest
     * @param session
     * @return
     */
    public R  loginStatus(ConsumerRequest consumerRequest, HttpSession session);

    /**
     * 用户注册
     * @param addConsumerRequest
     * @return
     */
    R addUser(ConsumerRequest addConsumerRequest);

}



