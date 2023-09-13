package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Singer;
import com.example.onlinemusicservice.model.request.SingerRequest;

/**
 * admin-歌手管理（service层接口）
 */
public interface SingerService extends IService<Singer> {
    /**
     * 查询歌手接口
     * @return
     */
    R allSinger();

    /**
     * 添加歌手接口
     * @param addSingerRequest
     * @return
     */
    R addSinger (SingerRequest addSingerRequest);

    /**
     * 删除歌手接口
     * @param id
     * @return
     */
    R deleteSinger(Integer id);

    /**
     * 批量删除歌手接口
     * @param ids
     * @return
     */
    R deleteSingers(String[] ids);

    /**
     * 更新歌手信息接口
     * @param updateSingerRequest
     * @return
     */
    R updateSingerMsg(SingerRequest updateSingerRequest);


}

