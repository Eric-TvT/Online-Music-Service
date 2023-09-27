package com.example.onlinemusicservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.onlinemusicservice.common.JwtUtils;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.common.Result;
import com.example.onlinemusicservice.model.domain.Consumer;
import com.example.onlinemusicservice.model.request.ConsumerRequest;
import com.example.onlinemusicservice.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;

/**
 * admin-用户管理控制类（controller层）
 */
@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    /**
     * 管理界面调用：返回所有用户进行分页管理
     * @param curPage 当前页
     * @param pageSize 页的大小
     * @return
     */
    @GetMapping("/user")
    public R allUser(@RequestParam(defaultValue = "1") int curPage, @RequestParam(defaultValue = "1") int pageSize) {
        //分
        IPage<Consumer> page = new Page<>();
        //设置当前页
        page.setCurrent(curPage);
        //设置每页显示数据条数
        page.setSize(pageSize);
        return consumerService.allUser(page);
    }

    /**
     * 删除用户（根据id删除）
     */
    @GetMapping("/user/delete")
    public R deleteUser(@RequestParam int id) {
        return consumerService.deleteUser(id);
    }

    /**
     * 批量删除多个用户
     *
     * @param id
     * @return
     */
    @DeleteMapping("user/deleteIds")
    public R deleteUsers(@RequestParam String[] id) {
        return consumerService.deleteUsers(id);
    }

    /**
     * 根据id查询用户(评论)
     * @param id
     * @return
     */
    // http://localhost:8888/user/detail?id=1
    @GetMapping("/user/detail")
    public R userDetail(@RequestParam int id){
        return consumerService.userDetail(id);
    }




    /**
     * 首页模块查询用户数据
     * @return
     */
    @GetMapping("/users")
    public R allUser(){
        return consumerService.allUser();
    }


    /**
     * TODO 前台页面调用 用户登录
     * 登录判断
     * @param consumerRequest
     * @param session
     */

    @PostMapping("/user/login/status")
    public R loginStatus(@RequestBody ConsumerRequest consumerRequest, HttpSession session) {
        // 调用服务层的校验密码业务
                R result = consumerService.loginStatus(consumerRequest, session);
                if (result.getSuccess()) {
                    String tokenStr = JwtUtils.generateToken(consumerRequest.getUsername());
                    Result token = new Result();
                    token.setAuthorization(tokenStr);
                    token.setObj(result.getData());
                    result.setData(token);
                }
                return result;


//        R result = consumerService.loginStatus(consumerRequest, session);
//        Map<String,Object> map = new HashMap<>();
//        map.put("res",result.getData());
//        //登录成功的话，返回中需要包含token信息
//        if(result.getSuccess()){
//            String tokenStr = JwtUtils.generateToken(consumerRequest.getUsername());
//            Token token = new Token();
//            token.setAuthorization(tokenStr);
//            map.put("token",token);
//        }
//        result.setData(map);
//        return result;

    }

    /**
     * TODO 用户注册
     * @param consumerRequest
     * @return
     */
    @PostMapping("/user/add")
    public R addUser(@RequestBody ConsumerRequest consumerRequest){
        return consumerService.addUser(consumerRequest);
    }


    /**
     * TODO 前后台界面的调用
     * 更新用户个人资料实现
     * @param updateConsumerRequest
     * @return
     */
    @PostMapping("/user/update")
    public R updateUserMsg(@RequestBody ConsumerRequest updateConsumerRequest) {
        return consumerService.updateUser(updateConsumerRequest);
    }

    /**
     * 用户个人密码更新
     * @param consumerRequest
     * @return
     */
    @PostMapping("/user/updatePassword")
    public R updateUserPassword(@RequestBody ConsumerRequest consumerRequest){
        return consumerService.updateUserPassword(consumerRequest);
    }

    /**
     * 用户个人图片更新
     * @param urlFile
     * @param id
     * @return
     */
    @PostMapping("/user/avatar/update")
    public R updateUserPic(@RequestParam("file") MultipartFile urlFile, @RequestParam("id") int id){
        return consumerService.updateUserPic(urlFile,id);
    }
}
