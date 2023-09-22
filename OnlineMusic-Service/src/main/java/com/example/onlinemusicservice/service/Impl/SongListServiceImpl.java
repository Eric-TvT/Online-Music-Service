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
        //给出默认头像,后续管理员可以在线修改
        String pic = "/img/songListPic/default.jpg";
        songList.setPic(pic);
        //将数据插入数据库
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
        // 先判断服务端的数据是否存在
        SongList obj = songListMapper.selectById(id);
        if (obj==null){
            return R.success("数据不存在");
        }else {
            if (songListMapper.deleteById(id) > 0) {
                return R.success("删除成功");
            } else {
                return R.error("删除失败");
            }
        }

    }

    /**
     * 更新歌单
     * @param updateSongListRequest
     * @return
     */
    @Override
    public R updateSongList(SongListRequest updateSongListRequest) {
        // 先判断服务端的数据是否存在
        SongList obj = songListMapper.selectById(updateSongListRequest.getId());
        if (obj==null){
            return R.success("数据不存在");
        }else{
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
    /**
     * TODO 这块就是前端显现相应的歌单list
     * 前后联调首页中歌单搜索栏功能 // 返回标题包含文字的歌单
     * @param title
     * @return
     */
    @Override
    public R likeTitle(String title) {
        QueryWrapper<SongList> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("title",title);
        return R.success("查询成功", songListMapper.selectList(queryWrapper));
    }
    /**
     * 客户端 歌单根据风格查询
     * 返回指定类型的歌单
     * @param style
     * @return
     */
    @Override
    public R songListOfStyle(String style) {
        QueryWrapper<SongList> queryWrapper = null;
        if(!"全部歌单".equals(style)){
            queryWrapper = new QueryWrapper<>();
            queryWrapper.like("style",style);
        }
        return R.success("查询成功",songListMapper.selectList(queryWrapper));
    }

}
