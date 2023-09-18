package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.SongListMapper;
import com.example.onlinemusicservice.model.domain.SongList;
import com.example.onlinemusicservice.model.request.SongListRequest;
import com.example.onlinemusicservice.service.SongListService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * admin-歌单管理接口（service层接口实现类）
 */
@Service
public class SongListServiceImpl extends ServiceImpl<SongListMapper, SongList> implements SongListService {
    @Autowired
    private SongListMapper songListMapper;
    /**
     * 查询歌单列表
     *
     * @return
     */
    @Override
    public R songList(String style) {
        //定义查询条件
        QueryWrapper<SongList> queryWrapper=null;
        //判断查询的参数是否为空
        if(StringUtils.isNoneBlank(style)){
            queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("style",style);
        }
        return R.success("查询成功",songListMapper.selectList(queryWrapper));
    }

    /**
     * 添加歌单
     * @param addSongListRequest
     * @return
     */
    @Override
    public R addSongList(SongListRequest addSongListRequest) {
        SongList songList = new SongList();
        //属性复制
        BeanUtils.copyProperties(addSongListRequest, songList);
        if (songListMapper.insert(songList) > 0) {
            return R.success("添加成功");
        } else {
            return R.error("添加失败");
        }
    }
    /**
     * 删除歌单-----当个删除和批量删除调用多个单个删除
     * @param id
     * @return
     */
    public R deleteSongList(Integer id) {
        if (songListMapper.deleteById(id) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");
        }
    }

    /**
     * 更新歌单
     * @param updateSongListRequest
     * @return
     */
    @Override
    public R updateSongList(SongListRequest updateSongListRequest) {
        SongList songList = new SongList();
        //属性复制
        BeanUtils.copyProperties(updateSongListRequest, songList);
        if (songListMapper.updateById(songList)>0){
            return R.success("更新成功");
        }else {
            return R.success("更新失败");
        }

    }


}
