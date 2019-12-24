package com.ygq.edu.controller;

import com.ygq.edu.domain.Video;
import com.ygq.edu.mapper.VideoMapper;
import com.ygq.edu.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ythawed
 * @date 2019/12/21 0021
 */
@Controller
@RequestMapping("/api/v1/video")
public class VideoController {

    private static Logger LOG = LoggerFactory.getLogger(VideoController.class);

    @Autowired(required = false)
    private VideoService videoService;

    /**
     * 添加video
     *
     * @param video 接收请求参数。不需要注解@RequestBody。因为请求参数名称与实体类属性完全一一对应
     *              这里使用了mybatis获取自增id，见mapper注解
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public Integer save(Video video) {

        LOG.info("新增video，video={}", video);
        int save = videoService.save(video);
        LOG.info("新增video，数据库自增的id={}", video.getId());
        return save;
    }

    /**
     * 对于不同的请求方式，可以使用对应的已封装的注解名称mapping，如GetMapping
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public List<Video> findAllVideos() {
        return videoService.findAll();
    }

    //    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
//    @ResponseBody
    @GetMapping("/{id}")
    @ResponseBody
    public Video findOne(@PathVariable(value = "id") Integer id) {
        LOG.info("根据id查询视频，id={}", id);
        Video video = videoService.findById(id);
        LOG.info("根据id查询视频，结果={}", video);
        return video;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Integer update(int videoId, String title) {
        //更新不需要先查data，只需要创建新对象，
        // 只需设置需要更新的属性即可，mybatis会自动更新属性。
//        Video video = videoService.findById(videoId);
        Video video = new Video();
        video.setId(videoId);
        video.setTitle(title);
        return videoService.update(video);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Integer delete(@PathVariable Integer id) {

        return videoService.delete(id);
    }


}
