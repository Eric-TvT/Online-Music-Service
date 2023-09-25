package com.example.onlinemusicservice.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.mapper.SongMapper;
import com.example.onlinemusicservice.model.domain.Song;
import com.example.onlinemusicservice.model.request.SongRequest;
import com.example.onlinemusicservice.service.SongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * admin-歌手管理-歌曲管理（mapper层接口实现类）
 */
@Service
public class SongServiceImpl extends ServiceImpl<SongMapper, Song> implements SongService {
    @Autowired
    private SongMapper songMapper;

    @Override
    public R selectSongsBySingerId(int singerId) {
        // 根据歌手ID查询歌曲 select * from song where singer_id = 1
        // 定义查询条件
        //调用Mapper去完成基础的查询功能
        //1.使用QueryWrapper设置查询条件
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("singer_id", singerId);
        // 调用mybatis提供的查询方法
        //  2.调用mybatis提供的查询列表的方法
        return R.success("查询成功", songMapper.selectList(queryWrapper));
    }

    /**
     * 更新歌曲
     *
     * @param updateSongRequest
     * @return
     */
    @Override
    public R updateSong(SongRequest updateSongRequest) {
        //先去获取服务端的歌曲信息，判断歌曲是否存在在进行赋值
        Song song = songMapper.selectById(updateSongRequest.getId());
        if (song != null) {
            // BeanUtils.copyProperties(updateSongRequest, song);
            song.setName(updateSongRequest.getName());
            song.setIntroduction(updateSongRequest.getIntroduction());
            song.setLyric(updateSongRequest.getLyric());
            if (songMapper.updateById(song) > 0) {
                return R.success("更新成功");
            } else {
                return R.error("更新失败");
            }
        } else {
            return R.error("歌曲不存在");
        }

    }

    /**
     * 删除歌曲
     *
     * @param id
     * @return
     */
    @Override
    public R deleteSong(Integer id) {
        if (songMapper.deleteById(id) > 0) {
            return R.success("删除成功");
        } else {
            return R.error("删除失败");

        }
    }

    /**
     * @param addSongRequest
     * @param mpfile         表示文件二进制流
     * @return
     */
    @Override
    public R addSong(SongRequest addSongRequest, MultipartFile mpfile) {
        Song song = new Song();
        BeanUtils.copyProperties(addSongRequest, song);

        //将普通文件转为二进制流保存起来
        String pic = "/img/songPic/tubiao.jpg";
        String fileName = System.currentTimeMillis() + "-" + mpfile.getOriginalFilename();
        //得到项目根目录路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "song";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            if (!file1.mkdir()) {
                return R.fatal("创建文件失败");
            }
        }
        //在相应的目录下创建文件
        File dest = new File(filePath + System.getProperty("file.separator") +
                fileName);
        String storeUrlPath = "/song/" + fileName;
        try {
            mpfile.transferTo(dest);
            System.out.println("文件存储路径：" + dest.getAbsolutePath());
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        //设置操作的创建时间和更新时间为当前系统时间
        song.setCreateTime(new Date());
        song.setUpdateTime(new Date());

        song.setPic(pic);
        song.setUrl(storeUrlPath);

//        song.setUrl("测试url");
//        //图片测试
//        song.setPic("https://pic.netbian.com/uploads/allimg/230914/195054-1694692254c27f.jpg");
        //插入到数据库
        int i = songMapper.insert(song);
        if (i > 0) {
            return R.success("添加成功");
        } else {
            return R.success("添加失败");
        }

    }

    /**
     * 更新图片
     * @param urlFile 上传的图片文件
     * @param id      歌曲id
     * @return
     */
    @Override
    public R updateSongPic(MultipartFile urlFile, int id) {
        //将图片保存到服务端
        String fileName = System.currentTimeMillis() + "-" + urlFile.getOriginalFilename();
        //得到项目根路径
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "songPic";
        File file1 = new File(filePath);
        if (!file1.exists()) {
            if (!file1.mkdir()) {
                return R.fatal("创建文件夹失败");
            }
        }
        //在相应目录下创建文件
        File dest = new File(filePath + System.getProperty("file.separator") +
                fileName);
        String storeUrlPath = "/img/songPic/" + fileName;
        try {
            urlFile.transferTo(dest);
            System.out.println("文件存储路径：" + dest.getAbsolutePath());
        } catch (IOException e) {
            return R.fatal("上传失败" + e.getMessage());
        }
        //更新图片中的地址
        Song song = new Song();
        song.setId(id);
        //song.setPic(ossPath);
        song.setPic(storeUrlPath);
        //设置更新的时间位系统当前时间
        song.setUpdateTime(new Date());
        if (songMapper.updateById(song) > 0) {
            return R.success("上传成功", storeUrlPath);
        } else {
            return R.error("上传失败");
        }

    }


    /**TODO admin-首页歌曲总数
     * 首页歌曲总数
     * @return
     */
    @Override
    public R allSong() {
        return R.success(null, songMapper.selectList(null));
    }



    /**
     * 用户端首页搜歌曲（模糊）
     * 根据name查询歌曲信息
     * @param name
     * @return
     */
    @Override
    public R songOfSingerName(String name) {
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name",name);
        return R.success("查询成功",songMapper.selectList(queryWrapper));
    }

    /**
     * 根据id查询歌曲信息
     * @param id
     * @return
     */
    @Override
    public R getSongDetail(int id) {
        QueryWrapper<Song> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        return R.success(null,songMapper.selectList(queryWrapper));
    }


}
