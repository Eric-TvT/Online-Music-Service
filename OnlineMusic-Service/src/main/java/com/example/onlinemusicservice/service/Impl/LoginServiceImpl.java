package com.example.onlinemusicservice.service.Impl;

import com.example.onlinemusicservice.common.AliSmsUtil;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.common.RandomCodeGenerate;
import com.example.onlinemusicservice.common.RedisUtil;
import com.example.onlinemusicservice.model.request.ConsumerPhoneCodeRequest;
import com.example.onlinemusicservice.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class LoginServiceImpl implements LoginService {

    private static final String SMS_KEY_PRIFIX = "sms:code:phone:"; //定义验证码key前缀
    private static final String MAIL_KEY_PRIFIX = "mail:code:uuid:"; //定义验证码key前缀

    @Autowired
    private RedisUtil redis;

    @Override
    public R sendSmsCode(String phone) throws NoSuchAlgorithmException {
        // 向指定的电话号码发送短信
        // 生成一个随机的验证码
        Integer code = RandomCodeGenerate.createCode(4);
        // 调用阿里云提供的短信服务API方法
        int result = AliSmsUtil.sendMsgCode(phone, code + "");
        if (result != -1) {
            // 把验证码保存到redis中
            //记录验证码 有效期5分钟 使用Redis存储 数据类型 String 存储：key: sms:code:phone:手机号 value：验证码
            redis.set(SMS_KEY_PRIFIX + phone, code.toString(), 300);
        }
        return R.success("发送验证码短信成功", code);
    }




    @Override
    public R checkRCode(ConsumerPhoneCodeRequest consumerPhoneCodeRequest) {

        // 1.判断电话号码是否已经注册，注册过才允许登录（查询consumer表）
        // 2.校验验证码：从redis取出验证码，和请求的验证码比较
        // 3.登录成功后删除redis缓存的验证码
        return null;
    }


}
