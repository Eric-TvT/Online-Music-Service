package com.example.onlinemusicservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.domain.RankList;
import com.example.onlinemusicservice.model.request.RankListRequest;
/**
 * 评价歌单接口(Service层)
 */
public interface RankListService extends IService<RankList> {
    /**
     * 评价歌单
     */
    public R addRank(RankListRequest rankListAddRequest);
    /**
     * 根据歌单id查询歌单评分（评分=总分/数量）
     * 取指定歌单的评分
     * @param songListId
     * @return
     */
    public R rankOfSongListId(long songListId);
    /**
     * 获取根据歌单ID和用户ID获取评分
     * @param consumerId
     * @param songListId
     * @return
     */
    R getRankScroe(long consumerId,long songListId);
}