package com.ygq.edu.controller.admin;

import com.ygq.edu.controller.VideoController;
import com.ygq.edu.domain.Video;
import com.ygq.edu.service.VideoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员相关方法
 *
 * @author ythawed
 * @date 2019/12/24 0024
 */
@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {

    private static Logger LOG = LoggerFactory.getLogger(VideoController.class);

    @Autowired
    private VideoService videoService;

    /**
     * 添加video
     *
     * @param video 接收请求参数。不需要注解@RequestBody。因为请求参数名称与实体类属性完全一一对应
     *              这里使用了mybatis获取自增id，见mapper注解
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public Integer save(@RequestBody Video video) {

        LOG.info("新增video，video={}", video);
        int save = videoService.save(video);
        LOG.info("新增video，数据库自增的id={}", video.getId());
        return save;
    }
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Integer update(@RequestBody Video video) {
        //更新不需要先查data，只需要创建新对象，
        // 只需设置需要更新的属性即可，mybatis会自动更新属性。
        return videoService.update(video);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public Integer delete(@PathVariable Integer id) {

        return videoService.delete(id);
    }
}
