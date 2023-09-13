package com.example.onlinemusicservice.controller;

import com.example.onlinemusicservice.common.R;
import com.example.onlinemusicservice.model.request.SingerRequest;
import com.example.onlinemusicservice.service.SingerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * admin-歌手管理控制类（controller层）
 */
@RestController
public class SingerController {
    @Autowired
    private SingerService singerService;

    /**
     * 查询歌手
     * @return
     */
    @GetMapping("/singer")
    public R allSinger(){
        return singerService.allSinger();
    }

    /**
     * 添加歌手
     * @param singerRequest
     * @return
     */
    @PostMapping("/singer/add")
    public R addSinger(@RequestBody SingerRequest singerRequest){
        return singerService.addSinger(singerRequest);
    }

    /**
     * 根据id删除歌手
     * @param id
     * @return
     */
    @DeleteMapping("/singer/delete")
    public R deleteSinger(@RequestParam int id){
        return singerService.deleteSinger(id);
    }

    /**
     * 批量删除歌手
     * @param id
     * @return
     */
    @DeleteMapping("singer/deleteIds")
    public R deleteSingers(@RequestParam String[] id) {
        return singerService.deleteSingers(id);
    }

    /**
     * 更新歌手
     * @param singerRequest
     * @return
     */
    @PostMapping("/singer/update")
    public R updateSinger(@RequestBody SingerRequest singerRequest){
        return singerService.updateSingerMsg(singerRequest);
    }
}

