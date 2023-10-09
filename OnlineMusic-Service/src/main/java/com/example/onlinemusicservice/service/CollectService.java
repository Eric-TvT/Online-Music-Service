package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.Collect;
import com.example.onlinemusicservice.model.request.CollectRequest;

/**
 * 收藏接口-（service层接口）
 */
public interface CollectService extends IService<Collect> {
    /**
     * 通过userid去查询用户收藏的列表数据接口
     * @param userId
     * @return
     */
    public R collectionOfUser(Integer userId);

    /**
     * 用户添加收藏歌曲
     * @param addCollectRequest
     * @return
     */
    public R addCollectionOfUser(CollectRequest addCollectRequest);

    /**
     * 用户取消收藏歌曲
     */
    public R  deleteCollect(Integer userId,Integer songId);

    /**
     * 查看是否收藏
     * @param isCollectRequest
     * @return
     */
    public R  existSongId(CollectRequest isCollectRequest);
}

