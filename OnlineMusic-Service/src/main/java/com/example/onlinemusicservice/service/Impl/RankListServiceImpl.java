package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.RankListMapper;
import com.example.onlinemusicservice.model.domain.RankList;
import com.example.onlinemusicservice.model.request.RankListRequest;
import com.example.onlinemusicservice.service.RankListService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 评价歌单接口（service层接口实现类）
 */
@Service
public class RankListServiceImpl extends ServiceImpl<RankListMapper, RankList> implements RankListService {

    @Autowired
    private RankListMapper rankListMapper;
    /**
     * @Description: 歌单评价
     * @CreateTime:
     * @param: rankListAddRequest 歌单评价请求模型类
     * @return: cn.com.niit.online.music.common.R
     */
    @Override
    public R addRank(RankListRequest rankListAddRequest) {
        RankList rankList = new RankList();
        BeanUtils.copyProperties(rankListAddRequest, rankList);
        if (rankListMapper.insert(rankList) > 0) {
            return R.success("评价成功");
        } else {
            return R.error("评价失败");
        }
    }
    /**
     * 根据歌单id查询歌单评分（评分=总分/数量）
     * 取指定歌单的评分
     * @param songListId
     * @return
     */
    @Override
    public R rankOfSongListId(long songListId) {
        //1.根据歌单id查询所有评分列表数据
        QueryWrapper<RankList> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("song_list_id",songListId);
        List<RankList> rankLists=rankListMapper.selectList(queryWrapper);
        //2.遍历得到评分列表中的分数score，并进行求和
        int count =rankLists.size();
        int sum =0;
        for (RankList item : rankLists){
            int score =item.getScore();
            sum += score;
        }
        //3.计算歌单的平均
        System.out.println("sum="+sum);
        System.out.println("count="+count);
        double avg =sum/count;
        return R.success("综合评分",avg);

    }
    /**
     * 获取根据歌单ID和用户ID获取评分
     * @param consumerId
     * @param songListId
     * @return
     */
    @Override
    public R getRankScroe(long consumerId, long songListId) {
        QueryWrapper<RankList> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("consumer_id", consumerId);
        queryWrapper.eq("song_list_id", songListId);
        List<RankList> rankLists = rankListMapper.selectList(queryWrapper);
        return R.success(null, rankLists.get(0).getScore());
    }

}

