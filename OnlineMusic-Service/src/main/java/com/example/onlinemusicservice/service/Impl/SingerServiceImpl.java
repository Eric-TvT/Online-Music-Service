package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.SingerMapper;
import com.example.onlinemusicservice.model.domain.Singer;
import com.example.onlinemusicservice.model.request.SingerRequest;
import com.example.onlinemusicservice.service.SingerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * admin-歌手管理（service层接口实现类）
 */
@Service
public class SingerServiceImpl extends ServiceImpl<SingerMapper, Singer> implements SingerService {

    @Autowired
    SingerMapper singerMapper;

    /**
     * 查询歌手
     * @return
     */
    @Override
    public R allSinger() {
        return R.success("查询成功", singerMapper.selectList(null));
    }

    /**
     * 添加歌手
     * @param addSingerRequest
     * @return
     */
    @Override
    public R addSinger(SingerRequest addSingerRequest) {
        Singer singer = new Singer();
        //属性复制
        BeanUtils.copyProperties(addSingerRequest, singer);
        //给出默认头像,后续管理员可以在线修改
        String pic = "https://java-pp.oss-cnhangzhou.aliyuncs.com/img/singerPic/user.jpg";
        singer.setPic(pic);
        //将数据插入数据库
        if (singerMapper.insert(singer) > 0) {
            return R.success("添加成功");
        } else {
            return R.error("添加失败");
        }
    }

    /**
     * 删除歌手
     * @param id
     * @return
     */
    @Override
    public R deleteSinger(Integer id) {
        if (singerMapper.deleteById(id) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    /**
     * 批量删除歌手
     * @param ids
     * @return
     */
    @Override
    public R deleteSingers(String[] ids) {
        //把数组转成字符串
        //把数组中参数组织成SQL语句需要的格式
        StringBuffer sb = new StringBuffer();
        for (String i : ids) {
            sb.append(i + ",");
        }
        //截掉最后一个逗号
        sb.deleteCharAt(sb.length() - 1);
        if (singerMapper.deleteByIds(sb.toString()) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    /**
     * 更新歌手信息
     * @param updateSingerRequest
     * @return
     */
    @Override
    public R updateSingerMsg(SingerRequest updateSingerRequest) {
        Singer singer = new Singer();
        BeanUtils.copyProperties(updateSingerRequest, singer);
        if (singerMapper.updateById(singer) > 0) {
            return R.success("修改成功");
        } else {
            return R.error("修改失败");
        }
    }

    /**
     * 更新歌手图片
     * @param urlFile 上传的歌手图片
     * @param id 歌手id
     * @return
     */
    @Override
    public R updateSingerPic(MultipartFile urlFile, int id) {
        //将图片保存到服务端
        String fileName = System.currentTimeMillis() + "-" + urlFile.getOriginalFilename();
        //得到项目根路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "singerPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            if (!file1.mkdir()) {
                return R.fatal("创建文件夹失败");
            }
        }
        //在相应目录下创建文件
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storeUrlPath = "/img/singerPic/" + fileName;
        try {
            urlFile.transferTo(dest);
            System.out.println("文件存储路径：" + dest.getAbsolutePath());
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        //更新图片中的地址
        Singer singer = new Singer();
        singer.setId(id);
        //song.setPic(ossPath);
        singer.setPic(storeUrlPath);
        //设置更新的时间位系统当前时间
        //singer.setUpdateTime(new Date());
        int i =singerMapper.updateById(singer);
        if (i>0){
            return R.success("上传成功", storeUrlPath);
        } else {
            return R.error("上传失败");
        }
    }


}