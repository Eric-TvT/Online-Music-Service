package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Singer;
import com.example.onlinemusicservice.model.request.SingerRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * admin-歌手管理（service层接口）
 */
public interface SingerService extends IService<Singer> {
    /**
     * 查询歌手接口
     * @return
     */
    public R allSinger();

    /**
     * 添加歌手接口
     * @param addSingerRequest
     * @return
     */
    public R addSinger (SingerRequest addSingerRequest);

    /**
     * 删除歌手接口
     * @param id
     * @return
     */
    public R deleteSinger(Integer id);

    /**
     * 批量删除歌手接口
     * @param ids
     * @return
     */
    public R deleteSingers(String[] ids);

    /**
     * 更新歌手信息接口
     * @param updateSingerRequest
     * @return
     */
    public R updateSingerMsg(SingerRequest updateSingerRequest);

    /**
     * 更新歌手图片
     * @param urlFile 上传的歌手图片
     * @param id 歌手id
     * @return
     */
    //public R updateSingerPic(MultipartFile urlFile,int id);------上传 到本地
    public R updateSingerPic(MultipartFile urlFile,int id);
}

